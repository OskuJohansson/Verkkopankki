package verkkopankki.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class Kirjautumisikkuna {

    private JFrame frame;
    private JTextField kayttajatunnusField;
    private JTextField salasanaField;

    public Kirjautumisikkuna() {
        kayttajatunnusField = new JTextField();
        salasanaField = new JTextField();

    }

    public Container luoKomponentit(Container c) {
        
        JLabel kayttajatunnusLabel = new JLabel("Käyttäjätunnus");
        kayttajatunnusLabel.setBounds(400, 300, 50, 10);
        JLabel salasanaLabel = new JLabel("Salasana");
        salasanaLabel.setBounds(400, 350, 50, 10);

        kayttajatunnusField.setBounds(455, 300, 50, 10);
        salasanaField.setBounds(455, 350, 50, 100);

        c.add(kayttajatunnusLabel);
        c.add(salasanaLabel);
        c.add(kayttajatunnusField);
        c.add(salasanaField);
        return c;
    }

    public JFrame getFrame() {
        return frame;
    }

}
