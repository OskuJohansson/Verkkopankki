package verkkopankki.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Java Bank");
        frame.setPreferredSize(new Dimension(1600, 900));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

//    private void luoKomponentit(Container c) {
//        JPanel jp = new JPanel();
//        jp.setLayout(new GridLayout(3, 3));
//        JLabel label = new JLabel("Hellurei!");
//        label.setToolTipText("tämä toimii");
//        jp.add(label);
//        jp.add(new JLabel("Moi!"));
//        jp.add(new JLabel("Hei!"));
//        jp.add(new JLabel("Mitä kuuluu?"));
//        c.add(jp);
//  }

    public JFrame getFrame() {
        return frame;
    }
}
