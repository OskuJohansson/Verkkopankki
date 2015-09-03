
package verkkopankki.logiikka;

import java.util.ArrayList;


public class Jarjestelma {
    
    private final ArrayList<Tili> tilit;
    
    
    public Jarjestelma() {
        tilit = new ArrayList<>();
    }
    
    public void tilisiirto(Tili lahde, Tili kohde, int summa) {
        lahde.muutaSaldoa(-summa);
        kohde.muutaSaldoa(summa);
    }
    
    public void luoTili() {
        
    }
}
