package verkkopankki.logiikka;

import java.util.ArrayList;

public class Tili {

    private final String tilinro;
    private int saldo;
    private final ArrayList<String> tilitapahtumat;

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

    public void lisaaTilitapahtuma(Tili tili, int summa) {
        if (summa < 0 && saldo >= -summa) {
            tilitapahtumat.add("Tililtä siirrettiin " + (-summa) + "€ tilille " + tili.getTilinro());
        }
        if (summa > 0) {
            tilitapahtumat.add("Tilille siirrettiin " + summa + "€ tililtä " + tili.getTilinro());
        }
    }

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

}
