// package sqldb;

// import java.sql.SQLException;
// import javax.swing.ImageIcon;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import java.awt.Font;
// import java.awt.event.*;

// public class App extends JFrame {
//     public App() {
//         setTitle("Stone paper scissor Page");
//         setSize(1024, 768); // Set the size explicitly
//         // setExtendedState(JFrame.MAXIMIZED_BOTH);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(null);
//         setResizable(false);
//         final ImageIcon image1 = new ImageIcon("/app/src/main/resources/sqldb/stonelogo.png");
//         final ImageIcon image2 = new ImageIcon("/app/src/main/resources/sqldb/play.png");
//         // final ImageIcon image1 = new ImageIcon(getClass().getResource("stonelogo.png"));
//         // final ImageIcon image2 = new ImageIcon(getClass().getResource("play.png"));
//         final JLabel label = new JLabel(image1);
//         label.setBounds(600, 150, 250, 300);
//         add(label);
//         JLabel playJLabel = new JLabel("Play");
//         playJLabel.setFont(new Font("Arial", Font.BOLD, 30));
//         playJLabel.setBounds(700, 450, 100, 30);
//         add(playJLabel);
//         final JLabel label1 = new JLabel(image2);
//         label1.setBounds(680, 470, 100, 100);
//         add(label1);
//         label1.addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseClicked(MouseEvent e) {
//                 LoginFrame logPage = new LoginFrame();
//                 logPage.setVisible(true);
//                 dispose();
//             }
//         });
//         setVisible(true);
//     }

//     public static void main(String[] args) throws SQLException {
//         System.out.println("something");
//         // JFrame frame = new JFrame("Hello World");
//         // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         // frame.setSize(300, 200);
//         // frame.setVisible(true);
//         new App();
//     }
// }



package sqldb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {
    public App() {
        setTitle("Stone Paper Scissor");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon image1 = new ImageIcon("src/main/resources/sqldb/stonelogo.png");
        ImageIcon image2 = new ImageIcon("src/main/resources/sqldb/play.png");

        JLabel logoLabel = new JLabel(image1);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(logoLabel);

        JLabel playLabel = new JLabel("Play");
        playLabel.setFont(new Font("Arial", Font.BOLD, 30));
        playLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(playLabel);

        JLabel playButton = new JLabel(image2);
        playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(playButton);

        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginFrame loginPage = new LoginFrame();
                loginPage.setVisible(true);
                dispose();
            }
        });

        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}

