package logika;

/**
 * Class Kucharka - popisuje chovani kuchařky
 *
 * @author Daniel Rypl
 * @version 2021/22
 */

import java.util.Map;


public class Kucharka extends Postava{

    private Inventar inventar;

    public Kucharka(String jmeno, String zobrazJmeno, Predmet coChce, Predmet coVlastní, String mluvPred, String mluvPo, String chceMluvit, String nechceMluvit) {
        super(jmeno, zobrazJmeno, coChce, coVlastní, mluvPred, mluvPo, chceMluvit, nechceMluvit);
    }


    /**
     * da kuchařce co chce a ta následně předá hráči peníze.
     */
    public Map<String, Predmet> vymenitPredmet(Predmet predmet) {

        inventar.pricistPenize(predmet.getCena());
        return super.vymenitPredmet(predmet);
    }

}
