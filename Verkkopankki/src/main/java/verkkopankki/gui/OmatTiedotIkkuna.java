package verkkopankki.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import verkkopankki.logiikka.Asiakas;
import verkkopankki.logiikka.Jarjestelma;

/**
 *
 * @author Oskari
 */
public class OmatTiedotIkkuna {

    private final JFrame frame;
    private final JPanel ikkuna;
    private final Jarjestelma jarjestelma;
    private final Asiakas asiakas;
    private final JTextField kayttisField;
    private final JTextField etunimiField;
    private final JTextField sukunimiField;
    private final JTextField sahkopostiField;
    private final JTextField puhnroField;
    private final JPasswordField vanhaSalasanaField;
    private final JPasswordField uusiSalasanaField;
    private final JPasswordField uusiSalasanaField2;

    public OmatTiedotIkkuna(JFrame frame, Jarjestelma j, Asiakas a) {
        this.frame = frame;
        this.ikkuna = new JPanel();
        this.jarjestelma = j;
        this.asiakas = a;
        this.kayttisField = new JTextField(a.getKäyttajatunnus());
        this.etunimiField = new JTextField(a.getEtunimi());
        this.sukunimiField = new JTextField(a.getSukunimi());
        this.sahkopostiField = new JTextField(a.getEmail());
        this.puhnroField = new JTextField(a.getPuhnro());
        this.vanhaSalasanaField = new JPasswordField();
        this.uusiSalasanaField = new JPasswordField();
        this.uusiSalasanaField2 = new JPasswordField();

    }

    public void luoOmatTiedotIkkuna() {
        ikkuna.setLayout(null);
        
        Ylapalkki ylapalkki = new Ylapalkki(frame, ikkuna, jarjestelma, asiakas);
        
        JPanel tietoPanel = new JPanel();
        tietoPanel.setBounds(80, 200, 370, 300);
        tietoPanel.setLayout(new GridLayout(9, 2, 0, 5));

        JLabel kayttisLabel = new JLabel("Käyttäjätunnus:");
        JLabel etunimiLabel = new JLabel("Etunimi:");
        JLabel sukunimiLabel = new JLabel("Sukunimi:");
        JLabel sahkopostiLabel = new JLabel("Sähköposti:");
        JLabel puhnroLabel = new JLabel("Puhelinnumero:");
        JLabel vanhaSalasanaLabel = new JLabel("Vanha salasana:");
        JLabel uusiSalasanaLabel = new JLabel("Uusi salasana:");
        JLabel uusisalasanaLabel2 = new JLabel("Toista uusi salasana:");

        kayttisField.setEditable(false);
        kayttisField.setBackground(Color.WHITE);
        kayttisField.setForeground(Color.GRAY);

        etunimiField.setEditable(false);
        etunimiField.setBackground(Color.WHITE);
        etunimiField.setForeground(Color.GRAY);

        sukunimiField.setEditable(false);
        sukunimiField.setBackground(Color.WHITE);
        sukunimiField.setForeground(Color.GRAY);

        JButton tallennaButton = new JButton("Tallenna tiedot");
        tallennaButton.addMouseListener(new Tallentaja());

        tietoPanel.add(kayttisLabel);
        tietoPanel.add(kayttisField);
        tietoPanel.add(etunimiLabel);
        tietoPanel.add(etunimiField);
        tietoPanel.add(sukunimiLabel);
        tietoPanel.add(sukunimiField);
        tietoPanel.add(sahkopostiLabel);
        tietoPanel.add(sahkopostiField);
        tietoPanel.add(puhnroLabel);
        tietoPanel.add(puhnroField);
        tietoPanel.add(vanhaSalasanaLabel);
        tietoPanel.add(vanhaSalasanaField);
        tietoPanel.add(uusiSalasanaLabel);
        tietoPanel.add(uusiSalasanaField);
        tietoPanel.add(uusisalasanaLabel2);
        tietoPanel.add(uusiSalasanaField2);
        tietoPanel.add(new JLabel(""));
        tietoPanel.add(tallennaButton);
        
        ikkuna.add(tietoPanel);
        frame.getContentPane().add(ikkuna);
        ylapalkki.luoYlapalkki();
    }

    private class Tallentaja implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (vanhaSalasanaField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(null, "Sinun täytyy kirjoittaa vanha salasanasi tallentaaksesi muutokset.");
                return;
            }

            if (!asiakas.tasmaakoSalasana(vanhaSalasanaField.getText())) {
                JOptionPane.showMessageDialog(null, "Väärä salasana!");
                return;
            }

            if (!Arrays.equals(uusiSalasanaField.getPassword(), uusiSalasanaField2.getPassword())) {
                JOptionPane.showMessageDialog(null, "Antamasi salasanat eivät täsmänneet. Kokeile uudestaan.");
                return;
            }

            asiakas.setEmail(sahkopostiField.getText());
            asiakas.setPuhnro(puhnroField.getText());

//            Yllä on jo tarkistettu onko molempien salasanakenttien sisältö sama, joten riittää tarkistaa onko toinen tyhjä.
            if (uusiSalasanaField.getPassword().length != 0) {
                Object[] options = {"Kyllä", "Ei"};
                int vahvistus = JOptionPane.showOptionDialog(null, "Haluatko varmasti vaihtaa salasanan?", "Vahvistus", JOptionPane.DEFAULT_OPTION, JOptionPane.CANCEL_OPTION, null, options, options[0]);

                if (vahvistus == 0) {
                    asiakas.setSalasana(vanhaSalasanaField.getText(), uusiSalasanaField.getText());
                }
            }

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
}
