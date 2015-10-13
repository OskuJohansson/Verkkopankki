package verkkopankki.logiikka;

import javax.swing.SwingUtilities;
import verkkopankki.gui.*;

public class Main {

    public static void main(String[] args) {

        Jarjestelma j = new Jarjestelma();
        Asiakas osku = new Asiakas("Oskari", "Johansson", "oskajoha", "banaan1");
        j.lisaaAsiakas(osku);
        j.luoTili(osku);
        Asiakas sanni = new Asiakas("Sanni", "Visakko", "sannivisakko", "eiole");
        j.lisaaAsiakas(sanni);
        j.luoTili(sanni);
        osku.getTilit().get(0).muutaSaldoa(1000000);
        j.tilisiirto(osku.getTilit().get(0), sanni.getTilit().get(0), 10000);
        j.tilisiirto(osku.getTilit().get(0), sanni.getTilit().get(0), 10000);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 100);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 100);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 100);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 100);
        
//        for (int i = 0; i <= 1000000; i++) {
//            j.luoTili(osku);
//        }
//         for (Tili tili : j.getTilit()) {
//             System.out.println(tili);
//        }
        
        
        Kayttoliittyma kl = new Kayttoliittyma(j);
        SwingUtilities.invokeLater(kl);

    }

}
