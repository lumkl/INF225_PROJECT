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

public class ColorMenu extends JFrame {

    JList list;
    //snake color
    private String[] colorlist = { "RED", "ORANGE", "GRAY", "BLUE", "CYAN", "YELLOW", "PINK", "GREEN" };
    private Color[] colors = { Color.RED, Color.ORANGE, Color.GRAY, Color.BLUE, Color.CYAN, Color.yellow, Color.pink, Color.GREEN};
    //
    JList colorList;
    ColorMenu() {
        super("Snake Game");
        this.setLayout(new FlowLayout());

        // Snake Color selection:
        JLabel label = new JLabel();
        label.setText("Choose your Preferred Snake Color: ");
        label.setFont(new Font("Times New Roman", Font.BOLD, 30));

        // 
        list = new JList(colorlist);
        list.setFont(new Font("Times New Roman", Font.BOLD, 30));
        list.setVisibleRowCount(4);

        // Single Selection
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // 
        EventHandler handler = new EventHandler();
        list.addListSelectionListener(handler);
        
   
        this.add(list);

        // 
        JScrollPane scrollPane = new JScrollPane(list);
        

        
        this.add(label);
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
            gp.snkColor = colors[list.getSelectedIndex()];
            
            new ColorMenu2();

            dispose();
        }
    }
}
