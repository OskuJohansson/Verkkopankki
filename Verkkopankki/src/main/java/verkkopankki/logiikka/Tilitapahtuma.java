package verkkopankki.logiikka;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author oskajoha
 */
public class Tilitapahtuma {

    private final Tili toinenTili;
    private final int rahamaara;
    private final Calendar aika;

    public Tilitapahtuma(int rahamaara) {
        this.rahamaara = rahamaara;
        aika = new GregorianCalendar();
        toinenTili = null;
    }

    public Tilitapahtuma(int rahamaara, Tili tili) {
        this.toinenTili = tili;
        this.rahamaara = rahamaara;
        aika = new GregorianCalendar();
    }
    
        public Tilitapahtuma(int rahamaara, Calendar aika) {
        this.rahamaara = rahamaara;
        this.aika = aika;
        toinenTili = null;
    }

    public Tilitapahtuma(int rahamaara, Tili tili, Calendar aika) {
        this.toinenTili = tili;
        this.rahamaara = rahamaara;
        this.aika = aika;
    }

    public Tili getTili() {
        return toinenTili;
    }

    public int getRahamaara() {
        return rahamaara;
    }

    public Calendar getAika() {
        return aika;
    }
}
