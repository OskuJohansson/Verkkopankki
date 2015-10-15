package verkkopankki.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

//        luoKomponentit(frame.getContentPane());
//        luoKirjautumisikkuna(frame);
        luoOmatTiedotIkkuna();       
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container c) {
        JLabel l = new JLabel("Hey");
        c.add(l);
    }

    private void luoKirjautumisikkuna(Container c) {
        Kirjautumisikkuna kirjautumisikkuna = new Kirjautumisikkuna(frame, jarjestelma);
    }
    
    private void luoEtusivu() {
        Etusivu etusivu = new Etusivu(frame, jarjestelma);
    }
    
    private void luoTiliIkkuna() {
        TiliIkkuna tiliIkkuna = new TiliIkkuna(frame, jarjestelma, jarjestelma.getTilit().get(0));
        tiliIkkuna.luoTiliIkkuna();
    }
    
    private void luoOmatTiedotIkkuna() {
        OmatTiedotIkkuna ikkuna = new OmatTiedotIkkuna(jarjestelma, jarjestelma.getAsiakkaat().get(0));
        frame.getContentPane().add(ikkuna.luoOmatTiedotIkkuna());
    }

    public JFrame getFrame() {
        return frame;
    }
}
