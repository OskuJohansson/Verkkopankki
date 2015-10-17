package verkkopankki.kuuntelijat;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import verkkopankki.gui.Ikkuna;
import verkkopankki.gui.Kirjautumisikkuna;

/**
 *
 * @author Oskari
 */
public class Siirtaja implements MouseListener {

    private final Ikkuna ikkuna;

    public Siirtaja(Ikkuna ikkuna) {
        this.ikkuna = ikkuna;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (ikkuna.getClass() == Kirjautumisikkuna.class) {
            Object[] options = {"Kyllä", "Ei"};
            int vahvistus = JOptionPane.showOptionDialog(null, "Haluatko varmasti kirjautua ulos?", "Kirjaudu ulos", JOptionPane.DEFAULT_OPTION, JOptionPane.CANCEL_OPTION, null, options, options[0]);

            if (vahvistus == 1) {
                return;
            }
        }
        ikkuna.getFrame().getContentPane().removeAll();
        ikkuna.luoKomponentit();
        ikkuna.getFrame().getContentPane().revalidate();
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
