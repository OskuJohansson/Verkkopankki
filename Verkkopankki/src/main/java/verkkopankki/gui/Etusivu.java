package verkkopankki.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import verkkopankki.logiikka.*;

/**
 *
 * @author Oskari
 */
public class Etusivu extends Ikkuna {

    private final Asiakas asiakas;
    private final Jarjestelma jarjestelma;
    private final JFrame frame;
    private final JPanel ikkuna;
    private JLabel tiliLabel;

    public Etusivu(JFrame frame, Jarjestelma jarjestelma, Asiakas asiakas) {
        super(frame, jarjestelma);
        this.asiakas = asiakas;
        this.frame = frame;
        this.jarjestelma = jarjestelma;
        this.ikkuna = new JPanel();
    }

    @Override
    public void luoKomponentit() {
        ikkuna.setLayout(null);

        Ylapalkki ylapalkki = new Ylapalkki(frame, ikkuna, jarjestelma, asiakas);

        JLabel tilitLabel = new JLabel("Tilit");
        tilitLabel.setBounds(50, 130, 300, 15);

        JPanel tililista = new JPanel(new GridLayout(12, 1, 0, 1));
        tililista.setBounds(50, 150, 300, 400);
        tililista.setBackground(Color.WHITE);
        tililista.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        int i = 0;
        for (Tili t : asiakas.getTilit()) {
            JPanel tililappu = new JPanel(new FlowLayout(FlowLayout.LEFT));
            tililappu.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            tiliLabel = new JLabel(t.getTilinro() + " Saldo: " + t.getSaldo() / 100 + "." + t.getSaldo() % 100 + "€");
            tiliLabel.setFont(new Font("Ubuntu", Font.PLAIN, 13));
            tililappu.addMouseListener(new TilinTietoihinSiirtyja(i));
            tililappu.add(tiliLabel);
            tililista.add(tililappu);
            i++;
        }

        JLabel pankkikortitLabel = new JLabel("Pankkikortit");
        pankkikortitLabel.setBounds(370, 130, 300, 15);

        JPanel pankkikorttilista = new JPanel(new GridLayout(12, 1, 0, 1));
        pankkikorttilista.setBounds(370, 150, 300, 400);
        pankkikorttilista.setBackground(Color.WHITE);
        pankkikorttilista.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        ikkuna.add(tilitLabel);
        ikkuna.add(tililista);
        ikkuna.add(pankkikortitLabel);
        ikkuna.add(pankkikorttilista);
        ikkuna.add(tervetuloteksti());
        frame.getContentPane().add(ikkuna);
        ylapalkki.luoKomponentit();
    }

    private JLabel tervetuloteksti() {
        JLabel tervetuloLabel = new JLabel("<html>Tervetuloa käyttämään Javapankkia!<br>"
                + "<br>"
                + "Tällä sivulla näet listattuna pankkitilisi sekä -korttisi, jos sinulla niitä on.<br>"
                + "Yläpalkista pystyt navigoimaan Javapankin eri osioihin,<br>"
                + "tiliä klikkaamalla pääset tarkastelemaan sen tilitapahtumia<br>"
                + "<br>"
                + "Toivottavasti viihdyt!</html>");
        tervetuloLabel.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        tervetuloLabel.setBounds(700, 150, 530, 150);

        return tervetuloLabel;
    }

    private class TilinTietoihinSiirtyja implements MouseListener {

        private final int indeksi;

        public TilinTietoihinSiirtyja(int indeksi) {
            this.indeksi = indeksi;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
//            if (e.getSource() == tiliLabel) {
            frame.getContentPane().removeAll();
            TiliIkkuna tiliIkkuna = new TiliIkkuna(frame, jarjestelma, asiakas.getTilit().get(indeksi), asiakas);
            tiliIkkuna.luoKomponentit();
            frame.getContentPane().revalidate();
//            
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
