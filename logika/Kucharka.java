package logika;

/*
  Class Kucharka - popisuje chovani kuchařky

  @author Daniel Rypl
 * @version 2021/22
 */

@SuppressWarnings("ALL")
public class Kucharka extends Postava{

    public Kucharka(String jmeno, String zobrazJmeno, Predmet coChce, Predmet coVlastní, String mluvPred, String mluvPo, String chceMluvit, String nechceMluvit) {
        super(jmeno, zobrazJmeno, coChce, coVlastní, mluvPred, mluvPo, chceMluvit, nechceMluvit);
    }
}
