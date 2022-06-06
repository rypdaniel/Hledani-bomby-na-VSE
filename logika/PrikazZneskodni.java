package logika;

/**
 * Class PrikazZneskodni - dědí z třídy příkaz
 *
 * @author Daniel Rypl
 * @version 2021/22
 */

public class PrikazZneskodni extends Prikaz{
    public PrikazZneskodni(HerniPlan plan){
        super("Zneskodni", plan);
    }
    /**
     * pokusi se zneškodnit predmet
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return vrátí jestli lze daný předmět zneškodnit
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Na co mám použít příkaz zneškodni";
        }
        else if (parametry.length == 1 && this.getHerniPlan().getAktualniProstor().obsahujePredmet("Bomba")&& this.getHerniPlan().getInventar().obsahujePredmet("Kleště")) {
            return "Bomba je zneškodněna";

        }
        else if(parametry.length == 1 && this.getHerniPlan().getAktualniProstor().obsahujePredmet("Bomba")){
            return "Potřebujete Kleště";
        }
        return "Daný předmět nejde zneškodnit";
    }
}
