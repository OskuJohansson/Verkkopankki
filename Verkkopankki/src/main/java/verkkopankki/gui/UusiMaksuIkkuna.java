package verkkopankki.gui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import verkkopankki.logiikka.Asiakas;
import verkkopankki.logiikka.Jarjestelma;
import verkkopankki.logiikka.Tili;

/**
 *
 * @author Oskari
 */
public class UusiMaksuIkkuna extends Ikkuna {

    private final JFrame frame;
    private final Jarjestelma jarjestelma;
    private final JPanel ikkuna;
    private final Asiakas asiakas;
    private final JComboBox tilinValinta;
    private final JTextField kohdetiliField, summaField;

    public UusiMaksuIkkuna(JFrame frame, Jarjestelma jarjestelma, Asiakas asiakas) {
        super(frame, jarjestelma);
        this.frame = frame;
        this.jarjestelma = jarjestelma;
        this.asiakas = asiakas;
        this.ikkuna = new JPanel();
        this.tilinValinta = new JComboBox<>();
        this.kohdetiliField = new JTextField();
        this.summaField = new JTextField();

    }

    @Override
    public void luoKomponentit() {
        ikkuna.setLayout(null);

        Ylapalkki ylapalkki = new Ylapalkki(frame, ikkuna, jarjestelma, asiakas);

        for (Tili t : asiakas.getTilit()) {
            tilinValinta.addItem(t);
        }

        JLabel tiliLabel = new JLabel("Tili:");
        tiliLabel.setBounds(100, 200, 70, 25);
        JLabel kohdetiliLabel = new JLabel("Kohdetili:");
        kohdetiliLabel.setBounds(100, 230, 70, 25);
        JLabel summaLabel = new JLabel("Summa:");
        summaLabel.setBounds(100, 260, 70, 25);
        JLabel euroLabel = new JLabel("€");
        euroLabel.setBounds(342, 260, 10, 25);

        tilinValinta.setBounds(170, 200, 180, 25);
        kohdetiliField.setBounds(170, 230, 180, 25);
        summaField.setBounds(170, 260, 170, 25);

        JButton hyvaksyButton = new JButton("Hyväksy");
        hyvaksyButton.addMouseListener(new TilisiirronTekija());
        hyvaksyButton.setBounds(170, 300, 180, 25);

        ikkuna.add(tiliLabel);
        ikkuna.add(tilinValinta);
        ikkuna.add(kohdetiliLabel);
        ikkuna.add(kohdetiliField);
        ikkuna.add(summaLabel);
        ikkuna.add(summaField);
        ikkuna.add(euroLabel);
        ikkuna.add(hyvaksyButton);
        ikkuna.add(ohjeteksti());
        frame.getContentPane().add(ikkuna);
        ylapalkki.luoKomponentit();
    }

    private JLabel ohjeteksti() {
        JLabel ohjeLabel = new JLabel("<html>Täällä pystyt tekemään uuden maksun eli siirtämään rahaa tililtä toiselle.<br>"
                + "Voit siirtää rahaa muille omille tileillesi paitsi sille, jolta yrität rahaa siirtää.<br>"
                + "Huomioithan, että tilinumeron tulee olla muodossa 'XXXX XXXX' ja summan XXX.XX tai XXX,XX."
                + "</html>");
        ohjeLabel.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        ohjeLabel.setBounds(700, 150, 530, 150);

        return ohjeLabel;
    }

    private class TilisiirronTekija implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Tili tili = (Tili) tilinValinta.getSelectedItem();

            if (!onOikeaTili()) {
                JOptionPane.showMessageDialog(null, "Tarkista, että kohdetilin tilinumero on kirjoitettu oikein.\n"
                        + "Huomioithan, että tilinumero tulee olla muodossa 'XXXX XXXX'");
                return;
            }

            if (tili.getTilinro().equals(kohdetiliField.getText())) {
                JOptionPane.showMessageDialog(null, "Siirtoa ei voi tehdä lähtötilille.");
                return;
            }

            if (!summaOnOikeassaMudossa()) {
                JOptionPane.showMessageDialog(null, "Tarkista, että summa on oikeassa muodossa.");
                return;
            }

            if (tili.getSaldo() < eurotSenteiksi()) {
                JOptionPane.showMessageDialog(null, "Tilillä on liian vähän katetta.");
                return;
            }

            String ehdotettuSalasana = JOptionPane.showInputDialog(null, "Vahvista salsanallasi maksu");
            if (!asiakas.tasmaakoSalasana(ehdotettuSalasana)) {
                JOptionPane.showMessageDialog(null, "Väärä salasana");
            } else {
                jarjestelma.tilisiirto(tili, jarjestelma.haeTili(kohdetiliField.getText()), eurotSenteiksi());
                tilinValinta.setSelectedIndex(0);
                kohdetiliField.setText(null);
                summaField.setText(null);

                JOptionPane.showMessageDialog(null, "Maksu suoritettu!");
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

        private boolean summaOnOikeassaMudossa() {
            char[] syote = summaField.getText().toCharArray();
            if (syote.length > 2) {
                return syote[syote.length - 3] == ',' || syote[syote.length - 3] == '.';
            } else {
                return false;
            }
        }

        private int eurotSenteiksi() {
            char[] syote = summaField.getText().toCharArray();
            String summaSentteina = "";

            for (char t : syote) {
                if (t != '.' && t != ',') {
                    summaSentteina += t;
                }
            }

            return Integer.parseInt(summaSentteina);
        }

        private boolean onOikeaTili() {
            for (Tili t : jarjestelma.getTilit()) {
                if (t.getTilinro().equals(kohdetiliField.getText())) {
                    return true;
                }
            }
            return false;
        }
    }

}
