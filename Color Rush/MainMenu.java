import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
    MainMenu() {
        super("Candy Rush");
        this.setLayout(new FlowLayout());
        ImageIcon candyIcon = new ImageIcon("lollipop.png");
        JLabel label = new JLabel();
        label.setIcon(candyIcon);

        JButton button = new JButton();
        button.setText("PLAY GAME");
        button.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
        EventHandler handler = new EventHandler();
        button.addActionListener(handler);

        this.add(label);
        this.add(button);

}

private class EventHandler implements ActionListener {

    public void actionPerformed(ActionEvent event) {

        
        new Player();
        
        dispose();
    }
}

}
