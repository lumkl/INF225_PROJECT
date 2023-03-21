import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Difficulty extends JFrame {
     private ActionListener hellHandler;

    Difficulty(){
        super("Candry Rush");
        this.setLayout(new FlowLayout());

        JLabel label = new JLabel();
        label.setText("DIFFICULTY OPTIONS: ");
        label.setFont(new Font("Times New Roman", Font.BOLD, 40));
        //
        JButton easyButton = new JButton();
        easyButton.setText("EASY");
        easyButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        // Easy Button
        EventHandler easyHandler = new EventHandler(7);
        easyButton.addActionListener(easyHandler);
        //
        JButton normalButton = new JButton();
        normalButton.setText("NORMAL");
        normalButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        // Normal Button
        EventHandler normalHandler = new EventHandler(5);
        normalButton.addActionListener(normalHandler);
        //
        JButton hardButton = new JButton();
        hardButton.setText("HARD");
        hardButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        // Hard Button
        EventHandler hardHandler = new EventHandler(3);
        hardButton.addActionListener(hardHandler);
        //
        JButton hellButton = new JButton();
        hellButton.setText("HELL");
        hellButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        // Challenger Button
        EventHandler hellHandler = new EventHandler(1);
        hellButton.addActionListener(hellHandler);

        add(label);
        add(easyButton);
        add(normalButton);
        add(hardButton);
        add(hellButton);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLUE);
    }
    private class EventHandler implements ActionListener {

        
        int life;

        EventHandler(int limit) {
            this.life = limit;
        }

        public void actionPerformed(ActionEvent event) {
            CandyRush gp = new CandyRush();
            
            gp.life = life;

            new ColorMenu();

            dispose();
        }
    }
}
