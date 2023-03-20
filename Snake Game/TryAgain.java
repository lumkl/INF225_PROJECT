import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryAgain extends JFrame {
    TryAgain() {
        super("Snake Game");
        this.setLayout(new FlowLayout());

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

        add(tryAgainButton);
        add(exitButton);

        // Closing Window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(100, 20, 100));
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
