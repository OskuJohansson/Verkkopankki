/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verkkopankki.gui;

import javax.swing.JFrame;
import verkkopankki.logiikka.Jarjestelma;

/**
 *
 * @author Oskari
 */
public class Ikkuna {
    
    private final JFrame frame;
    private final Jarjestelma jarjestelma;

    public Ikkuna(JFrame frame, Jarjestelma jarjestelma) {
        this.frame = frame;
        this.jarjestelma = jarjestelma;

    }
    
    public void luoKomponentit() {
    }

    public JFrame getFrame() {
        return frame;
    }
    
}
