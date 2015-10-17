package verkkopankki.gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import verkkopankki.logiikka.Jarjestelma;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private final Jarjestelma jarjestelma;

    public Kayttoliittyma(Jarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        frame = new JFrame("Java Bank");
        frame.setPreferredSize(new Dimension(1280, 720));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKirjautumisikkuna();

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKirjautumisikkuna() {
        Kirjautumisikkuna kirjautumisIkkuna = new Kirjautumisikkuna(frame, jarjestelma);
        kirjautumisIkkuna.luoKomponentit();
    }

    private void luoEtusivu() {
        Etusivu etusivu = new Etusivu(frame, jarjestelma, jarjestelma.getAsiakkaat().get(0));
        etusivu.luoKomponentit();
    }

    public JFrame getFrame() {
        return frame;
    }
}
