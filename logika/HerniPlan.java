package logika;


import java.util.HashMap;
import java.util.Map;

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
    private final Inventar inventar = new Inventar();
    private final Map<String, Prostor> prostory = new HashMap<>();
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

        prostory.put(vstup.getNazev(), vstup);
        prostory.put(chodba.getNazev(), chodba);
        prostory.put(pruchod.getNazev(), pruchod);
        prostory.put(kumbal.getNazev(), kumbal);
        prostory.put(menza.getNazev(), menza);


        // přiřazují se průchody mezi prostory (sousedící prostory)
        vstup.setVychod(chodba);
        chodba.setVychod(vstup);
        chodba.setVychod(pruchod);
        pruchod.setVychod(chodba);
        pruchod.setVychod(kumbal);
        pruchod.setVychod(menza);
        menza.setVychod(pruchod);
        kumbal.setVychod(pruchod);


        /*
          Definuje věci, které se ve hře vyskytují
         */
        Predmet potraviny = new Predmet("Potraviny", "Potraviny", true,false);
        Predmet kleste = new Predmet("Kleště", "Kleste", true,false);
        Predmet pivo = new Predmet("Pivo", "Pivo", true,false);
        Predmet BOMBA = new Predmet("Bomba","Bomba",false,true);
        Predmet Polevka = new Predmet("Polévka","Polévka",false, false);
        Predmet Voda = new Predmet("Voda","Voda",false, false);
        Polevka.setCena(50);
        Voda.setCena(5);
        menza.vlozPredmet(Polevka);
        menza.vlozPredmet(Voda);
        kumbal.vlozPredmet(pivo);
        kumbal.vlozPredmet(potraviny);
        pruchod.vlozPredmet(BOMBA);




        /*
          Interakce s vrátným
         */
        Vratny vratny = new Vratny("Vrátný", "Vrátný",pivo,kleste, """
                Dobrý den, co by jste potřeboval
                potřeoval bych kleště na zneškodnění bomby, nemáte náhodou nějaký?
                Ano, nějáký tu mám, ale nebude to zadarmo
                Co by jste tedy za ně chtěl
                Dojdi mi do kumbálo pro jedno pivko
                Dobrá, za chvilku tu jsem""",null,"Díky, snad ti to pomůže.",null);
        /*
         Interakce s kuchařkou
        */
        Kucharka kucharka = new Kucharka("Kuchařka","Kuchařka",potraviny,Voda,"Dobry den, můžu vám nabídnou polévku za 50 Kč, nebo vodu za 5Kč","Dobry den, můžu vám nabídnou polévku za 50 Kč, nebo vodu za 5Kč","Tohle neberu","Děkuji, tady máte svoje peníze");

        /*
          Vkládá postavy do daných prostorů
         */
        vstup.vlozPostavu(vratny);
        menza.vlozPostavu(kucharka);



                
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


    /**
     * vrati inventar
     * @return vrati inventar
     */
    public Inventar getInventar() {
        return this.inventar;
    }
}
