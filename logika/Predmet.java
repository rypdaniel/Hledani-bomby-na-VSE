package logika;

/**
 * Class Vec - popisuje atributy a chovani veci
 * @author Daniel Rypl
 *    @version pro školní rok 2021/22
 */
public class Predmet {
    private final String nazev;
    private final String zobrazeni;
    private final Boolean lzeVzit;
    private final Boolean lzeZneskodnit;
    private int cena = 0;

    public Predmet(String nazev, String zobrazeni, Boolean lzeVzit, Boolean lzeZneskodnit) {
        this.nazev = nazev;
        this.lzeVzit = lzeVzit;
        this.zobrazeni = zobrazeni;
        this.lzeZneskodnit = lzeZneskodnit;
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
    public String getZobrazeni() {
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



    /**
     * vrati, zda lze predmet zneskodnit
     * @return true pokud jde zneskodnit, false pokud nelze
     */
    public Boolean getLzeZneskodnit() {
        return lzeZneskodnit;
    }
}

