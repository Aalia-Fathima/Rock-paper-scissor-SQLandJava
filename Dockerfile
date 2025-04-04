# Use Ubuntu as the base image
FROM ubuntu:22.04

# Set timezone to avoid interactive prompt during package installation
ENV DEBIAN_FRONTEND=noninteractive
RUN ln -fs /usr/share/zoneinfo/UTC /etc/localtime && \
    apt-get update && apt-get install -y tzdata && \
    dpkg-reconfigure --frontend noninteractive tzdata

# Install dependencies
RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    x11vnc \
    xvfb \
    fluxbox \
    wget \
    git \
    novnc \
    websockify \
    maven \
    xterm \
    && rm -rf /var/lib/apt/lists/*

# Set up noVNC
RUN git clone https://github.com/novnc/noVNC.git /opt/noVNC \
    && git clone https://github.com/novnc/websockify /opt/noVNC/utils/websockify \
    && ln -s /opt/noVNC/vnc.html /opt/noVNC/index.html

# Copy the entire project into the container
COPY . /app
WORKDIR /app

# Compile the Java project using Maven
RUN mvn clean package

# Set up VNC and noVNC
RUN mkdir ~/.vnc \
    && x11vnc -storepasswd 1234 ~/.vnc/passwd \
    && chmod 600 ~/.vnc/passwd

# Set DISPLAY environment variable
ENV DISPLAY=:1

# Expose the noVNC port
EXPOSE 6080

# Start the VNC server and noVNC
CMD ["sh", "-c", "(Xvfb :1 -screen 0 1024x768x16 &) && \
    (fluxbox &) && \
    (x11vnc -display :1 -forever -usepw -shared -rfbport 5901 &) && \
    (/opt/noVNC/utils/novnc_proxy --vnc localhost:5901 --listen 6080 &) && \
    (java -cp /app/target/testdb-1.0-SNAPSHOT.jar:/app/mysql-connector-j-8.0.33.jar sqldb.App)"]
