// package sqldb;

// import javax.swing.*;
// // import io.github.cdimascio.dotenv.Dotenv;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;

// public class gameover extends JFrame {
//     private int high, high1, match;

//     public gameover(int score, int score_sys, String username) {
//         try {
//             // Dotenv dotenv = Dotenv.load();
//             // String url = dotenv.get("LINK");
//             // String dbuser = dotenv.get("DBUSER");
//            // String paword = dotenv.get("PASS");
//            String url = "jdbc:mysql://" +System.getenv("DB_HOST") + ":" + System.getenv("DB_PORT") + "/"
//            + System.getenv("DB_NAME");
//    String dbuser = System.getenv("DB_USER");
//    String paword = System.getenv("DB_PASSWORD");

//             Connection con = DriverManager.getConnection(url, dbuser, paword);
//             String query1 = "Insert into score (user,user_score,system_score) values(?,?,?)";
//             PreparedStatement state = con.prepareStatement(query1);
//             state.setString(1, username);
//             state.setInt(2, score);
//             state.setInt(3, score_sys);
//             state.executeUpdate(); // Execute the insert query
//             String query2 = "SELECT user,max(user_score) as highuser,max(system_score) as highsystem,count(user) as matches FROM score where user = ?";
//             PreparedStatement statement = con.prepareStatement(query2);
//             statement.setString(1, username);
//             ResultSet rs = statement.executeQuery();
//             while (rs.next()) {
//                 high = rs.getInt("highuser");
//                 high1 = rs.getInt("highsystem");
//                 match = rs.getInt("matches");
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         final String user = username;
//         setTitle("Stone paper scissor Page");
//         setSize(1024, 768); // Set the size explicitly
//         // setExtendedState(JFrame.MAXIMIZED_BOTH);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(null);
//         setResizable(false);

//         final ImageIcon icon = new ImageIcon(getClass().getResource("/sqldb/skull.png"));
//         final ImageIcon icon2 = new ImageIcon(getClass().getResource("/sqldb/tie.png"));
//         final ImageIcon icon1 = new ImageIcon(getClass().getResource("/sqldb/win.png"));

//         final JLabel label = new JLabel();
//         label.setBounds(10, 100, 500, 500);
//         add(label);

//         JLabel gameOver = new JLabel();
//         gameOver.setFont(new Font("Arial", Font.BOLD, 40));
//         gameOver.setBounds(710, 220, 250, 35);
//         add(gameOver);

//         if (score < score_sys) {
//             label.setIcon(icon);
//             gameOver.setText("You Lose!!!");
//         } else if (score > score_sys) {
//             label.setIcon(icon1);
//             gameOver.setText("You Win!!!");
//         } else if (score == score_sys) {
//             label.setIcon(icon2);
//             gameOver.setText("match tied...");
//         }

//         JLabel gameOverLabel = new JLabel("System score: " + score_sys);
//         gameOverLabel.setFont(new Font("Arial", Font.PLAIN, 30));
//         gameOverLabel.setBounds(710, 280, 250, 35);
//         add(gameOverLabel);

//         JLabel scoreLabel = new JLabel("Your Score: " + score);
//         scoreLabel.setBounds(730, 340, 250, 30);
//         scoreLabel.setFont(new Font("Arial", Font.PLAIN, 30));
//         add(scoreLabel);

//         JButton playAgainButton = new JButton("Play Again");
//         playAgainButton.setBounds(780, 390, 100, 25);
//         add(playAgainButton);

//         // JButton playAgain = new JButton("play other games");
//         // playAgain.setBounds(850, 390, 150, 25);
//         // add(playAgain);

//         JLabel highscore = new JLabel(
//                 "You have played " + match + " " + "matches " + "and Your highest score ever is: " + high);
//         highscore.setFont(new Font("Arial", Font.PLAIN, 30));
//         highscore.setForeground(Color.BLUE);
//         highscore.setBounds(500, 500, 850, 30);
//         add(highscore);

//         JLabel highscore1 = new JLabel("System's highest score for " + match + " matches is " + high1);
//         highscore1.setFont(new Font("Arial", Font.PLAIN, 30));
//         highscore1.setForeground(Color.BLUE);
//         highscore1.setBounds(500, 550, 700, 30);
//         add(highscore1);

