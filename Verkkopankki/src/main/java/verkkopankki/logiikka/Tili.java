package verkkopankki.logiikka;

public class Tili {

    private final String tilinro;
    private int saldo;

    public Tili(String tilinro) {
        saldo = 0;
        this.tilinro = tilinro;
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
}
