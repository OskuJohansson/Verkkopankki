package verkkopankki.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import verkkopankki.kuuntelijat.Siirtaja;
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
    private final JButton kirjauduUlosButton, etusivuButton, omatTiedotButton, uusiMaksuButton;

    public Ylapalkki(JFrame frame, JPanel ikkuna, Jarjestelma jarjestelma, Asiakas asiakas) {
        this.frame = frame;
        this.ikkuna = ikkuna;
        this.jarjestelma = jarjestelma;
        this.asiakas = asiakas;

        this.kirjauduUlosButton = new JButton("Kirjaudu ulos");
        this.etusivuButton = new JButton("Etusivu");
        this.omatTiedotButton = new JButton("Omat tiedot");
        this.uusiMaksuButton = new JButton("Uusi maksu");
    }

    public void luoKomponentit() {
        JToolBar ylapalkki = new JToolBar();
        ylapalkki.setFloatable(false);
        ylapalkki.setBounds(0, 0, 1280, 25);

        kirjauduUlosButton.addMouseListener(new Siirtaja(new Kirjautumisikkuna(frame, jarjestelma)));
        etusivuButton.addMouseListener(new Siirtaja(new Etusivu(frame, jarjestelma, asiakas)));
        omatTiedotButton.addMouseListener(new Siirtaja(new OmatTiedotIkkuna(frame, jarjestelma, asiakas)));
        uusiMaksuButton.addMouseListener(new Siirtaja(new UusiMaksuIkkuna(frame, jarjestelma, asiakas)));

        ylapalkki.add(kirjauduUlosButton);
        ylapalkki.add(etusivuButton);
        ylapalkki.add(omatTiedotButton);

        ylapalkki.add(uusiMaksuButton);
        ikkuna.add(ylapalkki);
    }
}
