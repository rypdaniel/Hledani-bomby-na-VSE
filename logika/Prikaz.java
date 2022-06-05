package logika;


/**
 * Class Prikaz - zaklad pro ostatni prikazy
 *
 * @author Daniel Rypl
 *    @version pro školní rok 2021/22
 */
public class Prikaz implements IPrikaz {
    private String Name;
    private HerniPlan plan;

    public Prikaz(String Name, HerniPlan plan){
        this.Name = Name;
        this.plan = plan;

    }
    /**
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return
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
        return null;
    }

    /**
     * vrati herni plan
     * @return herni plan;
     */

    public HerniPlan getHerniPlan(){
        return this.plan;
    }
}
