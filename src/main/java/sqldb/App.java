package sqldb;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.*;

public class App extends JFrame {
    public App() {
        setTitle("Stone paper scissor Page");
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        final ImageIcon image1 = new ImageIcon(getClass().getResource("stonelogo.png"));
        final ImageIcon image2 = new ImageIcon(getClass().getResource("play.png"));
        final JLabel label = new JLabel(image1);
        label.setBounds(600, 150, 250, 300);
        add(label);
        JLabel playJLabel = new JLabel("Play");
        playJLabel.setFont(new Font("Arial",Font.BOLD,30));
        playJLabel.setBounds(700,450,100,30);
        add(playJLabel);
        final JLabel label1 = new JLabel(image2);
        label1.setBounds(680, 470, 100, 100);
        add(label1);
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginFrame logPage = new LoginFrame();
                logPage.setVisible(true);
                dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        new App();
    }
}
