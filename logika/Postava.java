package logika;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Postava - popisuje obecne chovani vsech postav
 * @author Daniel Rypl
 *    @version pro školní rok 2021/22
 */

@SuppressWarnings("ALL")
public class Postava implements Ipostava{
    private final String jmeno;
    private final String zobrazJmeno;
    private Predmet coChce;
    private Predmet coVlastní;
    private final String mluvPred;
    private final String mluvPo;
    private final String chceMluvit;
    private final String nechceMluvit;
    private Boolean jizMluvil = false;
    private Boolean probehlaVymena = false;

    public Postava(String jmeno, String zobrazJmeno, Predmet coChce, Predmet coVlastní, String mluvPred, String mluvPo, String chceMluvit, String nechceMluvit){
        this.jmeno = jmeno;
        this.coChce = coChce;
        this.coVlastní = coVlastní;
        this.mluvPred = mluvPred;
        this.mluvPo = mluvPo;
        this.chceMluvit = chceMluvit;
        this.nechceMluvit = nechceMluvit;
        this.zobrazJmeno = zobrazJmeno;
    }
    /**
     * urcuje, co postava rekne
     * @return text, co postava rika
     */
    public String mluv() {
        jizMluvil = true;
        if(!probehlaVymena) {
            return velkyPismeno(zobrazJmeno) + ": " + mluvPred;
        }
        else{
            return velkyPismeno(zobrazJmeno) + ": " + mluvPo;
        }
    }
    /**
     * vrati kladnou odpoved na vymenu predmetu
     * @return text kladne odpovedi
     */
    public String chceOdpoved() {
        return velkyPismeno(zobrazJmeno) + ": " + chceMluvit;
    }

    /**
     * vrati zapornou odpoved na vymenu predmetu
     * @return text zaporne odpovedi
     */
    public String nechceOdpoved() {
        return velkyPismeno(zobrazJmeno) + ": " + nechceMluvit;
    }

    /**
     * metoda, ktera vymeni predmet s danou postavou
     * @param predmet predmet, kterou postava chce
     * @return list predmetu, ktere budeme nasledne odebirat/pridavat do inventare
     */
    public Map<String, Predmet> vymenitPredmet(Predmet predmet) {
        probehlaVymena = true;
        Map<String, Predmet> predmety = new HashMap<>();
        predmety.put("odeber", predmet);
        predmety.put("pridej", coVlastní);
        coChce = null;
        coVlastní = predmet;
        return predmety;
    }

    /**
     * vrati predmet, ktery postava vlastní
     * @return predmet, ktery postava vlstní
     */
    public Predmet getCoVlastní() {
        return coVlastní;
    }


    /**
     * vrati, co postava rekne pokud predmet chce
     * @return text, co postava rekne pokud predmet chce
     */
    public String getChceMluvit() {
        return chceMluvit;
    }


    /**
     * vrati jmeno postavy
     * @return text jmena postavy
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * vrati, co postava chce
     * @return predmet, kterou postava chce
     */
    public Predmet getCoChce() {
        return coChce;
    }

    /**
     * zjisti, jestli postava jiz mluvila
     * @return true pokud jiz mluvil, false pokud jeste nemluvil
     */
    public Boolean getJizMluvil() {
        return jizMluvil;
    }


    /**
     * vrati screenJmeno
     * @return text screenJmeno
     */
    public String getZobrazJmeno() {
        return zobrazJmeno;
    }

    private String velkyPismeno(String text) {
        return text.substring(0,1).toUpperCase() + text.substring(1);
    }

}
