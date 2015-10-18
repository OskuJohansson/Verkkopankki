package verkkopankki.logiikka;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Luokka pitää sisällään kaikki tiliin liittyvät tiedot sekä siihen
 * mahdollisesti linkitetyn pankkikortin
 *
 * @author Oskari
 */
public class Tili {

    private final String tilinro;
    private int saldoSentteinä;
    private final ArrayList<Tilitapahtuma> tilitapahtumat;
    private Kortti kortti;

    public Tili(String tilinro) {
        this.saldoSentteinä = 0;
        this.tilinro = tilinro;
        this.tilitapahtumat = new ArrayList<>();
    }

    public void muutaSaldoa(int summa) {
        if (saldoSentteinä >= -summa) {
            this.saldoSentteinä += summa;
        }
    }

    public String getTilinro() {
        return tilinro;
    }

    public int getSaldo() {
        return this.saldoSentteinä;
    }

    @Override
    public String toString() {
        return tilinro + " Saldo: " + saldoSentteinä / 100 + "." + saldoSentteinä % 100 + "€";
    }

    /**
     * Metodi lisää tilitapahtumista kirjaa pitävään listaan uuden tapahtuman,
     * joka käytiin toisen tilin kanssa
     *
     * @param tili Tili, jolta tai jonne summa siirtyi
     * @param summa Se rahamäärä, joka siirrettiin
     */
    public void lisaaTilitapahtuma(Tili tili, int summa) {
        if (summa != 0 && saldoSentteinä >= -summa) {
            tilitapahtumat.add(new Tilitapahtuma(summa, tili));
        }

    }

    /**
     * Metodi on samankaltainen kuin yllä, mutta tapahtuma-ajan voi asettaa itse
     *
     * @param tili Tili, jolta tai jonne summa siirtyi
     * @param summa Se rahamäärä, joka siirrettiin
     * @param aika aika, jolloin tilisiirto tapahtui
     */
    public void lisaaTilitapahtuma(Tili tili, int summa, Calendar aika) {
        if (summa != 0 && saldoSentteinä >= -summa) {
            tilitapahtumat.add(new Tilitapahtuma(summa, tili, aika));
        }
    }

    /**
     * Metodi lisää tilitapahtumista kirjaa pitävään listaan uuden tapahtuman,
     * jossa tilille asetettiin tai tililtä nostettiin rahaa
     *
     * @param summa Se rahamäärä, joka tililtä nostettiin tai sinne asetettiin
     */
    public void lisaaTilitapahtuma(int summa) {
        if (summa != 0 && saldoSentteinä >= -summa) {
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
