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
    private final Status STATUS;
    private int cena = 0;

    public enum Status{
        LzeZneskodnit,
        NelzeZneskodnit

    }

    public Predmet(String nazev, String zobrazeni, Boolean lzeVzit, Status status) {
        this.nazev = nazev;
        this.lzeVzit = lzeVzit;
        this.zobrazeni = zobrazeni;
        this.STATUS = status;
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
        if (getStatus() == Status.NelzeZneskodnit){
        return this.lzeVzit;
         }
    return false;
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
     * @return vrací jestli lze, nebo nelze zneškodnit
     */
    public Status getStatus(){
        return STATUS;
    }
}

