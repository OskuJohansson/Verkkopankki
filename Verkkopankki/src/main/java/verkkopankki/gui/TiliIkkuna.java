/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verkkopankki.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import static java.lang.Integer.max;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import verkkopankki.logiikka.*;

/**
 *
 * @author Oskari
 */
public class TiliIkkuna extends Ikkuna {

    private final JFrame frame;
    private final Jarjestelma jarjestelma;
    private final Tili tili;
    private final Asiakas asiakas;
    private final JPanel ikkuna;

    public TiliIkkuna(JFrame frame, Jarjestelma jarjestelma, Tili tili, Asiakas asiakas) {
        super(frame, jarjestelma);
        this.frame = frame;
        this.jarjestelma = jarjestelma;
        this.tili = tili;
        this.asiakas = asiakas;
        this.ikkuna = new JPanel();
    }

    @Override
    public void luoKomponentit() {
        ikkuna.setLayout(null);

        Ylapalkki ylapalkki = new Ylapalkki(frame, ikkuna, jarjestelma, asiakas);

        JLabel tilitapahtumatLabel = new JLabel("Tilitapahtumat");
        tilitapahtumatLabel.setBounds(50, 130, 400, 15);

        JPanel lista = new JPanel();
        lista.setLayout(new GridLayout(max(11, tili.getTilitapahtumat().size()), 1, 0, 2));
        lista.setBackground(Color.WHITE);
        JScrollPane scrollbar = new JScrollPane(lista);
        scrollbar.setBounds(50, 150, 400, 400);

        try {
            luoTilitapahtumat(lista);
        } catch (Exception ex) {
            Logger.getLogger(TiliIkkuna.class.getName()).log(Level.SEVERE, null, ex);
        }




        ikkuna.add(tilitapahtumatLabel);
        ikkuna.add(scrollbar);
        ikkuna.add(ohjeteksti());
        frame.getContentPane().add(ikkuna);
        ylapalkki.luoKomponentit();
    }

    private JLabel ohjeteksti() {
        String onkoPankkikortti;

        if (tili.getKortti() != null) {
            onkoPankkikortti = "Tähän tiliin linkitetty pankkikortti on " + tili.getKortti().getNumero() + ".";
        } else {
            onkoPankkikortti = "Tähän tiliin ei ole linkitetty pankkikorttia.";
        }

        JLabel ohjeteksti = new JLabel("<html>Tälle tilille on yhteensä siirretty " + laskeTulot() / 100 + "." + laskeTulot() % 100 + "€<br>"
                + "<br>"
                + "Tältä tililtä on yhteensä siirretty " + laskeMenot() / 100 + "." + laskeMenot() % 100 + "€<br>"
                + "<br>"
                + onkoPankkikortti + "</html>");
        ohjeteksti.setBounds(500, 150, 530, 150);
        ohjeteksti.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        return ohjeteksti;
    }

    private void luoTilitapahtumat(Container c) throws Exception {

        for (Tilitapahtuma t : tili.getTilitapahtumat()) {
            JPanel tapahtumalappu = new JPanel(new FlowLayout(FlowLayout.LEFT));
            tapahtumalappu.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            if (t.getRahamaara() < 0) {
                tapahtumalappu.add(new JLabel(paivaJaAika(t) + ": Tililtä siirrettiin " + -t.getRahamaara() / 100 + "." + -t.getRahamaara() % 100 + "€ tilille " + t.getTili().getTilinro()));
                c.add(tapahtumalappu);
            } else {
                tapahtumalappu.add(new JLabel(paivaJaAika(t) + ": Tilille siirrettiin " + t.getRahamaara() / 100 + "." + t.getRahamaara() % 100 + "€ tililtä " + t.getTili().getTilinro()));
                c.add(tapahtumalappu);
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
