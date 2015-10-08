
package verkkopankki.logiikka;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author oskajoha
 */
public class Tilitapahtuma {
    
    private final Tili tili;
    private final int rahamaara;
    private final Calendar aika;
    
    public Tilitapahtuma (Tili tili, int rahamaara) {
        this.tili = tili;
        this.rahamaara = rahamaara;
        aika = new GregorianCalendar();              
    }
    
    public Tilitapahtuma(Tili tili, int rahamaara, Calendar aika) {
        this.tili = tili;
        this.rahamaara = rahamaara;
        this.aika = aika;
    }

    public Tili getTili() {
        return tili;
    }

    public int getRahamaara() {
        return rahamaara;
    }

    public Calendar getAika() {
        return aika;
    }
}
