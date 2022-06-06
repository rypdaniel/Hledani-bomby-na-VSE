package logika;
/**
 * Class Policista - popisuje chovani policisty
 *
 * @author Daniel Rypl
 * @version 2021/22
 */

public class Policista extends Postava{
    public Policista(String jmeno, String zobrazJmeno, Predmet coChce, Predmet coVlastní, String mluvPred, String mluvPo, String chceMluvit, String nechceMluvit) {
        super(jmeno, zobrazJmeno, coChce, coVlastní, mluvPred, mluvPo, chceMluvit, nechceMluvit);
    }
}