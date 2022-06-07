package logika;


/**
 * Class Prikaz - zaklad pro ostatni prikazy
 *
 * @author Daniel Rypl
 *    @version pro školní rok 2021/22
 */
public class Prikaz implements IPrikaz {
    private final String NAME;
    private final HerniPlan plan;

    public Prikaz(String name, HerniPlan plan){
        this.NAME = name;
        this.plan = plan;

    }
    /**
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return provede příkaz
     */
    @Override
    public String provedPrikaz(String... parametry) {
        return null;
    }

    /**
     * vrati nazev prikazu
     * @return text nazvu prikazu
     */
    @Override
    public String getNazev() {
        return this.NAME;
    }

    /**
     * vrati herni plan
     * @return herni plan;
     */

    public HerniPlan getHerniPlan(){
        return this.plan;
    }
}

