package verkkopankki.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import verkkopankki.logiikka.*;

/**
 *
 * @author Oskari
 */
public class Etusivu {

    private final Asiakas asiakas;
    private final Jarjestelma jarjestelma;
    private final JFrame frame;
    private final JPanel ikkuna;
    private JLabel tiliLabel;

    public Etusivu(JFrame frame, Jarjestelma j, Asiakas a) {
        this.asiakas = a;
        this.frame = frame;
        this.jarjestelma = j;
        this.ikkuna = new JPanel();
    }

    public void luoEtusivu() {
        ikkuna.setLayout(null);

        Ylapalkki ylapalkki = new Ylapalkki(frame, ikkuna, jarjestelma, asiakas);

        JLabel tilitLabel = new JLabel("Tilit");
        tilitLabel.setBounds(50, 130, 400, 15);

        JPanel tililista = new JPanel(new GridLayout(10, 1, 0, 5));
        JScrollPane tililist = new JScrollPane();
        tililista.setBounds(50, 150, 400, 400);
        tililista.setBackground(Color.WHITE);
        tililista.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        for (Tili t : asiakas.getTilit()) {
            tiliLabel = new JLabel(t.getTilinro() + " Saldo: " + t.getSaldo()/100 + "." + t.getSaldo()%100 + "€");
            tiliLabel.setFont(new Font("Ubuntu", Font.PLAIN, 13));
            tiliLabel.addMouseListener(new Siirtyja());
            tililista.add(tiliLabel);
        }

        ikkuna.add(tilitLabel);
        ikkuna.add(tililista);
        frame.getContentPane().add(ikkuna);
        ylapalkki.luoYlapalkki();
    }

    private class Siirtyja implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == tiliLabel) {
                frame.getContentPane().removeAll();
                TiliIkkuna tiliIkkuna = new TiliIkkuna(frame, jarjestelma, asiakas.getTilit().get(0), asiakas);
                tiliIkkuna.luoTiliIkkuna();
                frame.getContentPane().revalidate();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }
}
