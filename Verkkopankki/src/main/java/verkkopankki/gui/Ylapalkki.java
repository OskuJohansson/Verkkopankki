package verkkopankki.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import verkkopankki.logiikka.Asiakas;
import verkkopankki.logiikka.Jarjestelma;

/**
 *
 * @author Oskari
 */
public class Ylapalkki {

    private final JFrame frame;
    private final Jarjestelma jarjestelma;
    private final Asiakas asiakas;
    private final JPanel ikkuna;
    private final JButton kirjauduUlosButton;
    private JButton etusivuButton;
    private JButton omatTiedotButton;
    private JButton pankkikortitButton;
    private JButton uusiMaksuButton;

    public Ylapalkki(JFrame frame, JPanel ikkuna, Jarjestelma jarjestelma, Asiakas asiakas) {
        this.frame = frame;
        this.ikkuna = ikkuna;
        this.jarjestelma = jarjestelma;
        this.asiakas = asiakas;

        this.kirjauduUlosButton = new JButton("Kirjaudu ulos");
        this.etusivuButton = new JButton("Etusivu");
        this.omatTiedotButton = new JButton("Omat Tiedot");
        this.pankkikortitButton = new JButton("Pankkikortit");
        this.uusiMaksuButton = new JButton("Uusi maksu");
    }

    public void luoYlapalkki() {
        JToolBar ylapalkki = new JToolBar();
        ylapalkki.setFloatable(false);
        ylapalkki.setBounds(0, 0, 1280, 25);

        Siirtyja siirtyja = new Siirtyja();
        kirjauduUlosButton.addMouseListener(siirtyja);
        etusivuButton.addMouseListener(siirtyja);
        omatTiedotButton.addMouseListener(siirtyja);
        pankkikortitButton.addMouseListener(siirtyja);
        uusiMaksuButton.addMouseListener(siirtyja);

        ylapalkki.add(kirjauduUlosButton);
        ylapalkki.add(etusivuButton);
        ylapalkki.add(omatTiedotButton);
        ylapalkki.add(pankkikortitButton);
        ylapalkki.add(uusiMaksuButton);
        ikkuna.add(ylapalkki);
    }

    private class Siirtyja implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == kirjauduUlosButton) {
                frame.getContentPane().removeAll();
                Kirjautumisikkuna kirjautumisIkkuna = new Kirjautumisikkuna(jarjestelma, frame);
                kirjautumisIkkuna.luoKirjautumisikkuna();
                frame.getContentPane().revalidate();
            }
            if (e.getSource() == etusivuButton) {
                frame.getContentPane().removeAll();
                Etusivu etusivu = new Etusivu(frame, jarjestelma, asiakas);
                etusivu.luoEtusivu();
                frame.getContentPane().revalidate();
            }
            if (e.getSource() == omatTiedotButton) {
                frame.getContentPane().removeAll();
                OmatTiedotIkkuna omatTiedotIkkuna = new OmatTiedotIkkuna(frame, jarjestelma, asiakas);
                omatTiedotIkkuna.luoOmatTiedotIkkuna();
                frame.getContentPane().revalidate();
            }
            if (e.getSource() == pankkikortitButton) {
                frame.getContentPane().removeAll();
                PankkikortitIkkuna pankkikortitIkkuna = new PankkikortitIkkuna(frame, jarjestelma, asiakas);
                pankkikortitIkkuna.luoPankkikortitIkkuna();
                frame.getContentPane().revalidate();
            }
            if (e.getSource() == uusiMaksuButton) {
                frame.getContentPane().removeAll();
                MaksuIkkuna maksuIkkuna = new MaksuIkkuna(frame, jarjestelma, asiakas);
                maksuIkkuna.luoMaksuIkkuna();
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
