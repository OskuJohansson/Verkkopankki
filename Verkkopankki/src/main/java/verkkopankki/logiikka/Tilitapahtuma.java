
package verkkopankki.logiikka;

import java.util.Date;

/**
 *
 * @author oskajoha
 */
public class Tilitapahtuma {
    
    private final Tili tili;
    private final int rahamaara;
    private Date aika;
    
    public Tilitapahtuma (Tili tili, int rahamaara) {
        this.tili = tili;
        this.rahamaara = rahamaara;
        aika = new Date();
                
    }
}
