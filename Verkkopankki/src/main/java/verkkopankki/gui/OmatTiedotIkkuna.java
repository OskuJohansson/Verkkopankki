package verkkopankki.gui;

import java.awt.Color;
import java.awt.Font;
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
public class OmatTiedotIkkuna extends Ikkuna {

    private final JFrame frame;
    private final JPanel ikkuna;
    private final Jarjestelma jarjestelma;
    private final Asiakas asiakas;
    private final JTextField kayttisField, etunimiField, sukunimiField, sahkopostiField, puhnroField;
    private final JPasswordField vanhaSalasanaField;
    private final JPasswordField uusiSalasanaField;
    private final JPasswordField uusiSalasanaField2;

    public OmatTiedotIkkuna(JFrame frame, Jarjestelma jarjestelma, Asiakas asiakas) {
        super(frame, jarjestelma);
        this.frame = frame;
        this.ikkuna = new JPanel();
        this.jarjestelma = jarjestelma;
        this.asiakas = asiakas;
        this.kayttisField = new JTextField(asiakas.getKäyttajatunnus());
        this.etunimiField = new JTextField(asiakas.getEtunimi());
        this.sukunimiField = new JTextField(asiakas.getSukunimi());
        this.sahkopostiField = new JTextField(asiakas.getEmail());
        this.puhnroField = new JTextField(asiakas.getPuhnro());
        this.vanhaSalasanaField = new JPasswordField();
        this.uusiSalasanaField = new JPasswordField();
        this.uusiSalasanaField2 = new JPasswordField();

    }

    @Override
    public void luoKomponentit() {
        ikkuna.setLayout(null);

        Ylapalkki ylapalkki = new Ylapalkki(frame, ikkuna, jarjestelma, asiakas);

        JPanel tietoPanel = new JPanel();
        tietoPanel.setBounds(50, 150, 370, 300);
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
        tallennaButton.addMouseListener(new TietojenTallentaja());

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
        ikkuna.add(ohjeteksti());
        frame.getContentPane().add(ikkuna);
        ylapalkki.luoKomponentit();
    }

    private JLabel ohjeteksti() {
        JLabel ohjeLabel = new JLabel("<html>Tällä sivulla pystyt vaihtaman henkilökohtaisia tietojasi.<br>"
                + "Turvallisuussyistä omaa nimeä tai käyttäjätunnusta ei pysty muuttamaan itse.<br>"
                + "Tiedot tallennetaan syöttämällä salasana.<br>"
                + "Jos salasanaa haluaa muuttaa, täytyy myös täyttää uusi salasana kahteen kertaan."
                + "</html>");
        ohjeLabel.setBounds(700, 150, 530, 150);
        ohjeLabel.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        return ohjeLabel;
    }

    private class TietojenTallentaja implements MouseListener {

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

            //Yllä on jo tarkistettu onko molempien salasanakenttien sisältö sama, joten riittää tarkistaa onko toinen tyhjä.
            if (uusiSalasanaField.getPassword().length != 0) {
                Object[] options = {"Kyllä", "Ei"};
                int vahvistus = JOptionPane.showOptionDialog(null, "Haluatko varmasti vaihtaa salasanan?", "Vahvistus", JOptionPane.DEFAULT_OPTION, JOptionPane.CANCEL_OPTION, null, options, options[0]);

                if (vahvistus == 0) {
                    asiakas.setSalasana(vanhaSalasanaField.getText(), uusiSalasanaField.getText());
                    asiakas.setEmail(sahkopostiField.getText());
                    asiakas.setPuhnro(puhnroField.getText());
                    tyhjennaSalasanakentat();
                    JOptionPane.showMessageDialog(null, "Salasana vaihdettu!");
                    return;
                }
            }

            asiakas.setEmail(sahkopostiField.getText());
            asiakas.setPuhnro(puhnroField.getText());
            tyhjennaSalasanakentat();
            JOptionPane.showMessageDialog(null, "Tiedot tallennettu!");

        }

        private void tyhjennaSalasanakentat() {
            vanhaSalasanaField.setText(null);
            uusiSalasanaField.setText(null);
            uusiSalasanaField2.setText(null);
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
