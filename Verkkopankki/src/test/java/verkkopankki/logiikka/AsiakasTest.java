package verkkopankki.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AsiakasTest {
    
    Tili tili;
    Asiakas asiakas;
    
    public AsiakasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tili = new Tili("01");
        asiakas = new Asiakas("Oskari", "Johansson", "oskajoha", "Banaan1");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lisaaTiliToimii() {
        asiakas.lisaaTili(tili);
        assertEquals(asiakas.getTilit().size(), 1);
    }
    
    @Test
    public void lisaaTiliToimii2() {
        asiakas.lisaaTili(tili);
        assertEquals(asiakas.getTilit().get(0), tili);
    }
}
