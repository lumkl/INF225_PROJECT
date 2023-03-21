import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CandyRush extends JPanel implements Runnable, KeyListener {
	private Thread t;
	private Ball ball;
	JLabel boul;
	Rectangle r;
	JLabel labelScore, labelLife[], labelName;
	public static int score = 0;
    static int life;
	private GameFrame main;
    static Color fontColor;
    static Color Background;
    static String playerName;

	public CandyRush() {
		

		setLayout(null); // layout
		// addKeyListener(this);
		setBackground(Background);
		
        // setFont(fontColor);
		setSize(1200, 700); // frame size
		r = getBounds();

		// Boul label
		boul = new JLabel(new ImageIcon("Bowl.png"));
		boul.setBounds(5, getBounds().height - 116, 200, 80);
		add(boul);

		// life labels
        labelLife = new JLabel[life];
		for (int i = 0; i < life; i++) {
			labelLife[i] = new JLabel(new ImageIcon("heart.png"));
			labelLife[i].setBounds(i * 40, 2, 30, 30);
			add(labelLife[i]);
		}

        labelName = new JLabel(playerName + ":");
        labelName.setBounds(550, 2, 150, 30);
        labelName.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(labelName);

		// Score Label
		labelScore = new JLabel("0");
		labelScore.setBounds(getBounds().width - 570, 2, 150, 30);
		labelScore.setFont(new Font("Times New Roman", Font.BOLD, 30));
		add(labelScore);

		// Balls Thread
		t = new Thread(this, "Ball");
	}

    public CandyRush(GameFrame gameFrame) {
	}

	public void start() {
		t.start();
	}

	public void run() {
		try {
			while (life > 0) {
				ball = new Ball(this);
				add(ball);
				Thread.sleep(3000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Something Wrong");
		}
        gameOver();
		JOptionPane.showMessageDialog(null, "Here is your score, " + playerName + " : " + score);
		main.t.start();
	}

    public void gameOver () {
        JFrame parentFrame = (JFrame) this.getTopLevelAncestor();
        parentFrame.dispose();

        new TryAgain();
    }

	public void keyTyped(java.awt.event.KeyEvent evt) {
	}

	public void keyPressed(java.awt.event.KeyEvent evt) {
		int x = boul.getX();
		int y = boul.getY();
		if (evt.getKeyCode() == 37 && x - 25 >= 0)
			boul.setBounds(x - 25, y, 200, 80);
		else if (evt.getKeyCode() == 39 && x + 25 < r.width - 203)
			boul.setBounds(x + 25, y, 200, 80);
	}

	public void keyReleased(java.awt.event.KeyEvent evt) {
	}
}
