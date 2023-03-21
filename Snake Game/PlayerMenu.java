import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PlayerMenu extends JFrame {

    JTextField textField;

    PlayerMenu() {
        super("Snake Game");
        this.setLayout(new FlowLayout());

        // JLabel
        JLabel label = new JLabel();
        label.setText("Enter your In-Game Name: ");
        label.setFont(new Font("Times New Roman", Font.BOLD, 30));

        JLabel label1 = new JLabel();
        label1.setText("Hi Player, Welcome to Snake Game!! ");
        label1.setFont(new Font("Monotype Corsiva", Font.BOLD, 25));

        textField = new JTextField(30);
        EventHandler handler = new EventHandler();
        textField.addKeyListener(handler);

        textField = new JTextField(30);
        EventHandler handler2 = new EventHandler();
        textField.addKeyListener(handler2);

        this.add(label1);
        this.add(label);
        this.add(textField);
        


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(100, 80, 100));
    }

    private class EventHandler implements KeyListener {

        public void keyPressed(KeyEvent event) {

            GamePanel gp = new GamePanel();

            if (event.getKeyCode() == KeyEvent.VK_ENTER) {

                gp.playerName = textField.getText();

                dispose();

                new DifficultyMenu();
            }
        }

        public void keyTyped(KeyEvent event) {
        }

        public void keyReleased(KeyEvent event) {
        }
    }
}
