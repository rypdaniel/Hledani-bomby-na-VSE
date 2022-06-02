package logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor vstup = new Prostor("vstup","Místo před vstupem do budovy");
        Prostor chodba = new Prostor("chodba", "Dlouhá chodba, kde se náchází spousta místností");
        Prostor pruchod = new Prostor("průchod","průchod mezi budovami");
        Prostor kumbal = new Prostor("kumbál","místmost kam se chodí poflakovat školník");
        Prostor menza = new Prostor("menza","oblíbené místo všech studentů a zeměstnanců");
        
        // přiřazují se průchody mezi prostory (sousedící prostory)
        vstup.setVychod(chodba);
        chodba.setVychod(vstup);
        chodba.setVychod(pruchod);
        pruchod.setVychod(chodba);
        pruchod.setVychod(kumbal);
        pruchod.setVychod(menza);
        menza.setVychod(pruchod);
        kumbal.setVychod(pruchod);
                
        aktualniProstor = vstup;  // hra začíná u vstupu do školy
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

}
