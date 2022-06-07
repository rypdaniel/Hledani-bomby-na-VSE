package logika;

/**
 * Class Skolnik - popisuje chovani skolníka
 *
 * @author Daniel Rypl
 * @version 2021/22
 */

public class Skolnik extends Postava{

    public Skolnik(String jmeno, String zobrazJmeno, Predmet coChce, Predmet coVlastni, String mluvPred, String mluvPo, String chceMluvit, String nechceMluvit) {
        super(jmeno, zobrazJmeno, coChce, coVlastni, mluvPred, mluvPo, chceMluvit, nechceMluvit);
    }
}
