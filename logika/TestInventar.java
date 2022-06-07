package logika;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestInventar{
        private Inventar inventar;
        private Hra hra;

    @Before
        public void setUp() {
            inventar = new Inventar();
            inventar.vlozPredmet(new Predmet("test1","test1",true, Predmet.Status.NelzeZneskodnit));
            inventar.vlozPredmet(new Predmet("test2","test2",false, Predmet.Status.NelzeZneskodnit));
            inventar.vlozPredmet(new Predmet("test3","test3",true,Predmet.Status.LzeZneskodnit));
            inventar.odeberPredmet("test2");
            hra = new Hra();
    }

    //7.Test, zda byl předmět odstraněn
    @Test
    public void testObsahujePredmet2(){
        assertEquals(false, inventar.obsahujePredmet("test2"));
    }

        //8.Test na metodu odecistPenize
    @Test
    public void testOdecistPenize(){
            assertEquals(true, inventar.odecistPenize(55));
    }

    //9.Test metody ObsahujePredmet
    @Test
    public void testObsahujePredmet(){
        assertEquals(true,inventar.obsahujePredmet("test1"));
        assertEquals(false,inventar.obsahujePredmet("neobsahuje"));
    }

    //16.Test metoty lzeSebrat
    @Test
    public void testNelzeSebrat(){
        Predmet predmet20 = new Predmet("test2","test2",false, Predmet.Status.NelzeZneskodnit);
        assertFalse(predmet20.getLzeVzit());
    }

    //17.Test metoty lzeSebrat
    @Test
    public void testLzeSebrat(){
        Predmet predmet10 = new Predmet("test2","test2",true, Predmet.Status.NelzeZneskodnit);
        assertTrue(predmet10.getLzeVzit());
    }

    //18. Test jestli je inventář prázdný
    @Test
    public void testJePrazdny(){
        assertEquals("""
                Obsah batohu:\s
                nic nevlastníš
                V peněžence máš: 55 Kč""", hra.zpracujPrikaz("inventar"));
    }
}
