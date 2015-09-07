package verkkopankki.logiikka;

public class Main {

    public static void main(String[] args) {

        Jarjestelma j = new Jarjestelma();
        j.luoAsiakas("Oskari", "Johansson", "oskajoha", "banaani");

        Asiakas osku = j.haeAsiakas("oskajoha");
        Tili oskuntili = osku.getTilit().get(0);
        j.tilisiirto(oskuntili, 1000);
        System.out.println("Tili kuuluu käyttäjälle " + osku.getKäyttajatunnus());
        System.out.println("Tilinumero on " + oskuntili.getTilinro());
        System.out.println(oskuntili);

    }

}
