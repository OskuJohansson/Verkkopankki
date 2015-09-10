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
        if (summa == 0 || summa > lahde.getSaldo()) {
            return;
        }

        lahde.muutaSaldoa(-summa);
        lahde.lisaaTilitapahtuma(kohde, -summa);
        kohde.muutaSaldoa(summa);
        kohde.lisaaTilitapahtuma(lahde, summa);
    }

    public void tilisiirto(Tili kohde, int summa) {
        if (summa == 0 || -summa > kohde.getSaldo()) {
            return;
        }
        kohde.muutaSaldoa(summa);
        kohde.lisaaTilitapahtuma(summa);
    }

    public void luoTili(Asiakas a) {
        Tili tili = new Tili(tilinumerogeneraattori(tilit.size()));
        this.tilit.add(tili);
        a.lisaaTili(tili);
    }

    public void lisaaAsiakas(Asiakas a) {
        asiakkaat.add(a);
    }

    public Asiakas haeAsiakas(String tunnus) {
        for (Asiakas a : asiakkaat) {
            if (a.getKäyttajatunnus().equals(tunnus)) {
                return a;
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
        return tilinro;
    }
}
