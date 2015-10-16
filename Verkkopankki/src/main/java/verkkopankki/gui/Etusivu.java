
package verkkopankki.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import verkkopankki.logiikka.*;

/**
 *
 * @author Oskari
 */
public class Etusivu {
    
    private final Asiakas asiakas;
    private final Jarjestelma j;
    private final JFrame frame;
    private final JPanel ikkuna;
    
    public Etusivu(JFrame frame, Jarjestelma j, Asiakas a) {
        this.asiakas = a;
        this.frame = frame;
        this.j = j;
        this.ikkuna = new JPanel();
    }
       
    public void luoEtusivu() {
        ikkuna.setLayout(null);
        
        Ylapalkki ylapalkki = new Ylapalkki(frame);
        
        JLabel tilitLabel = new JLabel("Tilit");
        tilitLabel.setBounds(50, 180, 400, 15);
        
        JPanel tililista = new JPanel(new GridLayout(10, 1, 0, 5));
        tililista.setBounds(50, 200, 400, 400);
        tililista.setBackground(Color.WHITE);
        tililista.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        for (Tili tili : asiakas.getTilit()) {
            JLabel tilinumeroLabel = new JLabel(tili.getTilinro() + " Saldo: " + tili.getSaldo() + "€");
            tilinumeroLabel.setFont(new Font("Ubuntu", Font.PLAIN, 13));
            tililista.add(tilinumeroLabel);
        }
        
        
        ikkuna.add(tilitLabel);
        ikkuna.add(tililista);
        frame.getContentPane().add(ikkuna);
        ylapalkki.luoYlapalkki();
    }
}
