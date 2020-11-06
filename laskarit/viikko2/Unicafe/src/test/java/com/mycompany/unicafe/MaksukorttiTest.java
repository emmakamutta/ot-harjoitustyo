package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertTrue(kortti.saldo() == 10);
    }
    
    @Test 
    public void lataaminenKasvattaaSaldoa() {
        kortti.lataaRahaa(90);
        assertTrue(kortti.saldo()==100);
    }
    
    @Test
    public void saldoVaheneeKunRahaaTarpeeksi() {
        kortti.otaRahaa(5);
        assertTrue(kortti.saldo()==5);
    }
    
    @Test
    public void saldoEiMuutuKunRahaaEiTarpeeksi() {
        kortti.otaRahaa(100);
        assertTrue(kortti.saldo()==10);
    }
    
    @Test
    public void kunRahaaTarpeeksiPalauttaaTrue() {
        assertTrue(kortti.otaRahaa(1));
    }
    
    @Test
    public void kunRahaaEiTarpeeksiPalauttaaFalse() {
        assertTrue(!kortti.otaRahaa(100));
    }
    
    @Test
    public void tulostaaIsotOikein() {
        kortti.lataaRahaa(999989);
        assertEquals("saldo: 9999.99",kortti.toString() );
    }
    
    @Test 
    public void tulostaaPienetOikein() {
        kortti.otaRahaa(9);
        assertEquals("saldo: 0.01",kortti.toString() );
    }
}
