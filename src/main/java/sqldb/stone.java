package sqldb;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class stone extends JFrame {

    private int score = 0, clickes = 0;
    private int score_sys = 0;
    private JLabel headingLabel3;
    private JLabel headingLabel4, headingLabel5;

    public stone(String username) {
        final String user = username;

        setTitle("Stone paper scissor Page");
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false); 

        // Create a Random object
        final Random random = new Random();
        final ImageIcon icon = new ImageIcon(getClass().getResource("user.png"));
        final ImageIcon icon1 = new ImageIcon(getClass().getResource("stonelogo.png"));
       
        
        // JButton back_but = new JButton("Play Other games");
        // back_but.setBounds(30, 30, 150, 25);
        // add(back_but);
        // back_but.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         int result = JOptionPane.showConfirmDialog(null, "Do you want to quit?", "Confirmation",
        //                 JOptionPane.YES_NO_OPTION);
        //         // Check the user's response
        //         if (result == JOptionPane.YES_OPTION) {
        //             enter playback = new enter(user);
        //             playback.setVisible(true);
        //             dispose();
        //         }
        //     }
        // });

        final JLabel label = new JLabel(icon);
        label.setBounds(100, 100, 500, 600); 
        final JLabel label1 = new JLabel(icon1);
        label1.setBounds(800, 100, 500, 600); 

        add(label);
        add(label1);
        final ImageIcon image1 = new ImageIcon(getClass().getResource("stone.png"));
        final ImageIcon image2 = new ImageIcon(getClass().getResource("scissor2.png"));
        final ImageIcon image3 = new ImageIcon(getClass().getResource("paper.png"));
        
        final JLabel headingLabel1 = new JLabel();
        headingLabel1.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel1.setBounds(600, 70, 300, 25);
        add(headingLabel1);

        JRadioButton option1 = new JRadioButton("Stone");
        option1.setBounds(500, 20, 60, 30); 
        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isClicked = true;
                // 0 - stone , 1 - paper, 2 - scissor
                while (isClicked) {
                    clickes += 1;
                    headingLabel5.setText("changes:" + " " + clickes + "/20");
                    // Generate a random integer between 0 (inclusive) and 3 (exclusive)
                    final int computer_choice = random.nextInt(3);
                    if (computer_choice == 1) {
                        score_sys += 1;
                        score -= 1;
                        if (score < 0) {
                            score = 0;
                        }
                        headingLabel3.setText(user + "'s" + " " + "Score:" + " " + score);
                        headingLabel4.setText("System's Score:" + " " + score_sys);
                        headingLabel1.setText("System wins, You Lose");
                        label1.setIcon(image3);
                    } else if (computer_choice == 2) {
                        score += 1;
                        score_sys -= 1;
                        if (score_sys < 0) {
                            score_sys = 0;
                        }
                        headingLabel4.setText("System's Score:" + " " + score_sys);
                        headingLabel3.setText(user + "'s" + " " + "Score:" + " " + score);
                        headingLabel1.setText(user + " " + "wins!!!");
                        label1.setIcon(image2);
                    } else if (computer_choice == 0) {
                        headingLabel1.setText("Draw Match");
                        label1.setIcon(image1);
                    }
                    if (clickes >= 20) {
                        gameover gover = new gameover(score, score_sys,user);
                        gover.setVisible(true);
                        dispose();
                    }
                    isClicked = false;
                }
                label.setIcon(image1);
            }
        });

        JRadioButton option2 = new JRadioButton("Paper");
        option2.setBounds(600, 20, 60, 30); 
        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isClicked = true;
                // 0 - stone , 1 - paper, 2 - scissor
                while (isClicked) {
                    clickes += 1;
                    headingLabel5.setText("changes:" + " " + clickes + "/20");
                    // Generate a random integer between 0 (inclusive) and 3 (exclusive)
                    final int computer_choice = random.nextInt(3);
                    if (computer_choice == 1) {
                        headingLabel1.setText("Draw Match");
                        label1.setIcon(image3);
                    } else if (computer_choice == 2) {
                        score_sys += 1;
                        score -= 1;
                        if (score < 0) {
                            score = 0;
                        }
                        headingLabel3.setText(user + "'s" + " " + "Score:" + " " + score);
                        headingLabel4.setText("System's Score:" + " " + score_sys);
                        headingLabel1.setText("System wins, You Lose");
                        label1.setIcon(image2);
                    } else if (computer_choice == 0) {
                        score += 1;
                        score_sys -= 1;
                        if (score_sys < 0) {
                            score_sys = 0;
                        }
                        headingLabel4.setText("System's Score:" + " " + score_sys);
                        headingLabel3.setText(user + "'s" + " " + "Score:" + " " + score);
                        headingLabel1.setText(user + " " + "wins!!!");
                        label1.setIcon(image1);
                    }
                    if (clickes >= 20) {
                        gameover gover = new gameover(score, score_sys,user);
                        gover.setVisible(true);
                        dispose();
                    }
                    isClicked = false;
                }
                label.setIcon(image3);
            }
        });

        JRadioButton option3 = new JRadioButton("Scissor");
        option3.setBounds(700, 20, 80, 30); 
        option3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isClicked = true;
                // 0 - stone , 1 - paper, 2 - scissor
                while (isClicked) {
                    clickes += 1;
                    headingLabel5.setText("changes:" + " " + clickes + "/20");
                    // Generate a random integer between 0 (inclusive) and 3 (exclusive)
                    final int computer_choice = random.nextInt(3);
                    if (computer_choice == 1) {
                        score += 1;
                        score_sys -= 1;
                        if (score_sys < 0) {
                            score_sys = 0;
                        }
                        headingLabel4.setText("System's Score:" + " " + score_sys);
                        headingLabel3.setText(user + "'s" + " " + "Score:" + " " + score);
                        headingLabel1.setText(user + " " + "wins!!!");
                        label1.setIcon(image3);
                    } else if (computer_choice == 2) {
                        headingLabel1.setText("Draw Match");
                        label1.setIcon(image2);
                    } else if (computer_choice == 0) {
                        score_sys += 1;
                        score -= 1;
                        if (score < 0) {
                            score = 0;
                        }
                        headingLabel3.setText(user + "'s" + " " + "Score:" + " " + score);
                        headingLabel4.setText("System's Score:" + " " + score_sys);
                        headingLabel1.setText("System wins, You Lose");
                        label1.setIcon(image1);
                    }
                    if (clickes >= 20) {
                        gameover gover = new gameover(score, score_sys,user);
                        gover.setVisible(true);
                        dispose();
                    }
                    isClicked = false;
                }
                label.setIcon(image2);
            }
        });

        // Create a ButtonGroup to ensure only one radio button is selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        add(option1);
        add(option2);
        add(option3);

        JLabel headingLabel = new JLabel(username);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setBounds(300, 120, 80, 25);
        add(headingLabel);

        JLabel headingLabel2 = new JLabel("System");
        headingLabel2.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel2.setBounds(1000, 120, 100, 25);
        add(headingLabel2);

        headingLabel3 = new JLabel(user + "'s" + " " + "Score:" + " " + score);
        headingLabel3.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel3.setBounds(1100, 20, 300, 25);
        add(headingLabel3);

        headingLabel4 = new JLabel("System's Score:" + " " + score_sys);
        headingLabel4.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel4.setBounds(1100, 50, 300, 25);
        add(headingLabel4);

        headingLabel5 = new JLabel("changes:" + " " + clickes + "/20");
        headingLabel5.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel5.setBounds(30, 650, 200, 25);
        add(headingLabel5);
        
        setVisible(true);

        // Center the frame on the screen
        setLocationRelativeTo(null);

    }

}
