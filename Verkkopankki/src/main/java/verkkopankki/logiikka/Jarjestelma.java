package verkkopankki.logiikka;

import java.util.ArrayList;

public class Jarjestelma {

    private final ArrayList<Tili> tilit;
    private final ArrayList<Asiakas> asiakkaat;

    public Jarjestelma() {
        tilit = new ArrayList<>();
        asiakkaat = new ArrayList<>();

    }

    public ArrayList<Asiakas> getAsiakkaat() {
        return asiakkaat;
    }

    public void tilisiirto(Tili lahde, Tili kohde, int summa) {
        lahde.muutaSaldoa(-summa);
        kohde.muutaSaldoa(summa);
    }

    public void luoTili(Asiakas a) {
        int apu = tilit.size() + 1;
        Tili tili = new Tili(Integer.toBinaryString(apu));
        this.tilit.add(tili);
        a.lisaaTili(tili);
    }
    
    public void luoAsiakas(String etunimi, String sukunimi, String tunnus, String salasana) {
        Asiakas a = new Asiakas(etunimi, sukunimi, tunnus, salasana);
        asiakkaat.add(a);
        luoTili(a);
    }
}
