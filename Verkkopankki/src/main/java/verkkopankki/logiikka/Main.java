package verkkopankki.logiikka;

import javax.swing.SwingUtilities;
import verkkopankki.gui.*;

public class Main {

    public static void main(String[] args) {

        Jarjestelma j = new Jarjestelma();
        
        Asiakas osku = new Asiakas("Oskari", "Johansson", "oskajoha", "banaan1");
        j.lisaaAsiakas(osku);
        j.luoTili(osku);
        j.luoTili(osku);
        j.luoTili(osku);
        j.luoTili(osku);
        
        Asiakas mikko = new Asiakas("Mikko", "Mallikas", "mmalli", "eiole");
        j.lisaaAsiakas(mikko);
        j.luoTili(mikko);
        
        Asiakas admin = new Asiakas("admin", "", "admin", "admin");
        j.lisaaAsiakas(admin);
        j.luoTili(admin);
        
        admin.getTilit().get(0).muutaSaldoa(100000000);
        
        j.tilisiirto(admin.getTilit().get(0), osku.getTilit().get(0), 100000);   
        j.tilisiirto(osku.getTilit().get(0), mikko.getTilit().get(0), 10000);
        j.tilisiirto(osku.getTilit().get(0), mikko.getTilit().get(0), 10000);
        j.tilisiirto(mikko.getTilit().get(0), osku.getTilit().get(0), 145);
        j.tilisiirto(mikko.getTilit().get(0), osku.getTilit().get(0), 100);
        j.tilisiirto(mikko.getTilit().get(0), osku.getTilit().get(0), 267);
        j.tilisiirto(mikko.getTilit().get(0), osku.getTilit().get(0), 2365);
        
        Kayttoliittyma kl = new Kayttoliittyma(j);
        SwingUtilities.invokeLater(kl);

    }

}
