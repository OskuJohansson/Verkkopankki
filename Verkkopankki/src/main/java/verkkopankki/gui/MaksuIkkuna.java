package verkkopankki.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import verkkopankki.logiikka.Asiakas;
import verkkopankki.logiikka.Jarjestelma;

/**
 *
 * @author Oskari
 */
public class MaksuIkkuna {

    private final JFrame frame;
    private final Jarjestelma jarjestelma;
    private final JPanel ikkuna;
    private final Asiakas asiakas;

    public MaksuIkkuna(JFrame frame, Jarjestelma jarjestelma, Asiakas asiakas) {
        this.frame = frame;
        this.jarjestelma = jarjestelma;
        this.asiakas = asiakas;
        this.ikkuna = new JPanel();

    }

    public void luoMaksuIkkuna() {
        ikkuna.setLayout(null);

        Ylapalkki ylapalkki = new Ylapalkki(frame, ikkuna, jarjestelma, asiakas);

        JLabel testi = new JLabel("Tulossa...");
        testi.setBounds(400, 40, 100, 20);

        ikkuna.add(testi);
        frame.getContentPane().add(ikkuna);
        ylapalkki.luoYlapalkki();
    }

}
