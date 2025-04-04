// package sqldb;

// // import io.github.cdimascio.dotenv.Dotenv;
// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;

// public class Signup extends JFrame implements ActionListener {
//     private JTextField usernameField;
//     private JPasswordField passwordField;
//     private JButton signupButton;

//     public Signup() {

//         setTitle("SignUp");
//         // setExtendedState(JFrame.MAXIMIZED_BOTH);
//         setSize(1024, 768); // Set the size explicitly
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(null);
//         setResizable(false);

//         JLabel headingLabel = new JLabel("SignUp");
//         headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         headingLabel.setBounds(600, 200, 100, 25);
//         add(headingLabel);

//         JLabel usernameLabel = new JLabel("Username:");
//         usernameLabel.setBounds(500, 250, 80, 25);
//         add(usernameLabel);

//         usernameField = new JTextField();
//         usernameField.setBounds(600, 250, 150, 25);
//         add(usernameField);

//         JLabel passwordLabel = new JLabel("Password:");
//         passwordLabel.setBounds(500, 300, 80, 25);
//         add(passwordLabel);

//         passwordField = new JPasswordField();
//         passwordField.setBounds(600, 300, 150, 25);
//         add(passwordField);

//         signupButton = new JButton("SignUp");
//         signupButton.setBounds(600, 350, 100, 25);
//         signupButton.addActionListener(this);
//         add(signupButton);

//         JLabel signLabel = new JLabel("already logged in?");
//         signLabel.setBounds(600, 380, 300, 30);
//         add(signLabel);

//         final JLabel signupNavLabel = new JLabel("LogIn");
//         signupNavLabel.setBounds(630, 400, 50, 50);
//         signupNavLabel.setForeground(Color.BLUE);
//         signupNavLabel.addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseClicked(MouseEvent e) {
//                 LoginFrame LoginPage = new LoginFrame();
//                 LoginPage.setVisible(true);
//                 dispose();
//             }

//             public void mouseEntered(MouseEvent e) {
//                 signupNavLabel.setForeground(Color.RED);
//             }

//             @Override
//             public void mouseExited(MouseEvent e) {
//                 signupNavLabel.setForeground(Color.BLUE);
//             }

//         });
//         add(signupNavLabel);

