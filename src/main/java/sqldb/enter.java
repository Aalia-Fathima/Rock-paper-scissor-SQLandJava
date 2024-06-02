package sqldb;
import javax.swing.*;
import java.awt.event.*;

public class enter extends JFrame {
    public enter(String username) {
        final String user = username;

        setTitle("Game Page");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JButton startButton = new JButton("Stone Paper Scissor");
        startButton.setBounds(150, 100, 200, 200);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                stone stonePage = new stone(user);
                stonePage.setVisible(true);
                dispose();
            }
        });
        add(startButton);

        JButton name_place_things_animals = new JButton("Name Place Things Animals");
        name_place_things_animals.setBounds(400, 100, 200, 200);
        name_place_things_animals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(enter.this, "Game Started!");
            }
        });
        add(name_place_things_animals);

        JButton Bingo = new JButton("Bingo");
        Bingo.setBounds(150, 400, 200, 200); 
        Bingo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(enter.this, "Game Started!");
            }
        });
        add(Bingo);

        JButton XOX = new JButton("XOX");
        XOX.setBounds(400, 400, 200, 200); 
        XOX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add action to start game
                JOptionPane.showMessageDialog(enter.this, "Game Started!");
            }
        });
        add(XOX);

        JButton WordChain = new JButton("Word Chain");
        WordChain.setBounds(650, 100, 200, 200); 
        WordChain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(enter.this, "Game Started!");
            }
        });
        add(WordChain);

        JButton HandCricket = new JButton("Hand Cricket");
        HandCricket.setBounds(650, 400, 200, 200);
        HandCricket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(enter.this, "Game Started!");
            }
        });
        add(HandCricket);
        
        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

}
