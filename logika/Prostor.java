package logika;

import java.util.*;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */
public class Prostor {
    private final String nazev;
    private final String popis;
    private final Set<Prostor> vychody;   // obsahuje sousední místnosti
    private final Map<String, Predmet> predmety = new HashMap<>();
    private final Map<String, Postava> postavy = new HashMap<>();

    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<>();
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
      @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor druhy)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor

          //metoda equals třídy java.util.Objects porovná hodnoty obou názvů.
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

       return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Jsi v mistnosti/prostoru " + popis + ".\n"
                + popisVychodu()+ "\n"
                + popisVeci() + "\n"
                + popisPostavy();
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    private String popisVychodu() {
        StringBuilder vracenyText = new StringBuilder("východy:");
        for (Prostor sousedni : vychody) {
            vracenyText.append(" ").append(sousedni.getNazev());
        }
        return vracenyText.toString();
    }
    /**
     * vrati popis veci v prostoru
     * @return text popisu veci
     */
    private StringBuilder popisVeci() {
        StringBuilder vracenyText = new StringBuilder("předměty k sebrání: ");
        if(predmety.size()>0) {
            for (Map.Entry<String, Predmet> vec : predmety.entrySet()) {
                vracenyText.append(vec.getValue().getZobrazeni()).append(", ");
            }
            return new StringBuilder(vracenyText.substring(0, vracenyText.length() - 2));
        }
        else {
            return vracenyText.append("zde není nic k sebrání");
        }
    }

    /**
     * vrati popis postav v prostoru
     * @return popis postav
     */
    private String popisPostavy() {
        StringBuilder vracenyText = new StringBuilder("postavy: ");
        if(postavy.size()>0) {
            for (Map.Entry<String, Postava> postava : postavy.entrySet()) {
                vracenyText.append(postava.getValue().getZobrazJmeno().substring(0, 1).toUpperCase()).append(postava.getValue().getZobrazJmeno().substring(1)).append(", ");
            }
            return vracenyText.substring(0, vracenyText.length()-2);
        }
        else {
            return String.valueOf(vracenyText.append("zde nejsou žádné postavy"));
        }
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory =
                vychody.stream()
                        .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda)).toList();
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /*
      Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
      Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
      odebírat východy) protože z hlediska správného návrhu je to plně
      záležitostí třídy Prostor.

      @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */

    /**
     * zjisti, jestli se v prostoru nachazi daný předmět
     * @param nazev předmět, který chceme najit
     * @return true pokud se nachazi, false pokud se nenachayi
     */
    public boolean obsahujePredmet(String nazev) {
        return predmety.containsKey(nazev);
    }

    /**
     * vrati předmět z prostoru
     * @param nazev nazev předmětu, který chceme vratit
     * @return vracený předmět
     */
    public Predmet vratPredmet(String nazev) {
        return predmety.get(nazev);
    }

    /**
     * odebere předmět z prostoru
     * @param nazev nazev předmětu, který chceme odebrat
     * @return odebraný předmět
     */
    public Predmet odeberPredmet(String nazev) {
        return predmety.remove(nazev);
    }


    /**
     * zjisti, jestli se v prostoru nachazi dana postava
     * @param nazev jmeno postavy, kterou chceme nalezt
     * @return text jmeno postavy
     */
    public boolean obsahujePostavu(String nazev) {
        return postavy.containsKey(nazev);
    }

    /**
     * vrati postavu z prostoru
     * @param nazev jmeno postavy, kterou chceme vratit
     * @return vracena postava
     */
    public Postava vratPostavu(String  nazev) {
        return postavy.get(nazev);
    }

    /**
     * vlozi vec do prostoru
     *
     * @param predmet nazev predmetu, který chceme do prostoru vlozit
     */
    public void vlozPredmet(Predmet predmet) {
        predmety.put(predmet.getNazev(), predmet);
    }

    /**
     * vlozi postavu do prostoru
     *
     * @param postava jmeno postavy, kterou chceme vlozit
     */
    public void vlozPostavu(Postava postava) {
        postavy.put(postava.getJmeno(), postava);
    }
}