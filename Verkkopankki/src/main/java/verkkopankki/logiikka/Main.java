package verkkopankki.logiikka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.SwingUtilities;
import verkkopankki.gui.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Jarjestelma j = new Jarjestelma();
        
//        FileReader loki = new FileReader("src/main/java/verkkopankki/logiikka/Loki.txt");
//        BufferedReader lukija = new BufferedReader(loki);
//        
//        
//        String komento = lukija.readLine();
//        while (komento != null) {
//  
//        }
//        System.out.println(lukija.readLine());
        Asiakas osku = new Asiakas("Oskari", "Johansson", "oskajoha", "banaan1");
        j.lisaaAsiakas(osku);
        j.luoTili(osku);
        j.luoTili(osku);
        j.luoTili(osku);
        j.luoTili(osku);
        
        Asiakas sanni = new Asiakas("Sanni", "Visakko", "sannivisakko", "eiole");
        j.lisaaAsiakas(sanni);
        j.luoTili(sanni);
        
        Asiakas admin = new Asiakas("admin", "", "admin", "admin");
        j.lisaaAsiakas(admin);
        j.luoTili(admin);
        
        admin.getTilit().get(0).muutaSaldoa(100000000);
        
        j.tilisiirto(admin.getTilit().get(0), osku.getTilit().get(0), 100000);   
        j.tilisiirto(osku.getTilit().get(0), sanni.getTilit().get(0), 10000);
        j.tilisiirto(osku.getTilit().get(0), sanni.getTilit().get(0), 10000);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 145);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 100);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 267);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 2365);
        
        Kayttoliittyma kl = new Kayttoliittyma(j);
        SwingUtilities.invokeLater(kl);

    }

}
