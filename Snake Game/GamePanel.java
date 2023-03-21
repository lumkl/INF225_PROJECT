import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 1250;
    static final int SCREEN_HEIGHT = 650;
    static final int UNIT_SIZE = 50;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);

    static boolean gameEnd = false;

    // Snake Speed
    static int DELAY;

    // Snake Color
    static Color snkColor;

    // Player name
    static String playerName;

    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    private Image apple;
    static Color gameBackgroundcolor;


    GamePanel() {
        random = new Random();
        apple = new ImageIcon("apple (1).png").getImage();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(gameBackgroundcolor);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        if (running) {
            g2d.setColor(Color.BLUE);
            // (appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            drawApple(g2d, appleX, appleY);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g2d.setColor(snkColor);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g2d.setColor(snkColor);
                    g2d.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("Perpetua", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g2d.getFont());

            g2d.drawString("Player: " + playerName, 0, g2d.getFont().getSize());

            g2d.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
                    g2d.getFont().getSize());
        } else {
            gameOver(g2d);
        }

    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    private void drawApple(Graphics2D g2d, int x, int y) {

        g2d.drawImage(apple, x, y, this);
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        
        if (x[0] < 0) {
            running = false;
        }
        
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }
        
        if (y[0] < 0) {
            running = false;
        }
        
        if (y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics2D g) {
        // Score
        g.setColor(Color.BLUE);
        g.setFont(new Font("Times New Roman", Font.BOLD, 200));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2,
                g.getFont().getSize());
        // Game Over text
        g.setColor(Color.BLUE);
        g.setFont(new Font("Times New Roman", Font.BOLD, 400));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);

        JFrame parent = (JFrame) this.getTopLevelAncestor();
        parent.dispose();

        // Go to try again frame
        new TryAgain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
