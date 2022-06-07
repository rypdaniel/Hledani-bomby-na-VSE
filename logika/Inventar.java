package logika;


import java.util.HashMap;
import java.util.Map;

/**
 * Class Inventar - inventar, kde se uchovavaji sebrane predmety
 * muzememe si ho kdykoliv zobrazit prikazem inventar
 */
public class Inventar {
    private final Map<String, Predmet> predmety = new HashMap<>();
    private int penize = 55;


    /**
     * zkontroluje, jestli inventar neni plny a vlozi vec do inventare
     * @param  predmet kterou vkladame do inventare
     * @return vlozi vec do inventare
     */
    public Object vlozPredmet(Predmet predmet) {
        if(!jePlny()) {
            predmety.put(predmet.getNazev(), predmet); //vloží klíč a hodnotu do mapy
        }
        return null;
    }

    /**
     * zobrazi obsah inventare
     * @return obsah batohu
     */
    public String zobrazitObsah() {

        StringBuilder vracenyText = new StringBuilder("Obsah batohu: \n");
        if(predmety.size()>0) {
            for (Map.Entry<String, Predmet> vec : predmety.entrySet()) {
                vracenyText.append(vec.getKey()).append(", ");
            }
            vracenyText = new StringBuilder(vracenyText.substring(0, vracenyText.length() - 2));
        }
        else {
            vracenyText.append("nic nevlastníš");
        }

        return vracenyText + "\n" + "V peněžence máš: " + this.penize + " Kč";
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
     * zjisti, jestli se v inventari nachazi daný předmět
     * @param nazev nazev predmetu, který chceme zjistit
     * @return vrati true, pokud predmet v inventari je, false pokud neni
     */
    public Boolean obsahujePredmet(String nazev) {
        return predmety.containsKey(nazev);
    }

    /**
     * odebere předmět z inventare
     * @param nazev nazev předmětu, kterou chceme odebrat
     */
    public void odeberPredmet(String nazev) {
        predmety.remove(nazev);
    }

    /**
     * zjisti, jestli je inventar plny
     * @return vraci true, pokud plny je a false pokud neni
     */
    public Boolean jePlny() {
        return predmety.size() > 5;
    }
}

