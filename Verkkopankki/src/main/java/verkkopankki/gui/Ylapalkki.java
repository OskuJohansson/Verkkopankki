
package verkkopankki.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

/**
 *
 * @author Oskari
 */
public class Ylapalkki {
    
    private final JToolBar ylapalkki;
    private final JFrame frame;

    public Ylapalkki(JFrame frame) {
        this.ylapalkki = new JToolBar();
        this.frame = frame;
    }
    
    public void luoYlapalkki() {
        JButton kirjauduUlosButton = new JButton("Kirjaudu ulos");
        
        ylapalkki.add(kirjauduUlosButton);
        frame.getContentPane().add(ylapalkki);
    }
}
