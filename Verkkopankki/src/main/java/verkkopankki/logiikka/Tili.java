package verkkopankki.logiikka;

import java.util.ArrayList;

public class Tili {

    private final String tilinro;
    private int saldo;
    private final ArrayList<Integer> tilitapahtumat;

    public Tili(String tilinro) {
        saldo = 0;
        this.tilinro = tilinro;
        tilitapahtumat = new ArrayList<>();
    }

    public void muutaSaldoa(int summa) {
        this.saldo += summa;
    }

    public String getTilinro() {
        return tilinro;
    }

    public int getSaldo() {
        return this.saldo;
    }
    
    public void lisaaTilitapahtuma(int summa) {
        tilitapahtumat.add(summa);
    }

    public ArrayList<Integer> getTilitapahtumat() {
        return tilitapahtumat;
    }
    
}
