import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyMenu extends JFrame {
    DifficultyMenu() {
        super("Snake Game");
        this.setLayout(new FlowLayout());

        JLabel label = new JLabel();
        label.setText("DIFFICULTY OPTIONS: ");
        label.setFont(new Font("Times New Roman", Font.BOLD, 40));

        JButton easyButton = new JButton();
        easyButton.setText("EASY");
        easyButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        // Easy Button
        EventHandler easyHandler = new EventHandler(200);
        easyButton.addActionListener(easyHandler);

        JButton mediumButton = new JButton();
        mediumButton.setText("MEDIUM");
        mediumButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        // Medium Button
        EventHandler mediumHandler = new EventHandler(130);
        mediumButton.addActionListener(mediumHandler);

        JButton hardButton = new JButton();
        hardButton.setText("HARD");
        hardButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        // Hard Button
        EventHandler hardHandler = new EventHandler(50);
        hardButton.addActionListener(hardHandler);

        JButton CHButton = new JButton();
        CHButton.setText("CHALLENGER");
        CHButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        // Challenger Button
        EventHandler CHHandler = new EventHandler(20);
        CHButton.addActionListener(CHHandler);

        this.add(label);
        
        add(easyButton);
        add(mediumButton);
        add(hardButton);
        add(CHButton);

        // 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.DARK_GRAY);
    }

    private class EventHandler implements ActionListener {

        int snakeSpeed;

        EventHandler(int speed) {
            this.snakeSpeed = speed;
        }

        public void actionPerformed(ActionEvent event) {
            GamePanel gp = new GamePanel();
            gp.DELAY = snakeSpeed;

            new ColorMenu();

            dispose();
        }
    }
}
