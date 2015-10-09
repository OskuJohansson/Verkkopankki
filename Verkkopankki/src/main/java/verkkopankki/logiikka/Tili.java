package verkkopankki.logiikka;

import java.util.ArrayList;

/**
 * Luokka pitää sisällään kaikki tiliin liittyvät tiedot sekä siihen
 * mahdollisesti linkitetyn pankkikortin
 *
 * @author Oskari
 */
public class Tili {

    private final String tilinro;
    private int saldo;
    private final ArrayList<Tilitapahtuma> tilitapahtumat;
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
        if (summa != 0 && saldo >= -summa) {
            tilitapahtumat.add(new Tilitapahtuma(summa, tili));
        }

    }

    /**
     * Metodi lisää tilitapahtumista kirjaa pitävään listaan uuden tapahtuman,
     * jossa tilille asetettiin tai tililtä nostettiin rahaa
     *
     * @param summa Se rahamäärä, joka tililtä nostettiin tai sinne asetettiin
     */
    public void lisaaTilitapahtuma(int summa) {
        if (summa != 0 && saldo >= -summa) {
            tilitapahtumat.add(new Tilitapahtuma(summa));
        }
    }

    public ArrayList<Tilitapahtuma> getTilitapahtumat() {
        return tilitapahtumat;
    }

    public Kortti getKortti() {
        return kortti;
    }

    public void setKortti(Kortti kortti) {
        this.kortti = kortti;
    }

}
