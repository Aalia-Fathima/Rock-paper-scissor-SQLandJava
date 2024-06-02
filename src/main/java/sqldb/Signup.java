package sqldb;
import io.github.cdimascio.dotenv.Dotenv;
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
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JLabel headingLabel = new JLabel("SignUp");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setBounds(600, 200, 100, 25);
        add(headingLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(500, 250, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(600, 250, 150, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(500, 300, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(600, 300, 150, 25);
        add(passwordField);

        signupButton = new JButton("SignUp");
        signupButton.setBounds(600, 350, 100, 25);
        signupButton.addActionListener(this);
        add(signupButton);

        JLabel signLabel = new JLabel("already logged in?");
        signLabel.setBounds(600, 380, 300, 30);
        add(signLabel);

        final JLabel signupNavLabel = new JLabel("LogIn");
        signupNavLabel.setBounds(630, 400, 50, 50);
        signupNavLabel.setForeground(Color.BLUE);
        signupNavLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginFrame LoginPage = new LoginFrame();
                LoginPage.setVisible(true);
                dispose();
            }

            public void mouseEntered(MouseEvent e) {
                signupNavLabel.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signupNavLabel.setForeground(Color.BLUE);
            }

        });
        add(signupNavLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            final String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (validateSignup(username, password) == 1) {
                signupButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // enter enteredPage = new enter(username);
                        // enteredPage.setVisible(true);
                        stone stonePage = new stone(username);
                        stonePage.setVisible(true);
                        dispose();
                    }
                });
            } else if (validateSignup(username, password) == 2) {
                JOptionPane.showMessageDialog(this, "Username already exists!!!");
            } else if (validateSignup(username, password) == 0) {
                JOptionPane.showMessageDialog(this, "Enter the details!!!");
            }
        }
    }

    private int validateSignup(String username, String password) {
        try {
            Dotenv dotenv = Dotenv.load();
            String url = dotenv.get("LINK");
            String dbuser = dotenv.get("DBUSER");
            String paword = dotenv.get("PASS");
            Connection con = DriverManager.getConnection(url, dbuser, paword);
            // Statement stmt = con.createStatement();
            // Create a PreparedStatement for insertion
            String sql = "INSERT INTO signup (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            // Set values for parameters in the PreparedStatement
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            // Execute the insertion query
            if ((username.isEmpty() || password.isEmpty()) | (username.isEmpty() && password.isEmpty())) {
                return 0;
            } else {
                int rowsInserted = preparedStatement.executeUpdate();
                // Check if the insertion was successful
                if (rowsInserted > 0) {
                    // System.out.println("A new user has been inserted successfully.");
                    return 1;
                } else {
                    return 2;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 2;
        }
    }
}