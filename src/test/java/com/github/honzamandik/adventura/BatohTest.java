/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.honzamandik.adventura;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.honzamandik.adventura.logika.Batoh;
import com.github.honzamandik.adventura.logika.Vec;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída {@code BatohTest} slouží ke komplexnímu otestování
 * třídy {@link BatohTest}.
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class BatohTest
{
    //== KONSTANTNÍ ATRIBUTY TŘÍDY =============================================
    //== PROMĚNNÉ ATRIBUTY TŘÍDY ===============================================
    //== STATICKÝ INICIALIZAČNÍ BLOK - STATICKÝ KONSTRUKTOR ====================
    //== KONSTANTNÍ ATRIBUTY INSTANCÍ ==========================================
    //== PROMĚNNÉ ATRIBUTY INSTANCÍ ============================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ TŘÍDY ====================================
    //== OSTATNÍ NESOUKROMÉ METODY TŘÍDY =======================================

    //##########################################################################
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------
    //== PŘÍPRAVA A ÚKLID PŘÍPRAVKU ============================================

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
        //defaultně prázdná metoda
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
     //defaultně prázdná metoda
    }

    /***************************************************************************
     * Text maximální nosnosti
     */
    @Test
    public void testMaximalniNosnost()
    {
        Batoh batoh2 = new Batoh();
        Vec vec1 = new Vec("vec1","1", true);
        Vec vec2 = new Vec("vec2", "1", true);
        Vec vec3 = new Vec("vec3", "1", true);
        Vec vec4 = batoh2.vlozVec(vec1);
        assertEquals(vec4, vec1);
        Vec vec5 = batoh2.vlozVec(vec2);
        assertEquals(vec5, vec2);
        assertNull(batoh2.vlozVec(vec3));

        

    }
    /**
     * Test přidávání věcí do baťohu
     */
    @Test
    public void testPridejVec()
    {
        Batoh batoh3 = new Batoh();
        Vec vec1 = new Vec("vec1", "f", true);
        assertEquals(vec1, batoh3.vlozVec(vec1));
        assertEquals(true, batoh3.obsahujeVec("vec1"));
    }
        /**
     * Test zahazování věcí z baťohu
     */
    @Test
    public void testZahodVec()
    {
        Batoh batoh4 = new Batoh();
        Vec vec1 = new Vec("vec1", "j", true);
        batoh4.vlozVec(vec1);
        assertEquals(vec1, batoh4.smazVec("vec1"));
        assertEquals("", batoh4.getObsahBatohu());
    }

}