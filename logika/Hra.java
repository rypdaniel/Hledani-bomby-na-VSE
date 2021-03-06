package logika;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */

public class Hra implements IHra {
    private final SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private final HerniPlan herniPlan;
    private boolean konecHry = false;
    private File soubor;

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() {
        herniPlan = new HerniPlan();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazMluv(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazKoupit(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazInventar(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPredat(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazZneskodni(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazSebrat(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        try {  // vytváří soubor (txt ve složce "adventura")
            soubor=new File("Hra "+ LocalDate.now() + ".txt");
            if (!soubor.exists()) {
                soubor.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        return "Je začátek zkouškového roku 2025.\n" +
               "Jsi nenápadný student, který omylem zůstal ve škole i po spuštění varovného signálu.\n" +
               "Cílem hry je úspěšně naleznout bombu a tu následně zneškodnit. \n" +
                "To však nebude jednoduché, protože budeš muset nalézt kleště. \n" +
               "\n" +
               herniPlan.getAktualniProstor().dlouhyPopis();
    }
    
    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "KONEC HRY";
    }
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
         System.arraycopy(slova, 1, parametry, 0, parametry.length);
        String textKVypsani;
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.provedPrikaz(parametry);
        }
        else {
            textKVypsani="Nevím co tím myslíš? Tento příkaz neznám.";
        }
         String doSouboru = radek + "\n" + textKVypsani + "\n\n"; // vytváří odřádkování v souboru
        try {
             Files.write(soubor.toPath(), doSouboru.getBytes(), StandardOpenOption.APPEND); // vypíše text do souboru
         } catch (IOException e) {
             e.printStackTrace();
         }
        return textKVypsani;
     }

    /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *
      */
    void setKonecHry() {
        this.konecHry = true;
    }
    
     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return     odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return herniPlan;
     }
}

