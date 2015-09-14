
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import verkkopankki.logiikka.Asiakas;
import verkkopankki.logiikka.Jarjestelma;
import verkkopankki.logiikka.Tili;

public class JarjestelmaTest {

    Jarjestelma j;
    Asiakas osku;
    Asiakas feikkiosku;
    Asiakas jope;

    public JarjestelmaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        j = new Jarjestelma();
        osku = new Asiakas("Oskari", "Johansson", "oskajoha", "Banaan1");
        feikkiosku = new Asiakas("Oskari", "Johansson", "Oskajoha", "Appelsiin1");
        jope = new Asiakas("Jope", "Ruonansuu", "jope1", "salasana");
        j.lisaaAsiakas(osku);
        j.luoTili(osku);
        j.lisaaAsiakas(jope);
        j.luoTili(jope);
        j.kateistoimitus(jope.getTilit().get(0), 500);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void lisaaAsiakasToimii() {
        assertEquals(osku, j.getAsiakkaat().get(0));
    }

    @Test
    public void lisaaAsiakasEiHyvaksySamaaKayttajatunnusta() {
        j.lisaaAsiakas(feikkiosku);
        assertEquals(2, j.getAsiakkaat().size());
    }

    @Test
    public void luoTiliToimii() {
        assertEquals(1, j.haeAsiakas("oskajoha").getTilit().size());
    }

    @Test
    public void luoTiliEiLuoTiliaRekisteroitymattomalleAsiakkaalle() {
        j.luoTili(feikkiosku);
        assertEquals(2, j.getTilit().size());
    }

    @Test
    public void haeAsiakasToimii() {
        assertEquals(osku, j.haeAsiakas(osku.getKäyttajatunnus()));
    }

    @Test
    public void haeAsiakasPalauttaaNullVaarillaSyotteilla() {
        assertEquals(null, j.haeAsiakas("mattimeikalainen"));
    }

    @Test
    public void kateistoimitusToimii() {
        assertEquals(500, jope.getTilit().get(0).getSaldo());
    }

    @Test
    public void kateistoimitusEiHyvaksySaldoaSuurempiaNostoja() {
        j.kateistoimitus(jope.getTilit().get(0), -501);
        assertEquals(500, jope.getTilit().get(0).getSaldo());
    }

    @Test
    public void kateistoimitusEiHyvaksyNollanEuronSiirtoja() {
        j.kateistoimitus(jope.getTilit().get(0), 0);
        assertEquals(1, jope.getTilit().get(0).getTilitapahtumat().size());
    }

    @Test
    public void tilisiirtoToimii() {
        j.tilisiirto(jope.getTilit().get(0), osku.getTilit().get(0), 200);
        assertEquals(200, osku.getTilit().get(0).getSaldo());
        assertEquals(300, jope.getTilit().get(0).getSaldo());
    }

    @Test
    public void tilisiirtoEiHyvaksyLahteenSaldoaSuurempiaSiirtoja() {
        j.tilisiirto(jope.getTilit().get(0), osku.getTilit().get(0), 600);
        assertEquals(0, osku.getTilit().get(0).getSaldo());
        assertEquals(500, jope.getTilit().get(0).getSaldo());
    }

    @Test
    public void tilisiirtoEiHyvaksyNollanEuronSiirtoja() {
        j.tilisiirto(jope.getTilit().get(0), osku.getTilit().get(0), 0);
        assertEquals(1, jope.getTilit().get(0).getTilitapahtumat().size());
        assertEquals(0, osku.getTilit().get(0).getTilitapahtumat().size());

    }

    @Test
    public void tilisiirtoEiHyvaksyNegatiivisiaSiirtoja() {
        j.tilisiirto(jope.getTilit().get(0), osku.getTilit().get(0), -100);
        assertEquals(0, osku.getTilit().get(0).getSaldo());
        assertEquals(500, jope.getTilit().get(0).getSaldo());

    }

    @Test
    public void tilinumerogeneraattoriToimii() {
        assertEquals("00000001", osku.getTilit().get(0).getTilinro());
        assertEquals("00000002", jope.getTilit().get(0).getTilinro());

    }
}
