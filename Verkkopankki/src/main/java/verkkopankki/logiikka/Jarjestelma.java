package verkkopankki.logiikka;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Tämä luokka on verkkopankin runko, se pitää kirjaa asiakkaista, niiden
 * tileistä ja tileihin linkitetyistä pankkikorteista. Järjestelmässä kulkee
 * kaikki tilien väliset toimitukset sekä tilin sisäiset toiminnot.
 *
 */
public class Jarjestelma {

    private final ArrayList<Tili> tilit;
    private final ArrayList<Asiakas> asiakkaat;
    private final ArrayList<Kortti> kortit;

    public Jarjestelma() {
        tilit = new ArrayList<>();
        asiakkaat = new ArrayList<>();
        kortit = new ArrayList<>();
    }

    public ArrayList<Asiakas> getAsiakkaat() {
        return asiakkaat;
    }

    /**
     * Metodi siirtää rahaa tililtä toiselle, jos lähtötilillä on tarpeeksi ja
     * jos siirrettävä summa on positiivinen
     *
     * @param lahde Tili, jolta rahat siirtyvät
     * @param kohde Tili, jolle rahat siirtyvät
     * @param summa Kuinka paljon rahaa siirtyy
     */
    public void tilisiirto(Tili lahde, Tili kohde, int summa) {
        if (summa <= 0 || summa > lahde.getSaldo()) {
            return;
        }

        lahde.muutaSaldoa(-summa);
        lahde.lisaaTilitapahtuma(kohde, -summa);
        kohde.muutaSaldoa(summa);
        kohde.lisaaTilitapahtuma(lahde, summa);
    }

    /**
     * Metodi toimii kuin ylläoleva, mutta tapahtuma-ajan voi asettaa itse.
     *
     * @param lahde Tili, jolta rahat siirtyvät
     * @param kohde Tili, jolle rahat siirtyvät
     * @param summa Kuinka paljon rahaa siirtyy
     * @param aika, jolloin tilisiirto tapahtui
     */
    public void tilisiirto(Tili lahde, Tili kohde, int summa, Calendar aika) {
        if (summa <= 0 || summa > lahde.getSaldo()) {
            return;
        }

        lahde.muutaSaldoa(-summa);
        lahde.lisaaTilitapahtuma(kohde, -summa, aika);
        kohde.muutaSaldoa(summa);
        kohde.lisaaTilitapahtuma(lahde, summa, aika);
    }

    /**
     * Metodi muuttaa tilin saldoa siihen linkitetyn kortin avulla, kunhan summa
     * ei ole suurempi kuin tilin saldo
     *
     * @param pankkikortti Tiliin linkitetty kortti, jonka avulla tilin saldoa
     * muutetaan
     * @param summa Rahamäärä, jonka verran tilin saldoa muutetaan
     */
    public void korttitoimitus(Kortti pankkikortti, int summa) {
        if (summa == 0 || -summa > pankkikortti.getTili().getSaldo()) {
            return;
        }
        pankkikortti.getTili().muutaSaldoa(summa);
        pankkikortti.getTili().lisaaTilitapahtuma(summa);
    }

    /**
     * Metodi luo tilin järjestelmään rekisteröityneelle asiakkaalle.
     * Omistamattomia tilejä ei siis voi luoda
     *
     * @param a Asiakas, jolle tili luodaan
     */
    public void luoTili(Asiakas a) {
        if (!getAsiakkaat().contains(a)) {
            return;
        }

        Tili tili = new Tili(tilinumerogeneraattori(tilit.size()));
        a.lisaaTili(tili);
        this.tilit.add(tili);

    }

    public ArrayList<Tili> getTilit() {
        return tilit;
    }

    /**
     * Metodi luo pankkikortin, linkittää sen tiliin ja lisää sen kortteja
     * kirjaavaan listaan
     *
     * @param t Tili, johon kortti linkitetään
     */
    public void luoKortti(Tili t) {
        Kortti kortti = new Kortti(t, "K" + t.getTilinro());
        t.setKortti(kortti);
        kortit.add(kortti);
    }

    /**
     * Metodi rekisteröi järjestelmään asiakkaan, jos käyttäjätunnusta ei ole jo
     * varattu
     *
     * @param asiakas Asiakas, joka rekisteröidään
     */
    public void lisaaAsiakas(Asiakas asiakas) {
        for (Asiakas b : asiakkaat) {
            if (b.getKäyttajatunnus().equalsIgnoreCase(asiakas.getKäyttajatunnus())) {
                return;
            }
        }
        asiakkaat.add(asiakas);
    }

    /**
     * Metodi hakee järjestelmästä asiakasta käyttäjätunnuksen perusteella
     *
     * @param tunnus merkkijono, joka on etsittävän asiakkaan käyttäjätunnus
     * @return Kyseinen asiakas tai null, jos käyttäjätunnusta ei ole
     */
    public Asiakas haeAsiakas(String tunnus) {
        for (Asiakas a : asiakkaat) {
            if (a.getKäyttajatunnus().equals(tunnus)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Metodi hakee järjestelmästä tiliä tilinumeron perusteella
     *
     * @param tilinro merkkijono, joka on etsittävän tilin tilinumero
     * @return Kyseinen tili tai null, jos tiliä ei ole
     */
    public Tili haeTili(String tilinro) {
        for (Tili t : tilit) {
            if (t.getTilinro().equals(tilinro)) {
                return t;
            }
        }
        return null;
    }

    private String tilinumerogeneraattori(int tilienMaara) {
        String tilinro = "";
        String apu = String.valueOf(tilienMaara + 1);

        for (int i = 0; i <= 7 - apu.length(); i++) {
            tilinro = tilinro + "0";
        }
        tilinro = tilinro + apu;
        tilinro = tilinro.substring(0, 4) + " " + tilinro.substring(4);
        return tilinro;
    }
}