//         setVisible(true);
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource() == signupButton) {
//             final String username = usernameField.getText();
//             String password = new String(passwordField.getPassword());
//             if (validateSignup(username, password) == 1) {
//                 signupButton.addMouseListener(new MouseAdapter() {
//                     @Override
//                     public void mouseClicked(MouseEvent e) {
//                         // enter enteredPage = new enter(username);
//                         // enteredPage.setVisible(true);
//                         stone stonePage = new stone(username);
//                         stonePage.setVisible(true);
//                         dispose();
//                     }
//                 });
//             } else if (validateSignup(username, password) == 2) {
//                 JOptionPane.showMessageDialog(this, "Username already exists!!!");
//             } else if (validateSignup(username, password) == 0) {
//                 JOptionPane.showMessageDialog(this, "Enter the details!!!");
//             }
//         }
//     }

//     private int validateSignup(String username, String password) {
//         try {
//             // Dotenv dotenv = Dotenv.load();
//             // String url = dotenv.get("LINK");
//             // String dbuser = dotenv.get("DBUSER");
//              // String paword = dotenv.get("PASS");
//              String url = "jdbc:mysql://" +System.getenv("DB_HOST") + ":" + System.getenv("DB_PORT") + "/"
//              + System.getenv("DB_NAME");
//      String dbuser = System.getenv("DB_USER");
//      String paword = System.getenv("DB_PASSWORD");

//             Connection con = DriverManager.getConnection(url, dbuser, paword);
//             // Statement stmt = con.createStatement();
//             // Create a PreparedStatement for insertion
//             String sql = "INSERT INTO signup (username, password) VALUES (?, ?)";
//             PreparedStatement preparedStatement = con.prepareStatement(sql);
//             // Set values for parameters in the PreparedStatement
//             preparedStatement.setString(1, username);
//             preparedStatement.setString(2, password);
//             // Execute the insertion query
//             if ((username.isEmpty() || password.isEmpty()) | (username.isEmpty() && password.isEmpty())) {
//                 return 0;
//             } else {
//                 int rowsInserted = preparedStatement.executeUpdate();
//                 // Check if the insertion was successful
//                 if (rowsInserted > 0) {
//                     // System.out.println("A new user has been inserted successfully.");
//                     return 1;
//                 } else {
//                     return 2;
//                 }
//             }

//         } catch (SQLException e) {
//             e.printStackTrace();
//             return 2;
//         }
//     }
// }



// package sqldb;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;

// public class Signup extends JFrame implements ActionListener {
//     private JTextField usernameField;
//     private JPasswordField passwordField;
//     private JButton signupButton;

//     public Signup() {
//         setTitle("SignUp");
//         setSize(1024, 768);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(null);
//         setResizable(false);

//         JLabel headingLabel = new JLabel("SignUp");
//         headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         headingLabel.setBounds(600, 200, 100, 25);
//         add(headingLabel);

//         JLabel usernameLabel = new JLabel("Username:");
//         usernameLabel.setBounds(500, 250, 80, 25);
//         add(usernameLabel);

//         usernameField = new JTextField();
//         usernameField.setBounds(600, 250, 150, 25);
//         add(usernameField);

//         JLabel passwordLabel = new JLabel("Password:");
//         passwordLabel.setBounds(500, 300, 80, 25);
//         add(passwordLabel);

//         passwordField = new JPasswordField();
//         passwordField.setBounds(600, 300, 150, 25);
//         add(passwordField);

//         signupButton = new JButton("SignUp");
//         signupButton.setBounds(600, 350, 100, 25);
//         signupButton.addActionListener(this);
//         add(signupButton);

//         JLabel signLabel = new JLabel("Already logged in?");
//         signLabel.setBounds(600, 380, 300, 30);
//         add(signLabel);

//         final JLabel signupNavLabel = new JLabel("LogIn");
//         signupNavLabel.setBounds(630, 400, 50, 50);
//         signupNavLabel.setForeground(Color.BLUE);
//         signupNavLabel.addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseClicked(MouseEvent e) {
//                 LoginFrame loginPage = new LoginFrame();
//                 loginPage.setVisible(true);
//                 dispose();
//             }

//             @Override
//             public void mouseEntered(MouseEvent e) {
//                 signupNavLabel.setForeground(Color.RED);
//             }

//             @Override
//             public void mouseExited(MouseEvent e) {
//                 signupNavLabel.setForeground(Color.BLUE);
//             }
//         });
//         add(signupNavLabel);

//         setVisible(true);
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource() == signupButton) {
//             String username = usernameField.getText().trim();
//             String password = new String(passwordField.getPassword()).trim();

//             int result = validateSignup(username, password);

//             if (result == 1) {
//                 JOptionPane.showMessageDialog(this, "SignUp Successful!");
//                 stone stonePage = new stone(username);
//                 stonePage.setVisible(true);
//                 dispose();
//             } else if (result == 2) {
//                 JOptionPane.showMessageDialog(this, "Username already exists!");
//             } else {
//                 JOptionPane.showMessageDialog(this, "Enter valid details!");
//             }
//         }
//     }

//     private int validateSignup(String username, String password) {
//         if (username.isEmpty() || password.isEmpty()) {
//             return 0; // Missing details
//         }

//         try {
//             // Load MySQL JDBC Driver
//             Class.forName("com.mysql.cj.jdbc.Driver");

//             // Database credentials from environment variables
//             String url = "jdbc:mysql://" + System.getenv("DB_HOST") + ":" + System.getenv("DB_PORT") + "/"
//                     + System.getenv("DB_NAME") + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
//             String dbUser = System.getenv("DB_USER");
//             String dbPassword = System.getenv("DB_PASSWORD");

//             try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword)) {
//                 // Check if the username already exists
//                 String checkUserSQL = "SELECT COUNT(*) FROM signup WHERE username = ?";
//                 try (PreparedStatement checkStmt = con.prepareStatement(checkUserSQL)) {
//                     checkStmt.setString(1, username);
//                     ResultSet rs = checkStmt.executeQuery();
//                     if (rs.next() && rs.getInt(1) > 0) {
//                         return 2; // Username exists
//                     }
//                 }

//                 // Insert new user
//                 String sql = "INSERT INTO signup (username, password) VALUES (?, ?)";
//                 try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
//                     preparedStatement.setString(1, username);
//                     preparedStatement.setString(2, password);
//                     int rowsInserted = preparedStatement.executeUpdate();
//                     return (rowsInserted > 0) ? 1 : 0;
//                 }
//             }
//         } catch (ClassNotFoundException e) {
//             JOptionPane.showMessageDialog(this, "MySQL Driver not found!", "Error", JOptionPane.ERROR_MESSAGE);
//             e.printStackTrace();
//             return 0;
//         } catch (SQLException e) {
//             JOptionPane.showMessageDialog(this, "Database connection error!", "Error", JOptionPane.ERROR_MESSAGE);
//             e.printStackTrace();
//             return 2;
//         }
//     }
// }




package sqldb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signupButton;

    public Signup() {
        setTitle("SignUp");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel headingLabel = new JLabel("SignUp");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(headingLabel, gbc);

        gbc.gridy++;
        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel, gbc);

        gbc.gridy++;
        usernameField = new JTextField(15);
        add(usernameField, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField(15);
        add(passwordField, gbc);

        gbc.gridy++;
        signupButton = new JButton("SignUp");
        signupButton.addActionListener(this);
        add(signupButton, gbc);

        gbc.gridy++;
        JLabel signLabel = new JLabel("Already logged in?");
        add(signLabel, gbc);

        gbc.gridy++;
        final JLabel loginNavLabel = new JLabel("Log In");
        loginNavLabel.setForeground(Color.BLUE);
        loginNavLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginNavLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginFrame().setVisible(true);
                dispose();
            }

            public void mouseEntered(MouseEvent e) {
                loginNavLabel.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginNavLabel.setForeground(Color.BLUE);
            }
        });
        add(loginNavLabel, gbc);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            int validation = validateSignup(username, password);
            if (validation == 1) {
                new stone(username).setVisible(true);
                dispose();
            } else if (validation == 2) {
                JOptionPane.showMessageDialog(this, "Username already exists!!!");
            } else {
                JOptionPane.showMessageDialog(this, "Enter the details!!!");
            }
        }
    }

    private int validateSignup(String username, String password) {
        try {
            String url = "jdbc:mysql://" + System.getenv("DB_HOST") + ":" + System.getenv("DB_PORT") + "/" + System.getenv("DB_NAME");
            String dbUser = System.getenv("DB_USER");
            String dbPassword = System.getenv("DB_PASSWORD");

            if (username.isEmpty() || password.isEmpty()) {
                return 0;
            }

            Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
            String sql = "INSERT INTO signup (username, password) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0 ? 1 : 2;
        } catch (SQLException e) {
            return 2;
        }
    }
}
