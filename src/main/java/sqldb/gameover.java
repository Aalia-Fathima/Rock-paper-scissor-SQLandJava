package sqldb;
import javax.swing.*;
import io.github.cdimascio.dotenv.Dotenv;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class gameover extends JFrame {
    private int high, high1,match;
    public gameover(int score, int score_sys, String username) {
        try {
            Dotenv dotenv = Dotenv.load();
            String url = dotenv.get("LINK");
            String dbuser = dotenv.get("DBUSER");
            String paword = dotenv.get("PASS");
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
        final String user = username;
        setTitle("Stone paper scissor Page");
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false); 

        final ImageIcon icon = new ImageIcon(getClass().getResource("skull.png"));
        final ImageIcon icon2 = new ImageIcon(getClass().getResource("tie.png"));
        final ImageIcon icon1 = new ImageIcon(getClass().getResource("win.png"));
        
        final JLabel label = new JLabel();
        label.setBounds(10, 100, 500, 500);
        add(label);

        JLabel gameOver = new JLabel();
        gameOver.setFont(new Font("Arial", Font.BOLD, 40));
        gameOver.setBounds(710, 220, 250, 35);
        add(gameOver);

        if (score < score_sys) {
            label.setIcon(icon);
            gameOver.setText("You Lose!!!");
        } else if (score > score_sys) {
            label.setIcon(icon1);
            gameOver.setText("You Win!!!");
        } else if (score == score_sys) {
            label.setIcon(icon2);
            gameOver.setText("match tied...");
        }

        JLabel gameOverLabel = new JLabel("System score: " + score_sys);
        gameOverLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        gameOverLabel.setBounds(710, 280, 250, 35);
        add(gameOverLabel);

        JLabel scoreLabel = new JLabel("Your Score: " + score);
        scoreLabel.setBounds(730, 340, 250, 30);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        add(scoreLabel);

        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(780, 390, 100, 25);
        add(playAgainButton);

        // JButton playAgain = new JButton("play other games");
        // playAgain.setBounds(850, 390, 150, 25);
        // add(playAgain);

        JLabel highscore = new JLabel("You have played " + match + " " + "matches " + "and Your highest score ever is: " + high);
        highscore.setFont(new Font("Arial",Font.PLAIN,30));
        highscore.setForeground(Color.BLUE);
        highscore.setBounds(500, 500, 850, 30);
        add(highscore);

        JLabel highscore1 = new JLabel("System's highest score for " + match + " matches is " + high1);
        highscore1.setFont(new Font("Arial",Font.PLAIN,30));
        highscore1.setForeground(Color.BLUE);
        highscore1.setBounds(500, 550, 700, 30);
        add(highscore1);

        // playAgain.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         enter manygame = new enter(user);
        //         manygame.setVisible(true);
        //         dispose();
        //     }
        // });

        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stone again = new stone(user);
                again.setVisible(true);
                dispose();
              
            }
        });

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

}
