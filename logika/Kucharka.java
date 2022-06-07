package logika;

/**
  Class Kucharka - popisuje chovani kuchařky

  @author Daniel Rypl
 * @version 2021/22
 */

public class Kucharka extends Postava{

    public Kucharka(String jmeno, String zobrazJmeno, Predmet coChce, Predmet coVlastni, String mluvPred, String mluvPo, String chceMluvit, String nechceMluvit) {
        super(jmeno, zobrazJmeno, coChce, coVlastni, mluvPred, mluvPo, chceMluvit, nechceMluvit);
    }
}
