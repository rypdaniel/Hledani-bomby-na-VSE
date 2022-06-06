package logika;

/**
 * Class PrikazSebrat - dedi ze tridy Prikaz
 *
 * @author Daniel Rypl
 * @version 2021/22
 */

public class PrikazSebrat extends Prikaz{
    public PrikazSebrat(HerniPlan plan) {
        super("seber", plan);
    }
    /**
     * sebere predmet a vlozi ho do inventare
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu
     */
    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0) {
            // pokud chybí druhé slovo, tak ....
            return "Co mam sebrat?";
        } else if (parametry.length == 1 && this.getHerniPlan().getAktualniProstor().obsahujePredmet(parametry[0])) {
            // pokud je druhe slovo takové, které lze vložit do kabelky
            Predmet predmet = this.getHerniPlan().getAktualniProstor().vratPredmet(parametry[0]);
            if (predmet.getLzeVzit()) {
                this.getHerniPlan().getInventar().vlozPredmet(this.getHerniPlan().getAktualniProstor().odeberPredmet(parametry[0]));
                return "Vložil jsi: " + predmet.getZobrazeni() + " do batohu.";
            } else {
                return "To nechci";
            }
        }
        return "To zde není.";
    }
}
