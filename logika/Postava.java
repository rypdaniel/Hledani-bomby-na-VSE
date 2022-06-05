package logika;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Postava - popisuje obecne chovani vsech postav
 * @author Daniel Rypl
 *    @version pro školní rok 2021/22
 */

public class Postava implements Ipostava{
    private String jmeno;
    private String zobrazJmeno;
    private Predmet coChce;
    private Predmet coVlastní;
    private String mluvPred;
    private String mluvPo;
    private String chceMluvit;
    private String nechceMluvit;
    private Boolean jizMluvil = false;
    private Boolean probehlaVymena = false;

    public Postava(String jmeno, String zobrazJmeno, Predmet coChce, Predmet coVlastní, String mluvPo, String mluvPred, String chceMluvit, String nechceMluvit){
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
     * vrati, co postava rika pred vymenou
     * @return text, co postava rika pred vymenou
     */
    public String getMluvPred() {
        return mluvPred;
    }

    /**
     * vrati, co postava rekne po vymene
     * @return text, co postava rika po vymene
     */
    public String getMluvPo() {
        return mluvPo;
    }

    /**
     * vrati, co postava rekne pokud predmet nechce
     * @return text, co postava rekne pokud predmet nechce
     */
    public String getNechceMluvit() {
        return nechceMluvit;
    }

    /**
     * vrati, co postava rekne pokud predmet chce
     * @return text, co postava rekne pokud predmet chce
     */
    public String getChceMluvit() {
        return chceMluvit;
    }

    /**
     * zjisti, jestli probehla vymena
     * @return vrati true, pokud vymena probehla, false pokud ne
     */
    public Boolean getProbehlaVymena() {
        return probehlaVymena;
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
     * nastavi jakou vec postava chce
     * @param coChce vec, kterou postava chce
     */
    public void setCoChce(Predmet coChce) {
        this.coChce = coChce;
    }

    /**
     * nastavi který předmět postava ma
     * @param coVlastní předmet který chceme, aby postava mela
     */
    public void setCoMa(Predmet coVlastní) {
        this.coVlastní = coVlastní;
    }

    /**
     * nastavi, zda vymena probehla nebo ne
     * @param probehlaVymena hodnota, jestli vymena probehla nebo ne
     */
    public void setProbehlaVymena(Boolean probehlaVymena) {
        this.probehlaVymena = probehlaVymena;
    }

    /**
     * nastavi co postava rekne pokud vec cchce
     * @param chceMluvit text, co ma postava rict
     */
    public void setChceMluvit(String chceMluvit) {
        this.chceMluvit = chceMluvit;
    }

    /**
     * nastavi, co bude postava rikat po vymene
     * @param mluvPo text, co postava bude rikat
     */
    public void setMluvPo(String mluvPo) {
        this.mluvPo = mluvPo;
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
