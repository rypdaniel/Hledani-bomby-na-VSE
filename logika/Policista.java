package logika;
/**
 * Class Policista - popisuje chovani policisty
 *
 * @author Daniel Rypl
 * @version 2021/22
 */

@SuppressWarnings("ALL")
public class Policista extends Postava{
    public Policista(String jmeno, String zobrazJmeno, Predmet coChce, Predmet coVlastni, String mluvPred, String mluvPo, String chceMluvit, String nechceMluvit) {
        super(jmeno, zobrazJmeno, coChce, coVlastni, mluvPred, mluvPo, chceMluvit, nechceMluvit);
    }
}
