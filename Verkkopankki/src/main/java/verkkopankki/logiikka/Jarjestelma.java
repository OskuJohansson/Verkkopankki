package verkkopankki.logiikka;

import java.util.ArrayList;

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

    public void tilisiirto(Tili lahde, Tili kohde, int summa) {
        if (summa <= 0 || summa > lahde.getSaldo()) {
            return;
        }

        lahde.muutaSaldoa(-summa);
        lahde.lisaaTilitapahtuma(kohde, -summa);
        kohde.muutaSaldoa(summa);
        kohde.lisaaTilitapahtuma(lahde, summa);
    }

    public void korttitoimitus(Kortti pankkikortti, int summa) {
        if (summa == 0 || -summa > pankkikortti.getTili().getSaldo()) {
            return;
        }
        pankkikortti.getTili().muutaSaldoa(summa);
        pankkikortti.getTili().lisaaTilitapahtuma(summa);
    }

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
    
    public void luoKortti(Tili t) {
        Kortti kortti = new Kortti(t, "K" + t.getTilinro());
        t.setKortti(kortti);
        kortit.add(kortti);
    }

    public void lisaaAsiakas(Asiakas a) {
        for (Asiakas b : asiakkaat) {
            if (b.getKäyttajatunnus().equalsIgnoreCase(a.getKäyttajatunnus())) {
                return;
            }
        }
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
        //Muuta vielä niin että tilinumero on muodossa "XXXX XXXX"       
        String tilinro = "";
        String apu = String.valueOf(tilienMaara + 1);

        for (int i = 0; i <= 7 - apu.length(); i++) {
            tilinro = tilinro + "0";
        }
        tilinro = tilinro + apu;
        return tilinro;
    }
}
