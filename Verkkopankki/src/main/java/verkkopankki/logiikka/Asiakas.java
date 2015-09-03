
package verkkopankki.logiikka;

import java.util.ArrayList;

public class Asiakas {
    
    private final String etunimi;
    private final String sukunimi;
    private String email;
    private String puhnro;
    private ArrayList<Tili> tilit;
    
        public Asiakas(String etunimi, String sukunimi) {
            this.etunimi = etunimi;
            this.sukunimi = sukunimi;
            this.tilit = new ArrayList<>();
        }
        
      public void lisaaTili(Tili tili) {
          tilit.add(tili);
      }  
}
