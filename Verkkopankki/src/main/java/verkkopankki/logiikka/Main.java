package verkkopankki.logiikka;

import javax.swing.SwingUtilities;
import verkkopankki.gui.*;

public class Main {

    public static void main(String[] args) {

        Jarjestelma j = new Jarjestelma();
        Asiakas osku = new Asiakas("Oskari", "Johansson", "oskajoha", "banaan1");
        j.lisaaAsiakas(osku);
//        for (int i = 0; i <= 1000000; i++) {
//            j.luoTili(osku);
//        }
//         for (Tili tili : j.getTilit()) {
//             System.out.println(tili);
//        }
        Kayttoliittyma kl = new Kayttoliittyma();
        SwingUtilities.invokeLater(kl);
    }

}
