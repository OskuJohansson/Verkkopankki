/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import verkkopankki.logiikka.Tili;

/**
 *
 * @author Oskari
 */
public class TiliTest {
    
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
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
     }
     
     @Test
     public void muutaSaldoaToimii() {
         Tili tili = new Tili("01");
         tili.muutaSaldoa(10);
         
         assertEquals(10, tili.getSaldo());
      }
     
     @Test
     public void lisaaTilitapahtumaToimii() {
          Tili t1 = new Tili("01");
          Tili t2 = new Tili("02");
          t2.muutaSaldoa(20);
          t1.lisaaTilitapahtuma(t2, 10);
          assertEquals(t1.getTilitapahtumat().get(0), "Tilille siirrettiin 10€ tililtä 02");
     }
}
