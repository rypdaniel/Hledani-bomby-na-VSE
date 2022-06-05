package logika;


import java.util.HashMap;
import java.util.Map;

/**
 * Class Inventar - inventar, kde se uchovavani sebrane predmety
 * muzememe si ho kdykoliv zobrazit prikazem inventar
 */
public class Inventar {
    private Map<String, Predmet> predmety = new HashMap<>();
    private int penize = 4;

    /**
     * zkontroluje, jestli inventar neni plny a vlozi vec do inventare
     * @param vec vec kterou vkladame do inventare
     * @return vraci vec, ktera byla vlozena, null pokud vlozena nebyla
     */
    public Predmet vlozVec(Predmet vec) {
        if(!jePlny()) {
            predmety.put(vec.getNazev(), vec); //vloží klíč a hodnotu do mapy
            if (predmety.containsKey(vec.getNazev())) return vec;
        }
        return null;
    }

    /**
     * zobrazi obsah inventare
     * @return obsah inventare
     */
    public String zobrazitObsah() {

        String vracenyText = "Obsah inventáře: \n";
        if(predmety.size()>0) {
            for (Map.Entry<String, Predmet> vec : predmety.entrySet()) {
                vracenyText += vec.getKey() + ", ";
            }
            vracenyText = vracenyText.substring(0, vracenyText.length()-2);
        }
        else {
            vracenyText += "nic";
        }

        return vracenyText + "\n" + "V peněžence máš: " + this.penize + " Kč";
    }

    /**
     * vraci mnozstvi penez v inventare
     * @return mnozstvi penez
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
     * zjisti, jestli se v inventari nachazi dana vec
     * @param nazev nazev veci, kterou chceme zjistit
     * @return vrati true, pokud vec v inventari je, false pokud neni
     */
    public Boolean obsahujeVec(String nazev) {
        return predmety.containsKey(nazev);
    }

    /**
     * vrati vec z inventare
     * @param nazev nazev veci, kterou chceme vratit
     * @return vracena vec
     */
    public Predmet vratVec(String nazev) {
        return predmety.get(nazev);
    }

    /**
     * odebere vec z inventare
     * @param nazev nazev veci, kterou chceme odebrat
     * @return vrati vec, kterou jsme odebrali
     */
    public Predmet odeberVec(String nazev) {
        Predmet vec = predmety.get(nazev);
        predmety.remove(nazev);
        return vec;
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

