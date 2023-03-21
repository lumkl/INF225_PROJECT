import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryAgain extends JFrame {
    TryAgain() {
        super("Snake Game");
        this.setLayout(new FlowLayout());

        JLabel label = new JLabel();
        label.setText("GAME OVER!!");
        label.setFont(new Font(("Times New Roman"), Font.CENTER_BASELINE, 50));

        JButton tryAgainButton = new JButton();
        tryAgainButton.setText("PLAY AGAIN");
        tryAgainButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        // Try Again Button
        TryAgainEventHandler tryHandler = new TryAgainEventHandler();
        tryAgainButton.addActionListener(tryHandler);

        JButton exitButton = new JButton();
        exitButton.setText("EXIT");
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        // Exit Button
        ExitEventHandler exitHandler = new ExitEventHandler();
        exitButton.addActionListener(exitHandler);

        this.add(label);
        add(tryAgainButton);
        add(exitButton);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    private class TryAgainEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            App myApp = new App();
            myApp.main(null);
            dispose();
        }
    }

    private class ExitEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            dispose();
        }
    }
}
