package verkkopankki.logiikka;

import java.util.ArrayList;

/**
 * Luokka pitää sisällään kaikki asiakkaan henkilökohaiset tiedot ja osaa
 * muuttaa niitä.
 *
 * @author Oskari
 */
public class Asiakas {

    private final String etunimi;
    private final String sukunimi;
    private final String käyttajatunnus;
    private String salasana;
    private String email;
    private String puhnro;
    private final ArrayList<Tili> tilit;

    public Asiakas(String etunimi, String sukunimi, String käyttajatunnus, String salasana) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.käyttajatunnus = käyttajatunnus;
        this.salasana = salasana;
        this.tilit = new ArrayList<>();
    }

    public String getEtunimi() {
        return etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void lisaaTili(Tili tili) {
        tilit.add(tili);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPuhnro() {
        return puhnro;
    }

    public void setPuhnro(String puhnro) {
        this.puhnro = puhnro;
    }

    public ArrayList<Tili> getTilit() {
        return tilit;
    }

    /**
     * Metodi vaihtaa salasanan, jos käyttäjällä on tiedossa vanha salasana
     *
     * @param vanhaSalasana Asiakkaan vanha salasana
     * @param uusiSalasana Asiakkaan uusi salasana
     */
    public void setSalasana(String vanhaSalasana, String uusiSalasana) {
        if (salasana.equals(vanhaSalasana)) {
            this.salasana = uusiSalasana;
        }
    }

    public String getKäyttajatunnus() {
        return käyttajatunnus;

    }

    /**
     * Metodi testaa onko annettu ehdotus asiakkaan salasana. Näin ei tarvitse
     * käyttää epäilyttävää getSalasana() -metodia.
     *
     * @param ehdotus salasanaehdotus
     * @return onko ehdotus tilin salasana vai ei
     */
    public boolean tasmaakoSalasana(String ehdotus) {
        return ehdotus.equals(salasana);
    }
}
