import java.awt.Color;
import java.awt.Font;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ColorMenu2 extends JFrame {

    JList list;
    //background color
    private String[] colorNameArray = {"BLACK", "BLUE", "CYAN", "DARK GRAY", "GREEN", "RED", "WHITE"};
    private Color[] colorListArray = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN, Color.RED, Color.WHITE};

    JList colorList;
    
    ColorMenu2() {
        super("Snake Game");
        this.setLayout(new FlowLayout());
        //background color selection:
        JLabel label2 = new JLabel();
        label2.setText("Choose the Background Color you want: ");
        label2.setFont(new Font("Times New Roman", Font.BOLD, 27));
        //
        colorList = new JList<>(colorNameArray);
        colorList.setFont(new Font("Times New Roman", Font.BOLD, 20));
        colorList.setVisibleRowCount(4);
        //
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        EventHandler handler2 = new EventHandler();
        colorList.addListSelectionListener(handler2);
        this.add(colorList);
        //
        JScrollPane scrollPane = new JScrollPane(colorList);

        this.add(label2);
        this.add(scrollPane);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLUE);
    }
    private class EventHandler implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent event) {
            GamePanel gp = new GamePanel();
            gp.gameBackgroundcolor = colorListArray[colorList.getSelectedIndex()];
            
            new GameFrame();

            dispose();
        }
    }
}
