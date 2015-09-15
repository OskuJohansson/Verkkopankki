package verkkopankki.logiikka;

import java.util.ArrayList;

public class Asiakas {

    private final String etunimi;
    private final String sukunimi;
    private final String käyttajatunnus;
    private String salasana;
    private String email;
    private String puhnro;
    private final ArrayList<Tili> tilit;
    private Kortti kortti;

    public Asiakas(String etunimi, String sukunimi, String käyttajatunnus, String salasana) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.käyttajatunnus = käyttajatunnus;
        this.salasana = salasana;
        this.tilit = new ArrayList<>();
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

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public String getKäyttajatunnus() {
        return käyttajatunnus;
    }

    public Kortti getKortti() {
        return kortti;
    }

    public void setKortti(Kortti kortti) {
        this.kortti = kortti;
    }

}
