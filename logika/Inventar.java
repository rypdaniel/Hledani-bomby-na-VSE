package logika;


import java.util.HashMap;
import java.util.Map;

/**
 * Class Inventar - inventar, kde se uchovavaji sebrane predmety
 * muzememe si ho kdykoliv zobrazit prikazem inventar
 */
public class Inventar {
    private Map<String, Predmet> predmety = new HashMap<>();
    private int penize = 55;
    private int pocetVeci;


    /**
     * Konstruktor pro třídu inventář.
     * Nastavuje proměnnou pocetVeci, ta nastavuje počet věcí v inventáři.
     */
    public Inventar(){
        this.predmety = new HashMap<String, Predmet>();
        pocetVeci = 0;
    }

    /**
     * zkontroluje, jestli inventar neni plny a vlozi vec do inventare
     * @param  predmet kterou vkladame do inventare
     * @return vraci vec, ktera byla vlozena, null pokud vlozena nebyla
     */
    public Predmet vlozPredmet(Predmet predmet) {
        if(!jePlny()) {
            predmety.put(predmet.getNazev(), predmet); //vloží klíč a hodnotu do mapy
            if (predmety.containsKey(predmet.getNazev())) return predmet;
        }
        return null;
    }

    /**
     * zobrazi obsah inventare
     * @return obsah batohu
     */
    public String zobrazitObsah() {

        String vracenyText = "Obsah batohu: \n";
        if(predmety.size()>0) {
            for (Map.Entry<String, Predmet> vec : predmety.entrySet()) {
                vracenyText += vec.getKey() + ", ";
            }
            vracenyText = vracenyText.substring(0, vracenyText.length()-2);
        }
        else {
            vracenyText += "nic nevlastníš";
        }

        return vracenyText + "\n" + "V peněžence máš: " + this.penize + " Kč";
    }

    /**
     * vraci mnozstvi penez v inventare
     * @return mnozstvi penez v peněžence
     */
    public int getPenize() {
        return this.penize;
    }


    /**
     * odecte penize z inventare
     * @param castka castka, kterou chceme odecist
     * @return vrati true, pokud byla castka odectena, false, pokud neni dostatek penez
     */
    public Boolean odecistPenize(int castka) {
        if(castka<=this.penize) {
            this.penize -= castka;
            return true;
        }
        return false;
    }

    /**
     * pricte penize do inventare
     * @param castka castka, kterou chceme pricist
     */
    public void pricistPenize(int castka) {
        this.penize += castka;
    }

    /**
     * zjisti, jestli se v inventari nachazi daný předmět
     * @param nazev nazev predmetu, který chceme zjistit
     * @return vrati true, pokud predmet v inventari je, false pokud neni
     */
    public Boolean obsahujePredmet(String nazev) {
        return predmety.containsKey(nazev);
    }

    /**
     * vrati předmět z inventare
     * @param nazev nazev předmětu, který chceme vratit
     * @return vracený poředmět
     */
    public Predmet vratPredmet(String nazev) {
        return predmety.get(nazev);
    }

    /**
     * odebere předmět z inventare
     * @param nazev nazev předmětu, kterou chceme odebrat
     * @return vrati předmět, který jsme odebrali
     */
    public Predmet odeberPredmet(String nazev) {
        Predmet predmet = predmety.get(nazev);
        predmety.remove(nazev);
        return predmet;
    }

    /**
     * zjisti, jestli je inventar plny
     * @return vraci true, pokud plny je a false pokud neni
     */
    public Boolean jePlny() {
        if(predmety.size()>6) {
            return true;
        }
        return false;
    }
}

