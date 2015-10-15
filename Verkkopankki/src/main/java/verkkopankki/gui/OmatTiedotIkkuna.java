package verkkopankki.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.JButton;
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

    private final JPanel ikkuna;
    private final Jarjestelma j;
    private final Asiakas a;
    private final JTextField kayttisField;
    private final JTextField etunimiField;
    private final JTextField sukunimiField;
    private JTextField sahkopostiField;
    private JTextField puhnroField;
    private JPasswordField vanhaSalasanaField;
    private JPasswordField uusiSalasanaField;
    private JPasswordField uusiSalasanaField2;

    public OmatTiedotIkkuna(Jarjestelma j, Asiakas a) {
        this.ikkuna = new JPanel();
        this.j = j;
        this.a = a;
        kayttisField = new JTextField(a.getKäyttajatunnus());
        etunimiField = new JTextField(a.getEtunimi());
        sukunimiField = new JTextField(a.getSukunimi());
        sahkopostiField = new JTextField(a.getEmail());
        puhnroField = new JTextField(a.getPuhnro());
        vanhaSalasanaField = new JPasswordField();
        uusiSalasanaField = new JPasswordField();
        uusiSalasanaField2 = new JPasswordField();

    }

    public Container luoOmatTiedotIkkuna() {
        ikkuna.setLayout(null);
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
        tallennaButton.addMouseListener(new tallentaja());

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

        return ikkuna;
    }

    private class tallentaja implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (!a.tasmaakoSalasana(vanhaSalasanaField.getText())) {
                JOptionPane.showMessageDialog(null, "Väärä salasana");
                return;
            }
            if (!Arrays.equals(uusiSalasanaField.getPassword(), uusiSalasanaField2.getPassword())) {
                JOptionPane.showMessageDialog(null, "Antamasi salasanat eivät täsmänneet. Kokeile uudestaan.");
                return;
            }
            a.setEmail(sahkopostiField.getText());
            a.setPuhnro(puhnroField.getText());
            if (uusiSalasanaField.getPassword().length != 0) {
                JOptionPane.showMessageDialog(null, "Haluatko varmasti vaihtaa salasanan?");
                a.setSalasana(vanhaSalasanaField.getText(), uusiSalasanaField.getText());
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
