/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verkkopankki.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import verkkopankki.logiikka.*;

/**
 *
 * @author Oskari
 */
public class TiliIkkuna {

    private final JFrame frame;
    private final Jarjestelma jarjestelma;
    private final Tili tili;

    public TiliIkkuna(JFrame frame, Jarjestelma jarjestelma, Tili tili) {
        this.frame = frame;
        this.jarjestelma = jarjestelma;
        this.tili = tili;
    }

    public void luoTiliIkkuna() {
        frame.setLayout(null);
        
        JToolBar ylapalkki = new JToolBar();

        JLabel tilitapahtumatLabel = new JLabel("Tilitapahtumat");
        tilitapahtumatLabel.setBounds(50, 180, 300, 15);

        JPanel lista = new JPanel();
        lista.setLayout(new GridLayout(tili.getTilitapahtumat().size(), 1, 0, 15));
        lista.setBackground(Color.WHITE);
        JScrollPane scrollbar = new JScrollPane(lista);
        scrollbar.setBounds(50, 200, 350, 400);

        luoTilitapahtumat(lista);

        frame.add(ylapalkki);
        frame.add(tilitapahtumatLabel);
        frame.add(scrollbar);
    }

    private void luoTilitapahtumat(Container c) {

        for (Tilitapahtuma t : tili.getTilitapahtumat()) {
            if (t.getRahamaara() < 0) {
                c.add(new JLabel(paivaJaAika(t) + ": Tililtä siirrettiin " + -t.getRahamaara() + "€ tilille " + t.getTili().getTilinro()));
            } else {
                c.add(new JLabel(paivaJaAika(t) + ": Tilille siirrettiin " + t.getRahamaara() + "€ tililtä " + t.getTili().getTilinro()));
            }
        }
    }

    private String paivaJaAika(Tilitapahtuma t) {
        return "" + t.getAika().get(Calendar.DAY_OF_WEEK_IN_MONTH) + "." + 
                t.getAika().get(Calendar.MONTH) + "." + t.getAika().get(Calendar.YEAR)
                + " " + t.getAika().get(Calendar.HOUR_OF_DAY) + ":" + t.getAika().get(Calendar.MINUTE);
    }

    
    

}
