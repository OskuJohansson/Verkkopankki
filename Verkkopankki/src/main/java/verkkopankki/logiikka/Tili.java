package verkkopankki.logiikka;

import java.util.ArrayList;
import java.util.Date;

/**
 * Luokka pitää sisällään kaikki tiliin liittyvät tiedot sekä siihen
 * mahdollisesti linkitetyn pankkikortin
 *
 * @author Oskari
 */
public class Tili {

    private final String tilinro;
    private int saldo;
    private final ArrayList<String> tilitapahtumat;
    private Kortti kortti;

    public Tili(String tilinro) {
        saldo = 0;
        this.tilinro = tilinro;
        tilitapahtumat = new ArrayList<>();
    }

    public void muutaSaldoa(int summa) {
        if (saldo >= -summa) {
            this.saldo += summa;
        }
    }

    public String getTilinro() {
        return tilinro;
    }

    public int getSaldo() {
        return this.saldo;
    }

    @Override
    public String toString() {
        return "Tilin " + tilinro + " saldo on " + saldo + "€";
    }

    /**
     * Metodi lisää tilitapahtumista kirjaa pitävään listaan uuden tapahtuman,
     * joka käytiin toisen tilin kanssa
     *
     * @param tili Tili, jolta tai jonne summa siirtyi
     * @param summa Se rahamäärä, joka siirrettiin
     */
    public void lisaaTilitapahtuma(Tili tili, int summa) {
        if (summa < 0 && saldo >= -summa) {
            tilitapahtumat.add("Tililtä siirrettiin " + (-summa) + "€ tilille " + tili.getTilinro());
        }
        if (summa > 0) {
            tilitapahtumat.add("Tilille siirrettiin " + summa + "€ tililtä " + tili.getTilinro());
        }
    }

    /**
     * Metodi lisää tilitapahtumista kirjaa pitävään listaan uuden tapahtuman,
     * jossa tilille asetettiin tai tililtä nostettiin rahaa
     *
     * @param summa Se rahamäärä, joka tililtä nostettiin tai sinne asetettiin
     */
    public void lisaaTilitapahtuma(int summa) {
        if (summa < 0 && saldo >= -summa) {
            tilitapahtumat.add("Tililtä nostettiin " + (-summa) + "€");
        }
        if (summa > 0) {
            tilitapahtumat.add("Tilille lisättiin " + summa + "€");
        }
    }

    public ArrayList<String> getTilitapahtumat() {
        return tilitapahtumat;
    }

    public Kortti getKortti() {
        return kortti;
    }

    public void setKortti(Kortti kortti) {
        this.kortti = kortti;
    }

}
