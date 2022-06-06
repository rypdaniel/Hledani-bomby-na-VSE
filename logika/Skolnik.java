package logika;

/**
 * Class Skolnik - popisuje chovani skolníka
 *
 * @author Daniel Rypl
 * @version 2021/22
 */

public class Skolnik extends Postava{

    public Skolnik(String jmeno, String zobrazJmeno, Predmet coChce, Predmet coVlastní, String mluvPred, String mluvPo, String chceMluvit, String nechceMluvit) {
        super(jmeno, zobrazJmeno, coChce, coVlastní, mluvPred, mluvPo, chceMluvit, nechceMluvit);
    }
}
