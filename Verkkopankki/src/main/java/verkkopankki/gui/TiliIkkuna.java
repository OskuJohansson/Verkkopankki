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
    private final Asiakas asiakas;
    private final JPanel ikkuna;

    public TiliIkkuna(JFrame frame, Jarjestelma jarjestelma, Tili tili, Asiakas asiakas) {
        this.frame = frame;
        this.jarjestelma = jarjestelma;
        this.tili = tili;
        this.asiakas = asiakas;
        this.ikkuna = new JPanel();
    }

    public void luoTiliIkkuna() {
        ikkuna.setLayout(null);

        Ylapalkki ylapalkki = new Ylapalkki(frame, ikkuna, jarjestelma, asiakas);

        JLabel tilitapahtumatLabel = new JLabel("Tilitapahtumat");
        tilitapahtumatLabel.setBounds(50, 130, 400, 15);

        JPanel lista = new JPanel();
        lista.setLayout(new GridLayout(tili.getTilitapahtumat().size(), 1, 0, 15));
        lista.setBackground(Color.WHITE);
        JScrollPane scrollbar = new JScrollPane(lista);
        scrollbar.setBounds(50, 150, 400, 400);

        luoTilitapahtumat(lista);
        
        JLabel tulotLabel = new JLabel("Tälle tilille on yhteensä siirretty " + laskeTulot()/100 + "." + laskeTulot()%100 + "€");
        tulotLabel.setBounds(500, 200, 300, 20);
        JLabel menotLabel = new JLabel("Tältä tililtä on yhteensä siirretty " + laskeMenot()/100 + "." + laskeMenot()%100 + "€");
        menotLabel.setBounds(500, 250, 300, 20);
        
        ikkuna.add(tilitapahtumatLabel);
        ikkuna.add(scrollbar);
        ikkuna.add(tulotLabel);
        ikkuna.add(menotLabel);
        frame.getContentPane().add(ikkuna);
        ylapalkki.luoYlapalkki();
    }

    private void luoTilitapahtumat(Container c) {

        for (Tilitapahtuma t : tili.getTilitapahtumat()) {
            if (t.getRahamaara() < 0) {
                c.add(new JLabel(paivaJaAika(t) + ": Tililtä siirrettiin " + -t.getRahamaara()/100 + "." + -t.getRahamaara()%100 + "€ tilille " + t.getTili().getTilinro()));
            } else {
                c.add(new JLabel(paivaJaAika(t) + ": Tilille siirrettiin " + t.getRahamaara()/100 + "." + t.getRahamaara()%100 + "€ tililtä " + t.getTili().getTilinro()));
            }
        }
    }
    
    private int laskeTulot() {
        int tulot = 0;
        for (Tilitapahtuma t : tili.getTilitapahtumat()) {
            if (t.getRahamaara() > 0) {
                tulot += t.getRahamaara();
            }
        }
        return tulot;
    }
    
    private int laskeMenot() {
        int menot = 0;
        for (Tilitapahtuma t : tili.getTilitapahtumat()) {
            if (t.getRahamaara() < 0) {
                menot -= t.getRahamaara();
            }
        }
        return menot;
    }

    private String paivaJaAika(Tilitapahtuma t) {
        return "" + t.getAika().get(Calendar.DAY_OF_WEEK_IN_MONTH) + "."
                + t.getAika().get(Calendar.MONTH) + "." + t.getAika().get(Calendar.YEAR)
                + " " + t.getAika().get(Calendar.HOUR_OF_DAY) + ":" + t.getAika().get(Calendar.MINUTE);
    }

}
