
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

    }

    @After
    public void tearDown() {
    }

    // @Test
    // public void hello() {}
    @Test
    public void lisaaAsiakasToimii() {
        j.lisaaAsiakas(osku);
        assertEquals(j.getAsiakkaat().get(0), osku);
    }

    @Test
    public void luoTiliToimii() {
        j.lisaaAsiakas(osku);
        j.luoTili(osku);
        assertEquals(j.haeAsiakas("oskajoha").getTilit().size(), 1);
    }
}
