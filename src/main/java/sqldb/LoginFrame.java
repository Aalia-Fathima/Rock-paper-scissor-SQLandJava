package sqldb;
import javax.swing.*;
import io.github.cdimascio.dotenv.Dotenv;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    public LoginFrame() {
        setTitle("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false); 

        JLabel headingLabel = new JLabel("Login");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setBounds(600, 200, 80, 25);
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

        loginButton = new JButton("Login");
        loginButton.setBounds(600, 350, 100, 25);
        loginButton.addActionListener(this);
        add(loginButton);

        JLabel signLabel = new JLabel("Yet not signedUp then what are you waiting for?");
        signLabel.setBounds(500, 380, 300, 30);
        add(signLabel);

        final JLabel signupNavLabel = new JLabel("Sign Up");
        signupNavLabel.setBounds(600, 400, 50, 50);
        signupNavLabel.setForeground(Color.BLUE);
        signupNavLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Signup signupPage = new Signup();
                signupPage.setVisible(true);
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
        if (e.getSource() == loginButton) {
            final String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (validateSignup(username, password)) {
                loginButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // enter enteredPage = new enter(username);
                        // enteredPage.setVisible(true);
                        stone stonePage = new stone(username);
                        stonePage.setVisible(true);
                        dispose();
                    }
                });
            } else{
                JOptionPane.showMessageDialog(this, "wrong details!!!");
            }
        }
    }

    private boolean validateSignup(String username, String password) {
        try {
            Dotenv dotenv = Dotenv.load();
            String url = dotenv.get("LINK");
            String dbuser = dotenv.get("DBUSER");
            String paword = dotenv.get("PASS");
            Connection con = DriverManager.getConnection(url, dbuser, paword);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM signup";
            // PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String usernames = rs.getString("username");
                String pasword = rs.getString("password");
                if ((username.equals(usernames))&& (password.equals(pasword))) {
                    return true;
                }
            }
            // // Close resources
            // rs.close();
            // stmt.close();
            // con.close();     
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
