import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
// import javax.swing.BorderFactory;
// import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
// import java.awt.Component;
import java.awt.Font;

public class ColorMenu extends JFrame {

    JList list;

    private String[] colorNames = {"WHITE", "GREEN", "PINK", "BLACK", "ORANGE", "YELLOW"};
    private Color[] colors = {Color.WHITE, Color.green, Color.pink, Color.black, Color.orange, Color.yellow};

    JList colorList;

    ColorMenu() {
        super("Candy Rush");
        this.setLayout(new FlowLayout());
        
        JLabel label = new JLabel();
        label.setText("Choose background color");
        label.setFont(new Font("Times New Roman", Font.BOLD, 20));


        colorList = new JList(colorNames);
        colorList.setFont(new Font ("Times New Roman", Font.BOLD, 20));
        colorList.setVisibleRowCount(3);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        EventHandler handler = new EventHandler();
        colorList.addListSelectionListener(handler);

        this.add(colorList);

        JScrollPane scrollPane = new JScrollPane(colorList);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.add(label);
        panel1.setBackground(Color.blue);
        panel2.add(new JScrollPane(colorList));
        panel2.setBackground(Color.blue);

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.SOUTH);

        
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.blue);
    }

    private class EventHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            CandyRush bg = new CandyRush();
            bg.Background = colors[colorList.getSelectedIndex()];

            dispose();

            new GameFrame();
        }
    }
}
