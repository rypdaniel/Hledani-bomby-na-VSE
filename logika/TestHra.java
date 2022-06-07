package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestHra {
    private Hra hra;

    @Before
    public void setUp() {
        hra = new Hra();
    }

    @After
    public void tearDown() {
    }


    @Test
    //1. Test úvodní zprávy pro hráče.
    public void zacatekHry() {
        assertEquals("Je začátek zkouškového roku 2025.\n" +
        "Jsi nenápadný student, který omylem zůstal ve škole i po spuštění varovného signálu.\n" +
                "Cílem hry je úspěšně naleznout bombu a tu následně zneškodnit. \n" +
                "To však nebude jednoduché, protože budeš muset nalézt kleště. \n" +
                "\n" +
                hra.getHerniPlan().getAktualniProstor().dlouhyPopis(),hra.vratUvitani());

    }
    @Test
    //2. Test závěrčné zprávy.
    public void vratEpilog() {
        assertEquals("KONEC HRY", hra.vratEpilog());
    }
    @Test
    //3. Test vadného příkazu.
    public void zpracujVadnyPrikaz(){
        assertEquals("Nevím co tím myslíš? Tento příkaz neznám.",hra.zpracujPrikaz("vadny prikaz"));
    }
    @Test
    //4. Test výhra
    public void testVyhra(){
        hra.zpracujPrikaz("mluv Vrátný");
        hra.zpracujPrikaz("jdi chodba");
        hra.zpracujPrikaz("jdi průchod");
        hra.zpracujPrikaz("jdi kumbál");
        hra.zpracujPrikaz("seber Pivo");
        hra.zpracujPrikaz("jdi průchod");
        hra.zpracujPrikaz("jdi chodba");
        hra.zpracujPrikaz("jdi vstup");
        hra.zpracujPrikaz("predat Pivo Vrátný");
        assertNotEquals(null, hra.konecHry());
    }
    @Test
    //5.Test, zda hra běží či ne
    public void testBezi(){
        assertFalse(hra.konecHry());
        hra.setKonecHry();
        assertTrue(hra.konecHry());
    }
    @Test
    //6.Test metody aktuailniProstor
    public void testAktualniProstor(){
        Prostor testovaciProstor = new Prostor("ucebna","ucebna");
        hra.getHerniPlan().setAktualniProstor(testovaciProstor);
        assertEquals(testovaciProstor, hra.getHerniPlan().getAktualniProstor());
    }
}

