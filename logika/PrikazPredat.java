package logika;

import java.util.Map;

/**
 * Class PrikazPredat - dědí z třídy Příkaz
 *
 * @author Daniel Rypl
 * @version 2021/22
 */

public class PrikazPredat extends Prikaz{

    public PrikazPredat(HerniPlan plan){
        super("predat", plan);
    }

    /**
     * provede vymenu predmetu
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     */
    public String provedPrikaz(String... parametry) {
        Inventar inventar = this.getHerniPlan().getInventar();
        Prostor aktualniProstor = this.getHerniPlan().getAktualniProstor();
        if (parametry.length == 0) {
            // pokud chybí první parametr (předmět)
            return "Co mám někomu předat? Musíš specifikovat předmět!";
        }
        //pokud chybí druhý parametr (osobu)
        else if (parametry.length == 1) {
            return "Komu to mám předat? Musíš specifikovat osobu!";
        } else if (parametry.length == 2 && inventar.obsahujePredmet(parametry[0])) {
            if (aktualniProstor.obsahujePostavu(parametry[1])) {
                Postava postava = aktualniProstor.vratPostavu(parametry[1]);
                Predmet predmetChce = postava.getCoChce();
                if (predmetChce != null && postava.getJizMluvil()) {
                    if (predmetChce.getNazev().equals(parametry[0])) {
                        Map<String, Predmet> tradePredmet = postava.vymenitPredmet(predmetChce);
                        if (tradePredmet.get("odeber") != null) {
                            inventar.odeberPredmet(tradePredmet.get("odeber").getNazev());
                        }
                        if (tradePredmet.get("pridej") != null) {
                            inventar.vlozPredmet(tradePredmet.get("pridej"));
                        }
                        return postava.chceOdpoved();
                    } else {
                        return postava.nechceOdpoved();
                    }
                } else if (postava.getJizMluvil()) {
                    return postava.getJmeno().substring(0, 1).toUpperCase() + postava.getJmeno().substring(1) + ": " + postava.getChceMluvit();
                } else {
                    return "*" + postava.getJmeno().substring(0, 1).toUpperCase() + postava.getJmeno().substring(1) + " na tebe nechápavě kouká*";
                }
            } else {
                return "Tato osoba v této oblasti není.";
            }

        } else if (parametry.length == 2) {
            return "Tohle nevlastníš.";
        } else {
            return "Moc parametrů, zkontroluj příkaz.";
        }
    }
}
