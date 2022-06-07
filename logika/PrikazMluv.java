package logika;

/**
 * Class PrikazMluv - dedi ze tridy Prikaz
 * @author Daniel Rypl
 * @version pro školní rok 2021/22
 */

public class PrikazMluv extends Prikaz{
    public PrikazMluv(HerniPlan plan) {
        super("mluv", plan );
    }

    /**
     * metoda promluvi na danou postavu
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return promluví na danou postavu
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo, tak ....
            return "Na koho mam mluvit?";
        }
        else if(parametry.length == 1 && this.getHerniPlan().getAktualniProstor().obsahujePostavu(parametry[0])) {
            // pokud je druhe slovo takové, které lze vložit do invetáře
            return this.getHerniPlan().getAktualniProstor().vratPostavu(parametry[0]).mluv();
        }
        return "Tahle osoba tu není";
    }

}
