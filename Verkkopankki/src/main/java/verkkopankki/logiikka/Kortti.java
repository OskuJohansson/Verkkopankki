
package verkkopankki.logiikka;

public class Kortti {


    private final String numero;
    private final Tili tili;
    
    public Kortti(Tili tili, String numero) {
        this.numero = numero;
        this.tili = tili;
    }

    public Tili getTili() {
        return tili;
    }

    public String getNumero() {
        return numero;
    }


    
}
