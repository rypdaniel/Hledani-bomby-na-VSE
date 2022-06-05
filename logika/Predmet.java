package logika;

/**
 * Class Vec - popisuje atributy a chovani veci
 * @author Daniel Rypl
 *    @version pro školní rok 2021/22
 */
public class Predmet {
    private String nazev;
    private String zobrazeni;
    private Boolean lzeVzit;
    private int cena = 0;

    public Predmet(String nazev, String zobrazeni, Boolean lzeVzit) {
        this.nazev = nazev;
        this.lzeVzit = lzeVzit;
        this.zobrazeni = zobrazeni;
    }

    /**
     * vrati nazev veci
     * @return textu nazvu veci
     */
    public String getNazev() {
        return this.nazev;
    }

    /**
     * vrati screenNazev veci
     * @return text screenNazev veci
     */
    public String getScreenNazev() {
        return this.zobrazeni;
    }

    /**
     * vrati, zda lze predmet vzit
     * @return true pokud jde vzit, false pokud nelze
     */
    public Boolean getLzeVzit() {
        return this.lzeVzit;
    }

    /**
     * nastavi cenu veci
     * @param cena - cena, kterou vec bude mit
     */
    public void setCena(int cena) {
        this.cena = cena;
    }

    /**
     * vrati cenu veci
     * @return cena veci
     */
    public int getCena() {
        return this.cena;
    }
}
