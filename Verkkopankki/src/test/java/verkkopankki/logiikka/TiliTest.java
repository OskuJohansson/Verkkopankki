import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import verkkopankki.logiikka.Tili;

public class TiliTest {

    Tili tili1;
    Tili tili2;

    public TiliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tili1 = new Tili("01");
        tili2 = new Tili("02");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void SaldonLisaysToimii() {
        tili1.muutaSaldoa(10);

        assertEquals(10, tili1.getSaldo());
    }

    @Test
    public void SaldonVahennysToimii() {
        tili1.muutaSaldoa(10);
        tili1.muutaSaldoa(-10);

        assertEquals(0, tili1.getSaldo());
    }

    @Test
    public void SaldoEiVaheneNegatiiviseksi() {
        tili1.muutaSaldoa(-1);

        assertEquals(0, tili1.getSaldo());
    }

    @Test
    public void lisaaPositiivinenTilitapahtumaToimii() {
        tili1.lisaaTilitapahtuma(tili2, 10);
        assertEquals(tili1.getTilitapahtumat().get(0), "Tilille siirrettiin 10€ tililtä 02");
    }

    @Test
    public void lisaaNegatiivinenTilitapahtumaToimii() {
        tili2.muutaSaldoa(10);
        tili2.lisaaTilitapahtuma(tili1, -10);
        assertEquals(tili2.getTilitapahtumat().get(0), "Tililtä siirrettiin 10€ tilille 01");
    }
    
    @Test
    public void lisaaPositiivinenTilitapahtumaToimii2() {
        tili1.lisaaTilitapahtuma(10);
        assertEquals(tili1.getTilitapahtumat().get(0), "Tilille lisättiin 10€");
    }
    
    @Test
    public void lisaaNegatiivinenTilitapahtumaToimii2() {
        tili1.muutaSaldoa(10);
        tili1.lisaaTilitapahtuma(-10);
        assertEquals(tili1.getTilitapahtumat().get(0), "Tililtä nostettiin 10€");
    }
}
