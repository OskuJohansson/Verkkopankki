package verkkopankki.logiikka;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Luokka, joka pitää sisällään tilitapahtumiin liittyvät tiedot. Eri
 * konstruktorit ovat eri tilitapahtumia varten, eli niihin, jossa on tehty
 * tilisiirto ja niihin, joissa rahaa on vain lisätty tai nostettu yhdeltä
 * tililtä. Konstruktorit, joissa on asetettava aika, ovat valmiina
 * tilanteisiin, joissa tapahtumia halutaan lisätä manuaaliisesti.
 *
 * @author oskajoha
 */
public class Tilitapahtuma {

    private final Tili toinenTili;
    private final int rahamaara;
    private final Calendar aika;

    /**
     * Konstruktori tilitapahtumalle, jossa rahaa nostetaan tai lisätään
     * tilille.
     *
     * @param rahamaara summa, joka nostetaan tililtä tai lisätään tilille.
     */
    public Tilitapahtuma(int rahamaara) {
        this.rahamaara = rahamaara;
        aika = new GregorianCalendar();
        toinenTili = null;
    }

    /**
     * Konstruktori tilitapahtumalle, jossa tehdään tilisiirto.
     *
     * @param rahamaara summa, joka siirretään tililtä toiselle.
     * @param tili tili, jonka kanssa tilisiirto on käyty.
     */
    public Tilitapahtuma(int rahamaara, Tili tili) {
        this.toinenTili = tili;
        this.rahamaara = rahamaara;
        aika = new GregorianCalendar();
    }

    /**
     * Konstruktori jossa ajan voi lisätä itse, lähinnä testitapauksiin.
     *
     * @param rahamaara summa, joka nostetaan tililtä tai lisätään tilille.
     * @param aika aika, jolloin tilitapahtuma on tapahtunut.
     */
    public Tilitapahtuma(int rahamaara, Calendar aika) {
        this.rahamaara = rahamaara;
        this.aika = aika;
        toinenTili = null;
    }

    /**
     * Konstruktori jossa ajan voi lisätä itse, lähinnä testitapauksiin
     *
     * @param rahamaara summa, joka siirretään tililtä toiselle.
     * @param tili tili, jonka kanssa tilisiirto on käyty.
     * @param aika aika, jolloin tilitapahtuma on tapahtunut.
     */
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
