package logika;

import java.util.Objects;

/**
 * Class PrikazKoupit - dedi z tridy Prikaz
 * Dovoluje hráči zakoupit předměty, které nelze sebrat
 * @author Daniel Rypl
 * @version 2021/22
 */

public class PrikazKoupit extends Prikaz{
    public PrikazKoupit(HerniPlan plan){
        super("koupit", plan);
    }
    @Override
    public String provedPrikaz(String... parametry) {
        if(Objects.equals(this.getHerniPlan().getAktualniProstor().getNazev(), "menza")) {
            //muzu koupit
            if (parametry.length == 0) {
                // pokud chybí druhé slovo, tak ....
                return "Co mam jako koupit? Musis mi to rict!";
            }
            else if(parametry.length == 1 && this.getHerniPlan().getAktualniProstor().obsahujePredmet(parametry[0])) {
                Predmet vec = this.getHerniPlan().getAktualniProstor().vratPredmet(parametry[0]);
                if(this.getHerniPlan().getInventar().odecistPenize(vec.getCena())){
                    this.getHerniPlan().getInventar().vlozPredmet(this.getHerniPlan().getAktualniProstor().odeberPredmet(parametry[0]));
                    return "Koupil jsi "+ parametry[0] + ".";
                }
                return "Nemáš dostatek peněz";
            }
            else {
                return "Tohle tu nemáme";
            }
        }
        else {
            return "Zde nic koupit nelze, musíš navštívit menzu";
        }
    }
}