//         // playAgain.addActionListener(new ActionListener() {
//         // public void actionPerformed(ActionEvent e) {
//         // enter manygame = new enter(user);
//         // manygame.setVisible(true);
//         // dispose();
//         // }
//         // });

//         playAgainButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 stone again = new stone(user);
//                 again.setVisible(true);
//                 dispose();

//             }
//         });

//         // Center the frame on the screen
//         setLocationRelativeTo(null);

//         setVisible(true);
//     }

// }



package sqldb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class gameover extends JFrame {
    private int high, high1, match;

    public gameover(int score, int score_sys, String username) {
        try {
            String url = "jdbc:mysql://" + System.getenv("DB_HOST") + ":" + System.getenv("DB_PORT") + "/"
                    + System.getenv("DB_NAME");
            String dbuser = System.getenv("DB_USER");
            String paword = System.getenv("DB_PASSWORD");

            Connection con = DriverManager.getConnection(url, dbuser, paword);
            String query1 = "Insert into score (user,user_score,system_score) values(?,?,?)";
            PreparedStatement state = con.prepareStatement(query1);
            state.setString(1, username);
            state.setInt(2, score);
            state.setInt(3, score_sys);
            state.executeUpdate(); // Execute the insert query
            String query2 = "SELECT user,max(user_score) as highuser,max(system_score) as highsystem,count(user) as matches FROM score where user = ?";
            PreparedStatement statement = con.prepareStatement(query2);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                high = rs.getInt("highuser");
                high1 = rs.getInt("highsystem");
                match = rs.getInt("matches");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setTitle("Game Over - Stone Paper Scissor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Use BorderLayout for the main frame
        setResizable(true); // Allow resizing

        // Load images
        final ImageIcon icon = new ImageIcon(getClass().getResource("/sqldb/skull.png"));
        final ImageIcon icon2 = new ImageIcon(getClass().getResource("/sqldb/tie.png"));
        final ImageIcon icon1 = new ImageIcon(getClass().getResource("/sqldb/win.png"));

        // Panel for high scores (moved to the top)
        JPanel highScorePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        gbc.fill = GridBagConstraints.HORIZONTAL; // Allow horizontal expansion
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Span the entire row

        // Use HTML to wrap the text
        JLabel highscore = new JLabel(
            "<html>You have played " + match + " matches and your highest score ever is: " + high + "</html>");
        highscore.setFont(new Font("Arial", Font.PLAIN, 20));
        highscore.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        highScorePanel.add(highscore, gbc);

        JLabel highscore1 = new JLabel(
            "<html>System's highest score for " + match + " matches is " + high1 + "</html>");
        highscore1.setFont(new Font("Arial", Font.PLAIN, 20));
        highscore1.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        highScorePanel.add(highscore1, gbc);

        add(highScorePanel, BorderLayout.NORTH); // Move high score panel to the top

        // Panel for the result image and game over message
        JPanel resultPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        final JLabel label = new JLabel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        resultPanel.add(label, gbc);

        JLabel gameOver = new JLabel();
        gameOver.setFont(new Font("Arial", Font.BOLD, 40));
        gbc.gridx = 0;
        gbc.gridy = 1;
        resultPanel.add(gameOver, gbc);

        if (score < score_sys) {
            label.setIcon(icon);
            gameOver.setText("You Lose!!!");
        } else if (score > score_sys) {
            label.setIcon(icon1);
            gameOver.setText("You Win!!!");
        } else if (score == score_sys) {
            label.setIcon(icon2);
            gameOver.setText("Match Tied...");
        }

        add(resultPanel, BorderLayout.CENTER); // Result panel in the center

        // Panel for scores and buttons
        JPanel scorePanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel gameOverLabel = new JLabel("System Score: " + score_sys);
        gameOverLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        scorePanel.add(gameOverLabel, gbc);

        JLabel scoreLabel = new JLabel("Your Score: " + score);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        gbc.gridx = 0;
        gbc.gridy = 1;
        scorePanel.add(scoreLabel, gbc);

        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        scorePanel.add(playAgainButton, gbc);

        add(scorePanel, BorderLayout.EAST); // Score panel on the right

        // Action listener for the Play Again button
        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stone again = new stone(username);
                again.setVisible(true);
                dispose();
            }
        });

        pack(); // Adjust window size to fit components
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        new gameover(10, 5, "TestUser"); // For testing
    }
}