
import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassapaateTest {
    Kassapaate paate;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(500);
    }
    
    @Test
    public void konstruktoriToimii() {
        assertTrue(paate.kassassaRahaa()==100000 && paate.edullisiaLounaitaMyyty()==0
        && paate.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void edulinenLounasRiittavallaKateisellaRahamaaraKasvaa() {
        paate.syoEdullisesti(300);
        assertTrue(paate.kassassaRahaa() == 100240);
    }
    
    @Test
    public void edulinenLounasRiittavallaKateisellaOikeaVaihtoraha() {
        assertTrue(paate.syoEdullisesti(300) == 60);
    }
    
    @Test
    public void edulinenLounasRiittavallaKateisellaLounaatKasvaa() {
        paate.syoEdullisesti(300);
        assertTrue(paate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void maukasLounasRiittavallaKateisellaRahamaaraKasvaa() {
        paate.syoMaukkaasti(500);
        assertTrue(paate.kassassaRahaa() == 100400);
    }
    
    @Test
    public void maukasLounasRiittavallaKateisellaOikeaVaihtoraha() {
        assertTrue(paate.syoMaukkaasti(500) == 100);
    }
    
    @Test
    public void maukasLounasRiittavallaKateisellaLounaatKasvaa() {
        paate.syoMaukkaasti(500);
        assertTrue(paate.maukkaitaLounaitaMyyty() == 1);
    }
    
    @Test
    public void edullinenLounasRahatEiRiitaKassaEiMuutu() {
        paate.syoEdullisesti(200);
        assertTrue(paate.kassassaRahaa() == 100000);
    }

    @Test
    public void maukasLounasRahatEiRiitaKassaEiMuutu() {
        paate.syoMaukkaasti(200);
        assertTrue(paate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void edullinenLounasRahatEiRiitaOikeaVaihtoraha() {
        assertTrue(paate.syoEdullisesti(200) == 200);
    }
    
    @Test
    public void maukasLounasRahatEiRiitaOikeaVaihtoraha() {
        assertTrue(paate.syoMaukkaasti(200) == 200);
    }
    
    @Test
    public void edullinenLounasRahatEiRiitaLounaatEiMuutu() {
        paate.syoEdullisesti(200);
        assertTrue(paate.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void maukasLounasRahatEiRiitaLounaatEiMuutu() {
        paate.syoMaukkaasti(200);
        assertTrue(paate.maukkaitaLounaitaMyyty() == 0);
    }
    
    @Test
    public void edullinenLounasKortillaRahatRiittaaOstoOnnistui() {
      assertTrue(paate.syoEdullisesti(kortti));
    }
    
    @Test
    public void edullinenLounasKortillaRahatRiittaaVelottaaOikein() {
        paate.syoEdullisesti(kortti);
        assertTrue(kortti.saldo() == 260);
    }
    
    @Test
    public void edullinenLounasKortillaRahatRiittaaLounaatKasvaa() {
        paate.syoEdullisesti(kortti);
        assertTrue(paate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void maukasLounasKortillaRahatRiittaaOstoOnnistui() {
      assertTrue(paate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void maukasLounasKortillaRahatRiittaaVelottaaOikein() {
        paate.syoMaukkaasti(kortti);
        assertTrue(kortti.saldo() == 100);
    }
    
    @Test
    public void maukasLounasKortillaRahatRiittaaLounaatKasvaa() {
        paate.syoMaukkaasti(kortti);
        assertTrue(paate.maukkaitaLounaitaMyyty() == 1);
    }
    
    @Test
    public void edullinenLounasKortillaRahatEiRiitaEiVeloita() {
        paate.syoMaukkaasti(kortti);
        paate.syoEdullisesti(kortti);
        assertTrue(kortti.saldo() == 100);
    }
    
    @Test
    public void maukasLounasKortillaRahatEiRiitaEiVeloita() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertTrue(kortti.saldo() == 100);
    }
    
    @Test
    public void edullinenLounasKortillaRahatEiRiitaLounaatEiMuutu() {
        paate.syoMaukkaasti(kortti);
        paate.syoEdullisesti(kortti);
        assertTrue(paate.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void maukasLounasKortillaRahatEiRiitaLounaatEiMuutu() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertTrue(paate.maukkaitaLounaitaMyyty() == 1);
    }
    
    @Test
    public void edullinenLounasKortillaRahatEiRiitaPalauttaaFalse() {
        paate.syoMaukkaasti(kortti);
        assertTrue(!paate.syoEdullisesti(kortti));
    }
    
    @Test
    public void maukasLounasKortillaRahatEiRiitaPalauttaaFalse() {
        paate.syoMaukkaasti(kortti);
        assertTrue(!paate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void edullinenLounasKortillaRahatRiittaaKassaEiKasva() {
        paate.syoEdullisesti(kortti);
        assertTrue(paate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void edullinenLounasKortillaRahatEiRiittaKassaEiKasva() {
        kortti.otaRahaa(500);
        paate.syoEdullisesti(kortti);
        assertTrue(paate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void maukasLounasKortillaRahatRiittaaKassaEiKasva() {
        paate.syoMaukkaasti(kortti);
        assertTrue(paate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void maukasLounasKortillaRahatEiRiittaKassaEiKasva() {
        kortti.otaRahaa(500);
        paate.syoMaukkaasti(kortti);
        assertTrue(paate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void lataaRahaaKortilleSaldoMuuttuu() {
        paate.lataaRahaaKortille(kortti, 500);
        assertTrue(kortti.saldo() == 1000);
    }
    
    @Test
    public void lataaRahaaKortilleKassaKasvaa() {
        paate.lataaRahaaKortille(kortti, 500);
        assertTrue(paate.kassassaRahaa() == 100500);
    }
    
    @Test
    public void negatiivinenLatausEiOnnistu() {
        paate.lataaRahaaKortille(kortti, -500);
        assertTrue(kortti.saldo() == 500 && paate.kassassaRahaa() == 100000);
    }
}

