package logika;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPrikazy{
    private Hra hra;

    @Before
    public void setUp() {
        hra = new Hra();
    }

    //10.Test Vypsání nápovědy
    @Test
    public void testVypsaniNapovedy() {
        assertEquals("""
                    Tvým úkolem je nálezt a následně zneškodnit bombu.

                    Můžeš zadat tyto příkazy:
                    predat mluv koupit Zneskodni nápověda inventar jdi seber konec\s""", hra.zpracujPrikaz("nápověda")   );
    }

    //11.Test příkazu seber
    @Test
    public void testSeber(){
        Predmet predmet = new Predmet("predmet","predmet",true, Predmet.Status.NelzeZneskodnit);
        Prostor prostor = new Prostor("prostor", "prostor");
        hra.getHerniPlan().setAktualniProstor(prostor);
        hra.getHerniPlan().getAktualniProstor().vlozPredmet(predmet);
        hra.zpracujPrikaz("seber predmet");
    }

    //12.Test příkazu jdi
    @Test
    public void testJdi() {
        assertEquals("""
                    Jsi v mistnosti/prostoru Dlouhá chodba, kde se náchází spousta místností.
                    východy: průchod vstup
                    předměty k sebrání: Mapa
                    postavy: zde nejsou žádné postavy""", hra.zpracujPrikaz("jdi chodba"));
    }

    //13.Test příkazu konec
    @Test
    public void testKonec(){
        assertEquals("hra ukončena příkazem konec", hra.zpracujPrikaz("konec"));
    }

    //14.Test příkazu mluv
    @Test
    public void testMluv(){
        hra.getHerniPlan().getAktualniProstor().vlozPostavu(new Postava("Kuchařka","Kuchařka",null,null,"Dobry den, můžu vám nabídnou polévku za 50 Kč, nebo vodu za 5Kč","Dobry den, můžu vám nabídnou polévku za 50 Kč, nebo vodu za 5Kč","Tohle neberu","Děkuji, tady máte svoje peníze"));
        assertEquals("Kuchařka: Dobry den, můžu vám nabídnou polévku za 50 Kč, nebo vodu za 5Kč",hra.zpracujPrikaz("mluv Kuchařka"));
    }
    //15.Test příkazu inventar
    @Test
    public void testInvnetar(){
        assertEquals("""
                Obsah batohu:\s
                nic nevlastníš
                V peněžence máš: 55 Kč""",hra.zpracujPrikaz("inventar"));
    }

    //19.Test příkazu predat
    @Test
    public void testPredat(){
        hra.zpracujPrikaz("mluv Vrátný");
        hra.zpracujPrikaz("jdi chodba");
        hra.zpracujPrikaz("jdi průchod");
        hra.zpracujPrikaz("jdi kumbál");
        hra.zpracujPrikaz("seber Pivo");
        hra.zpracujPrikaz("jdi průchod");
        hra.zpracujPrikaz("jdi chodba");
        hra.zpracujPrikaz("jdi vstup");
        assertEquals("Vrátný: Díky, snad ti to pomůže.",hra.zpracujPrikaz("predat Pivo Vrátný"));
    }

    //20.Test příkazu koupit
    @Test
    public void testKoupit(){
        hra.zpracujPrikaz("jdi chodba");
        hra.zpracujPrikaz("jdi průchod");
        hra.zpracujPrikaz("jdi menza");
        hra.zpracujPrikaz("mluv Kuchařka");
        assertEquals("Koupil jsi Voda.", hra.zpracujPrikaz("koupit Voda"));
    }
}


