package verkkopankki.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import verkkopankki.logiikka.Asiakas;
import verkkopankki.logiikka.Jarjestelma;

/**
 *
 * @author oskajoha
 */
public class PankkikortitIkkuna {
    
    private final JFrame frame;
    private final JPanel ikkuna;
    private final Jarjestelma jarjestelma;
    private final Asiakas asiakas;

    public PankkikortitIkkuna(JFrame frame, Jarjestelma jarjestelma, Asiakas asiakas) {
        this.frame = frame;
        this.ikkuna = new JPanel();
        this.jarjestelma = jarjestelma;
        this.asiakas = asiakas;
    }
    
    public void luoPankkikortitIkkuna() {
          ikkuna.setLayout(null);

        Ylapalkki ylapalkki = new Ylapalkki(frame, ikkuna, jarjestelma, asiakas);

        JLabel testi = new JLabel("Tulossa...");
        testi.setBounds(400, 400, 100, 20);

        ikkuna.add(testi);
        frame.getContentPane().add(ikkuna);
        ylapalkki.luoYlapalkki();
    }
    
    
    
}
