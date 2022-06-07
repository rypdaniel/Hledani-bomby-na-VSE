package logika;

/**
 * Class PrikazInventar - dedi ze tridy Prikaz
 *
 * @author Daniel Rypl
 * @version 2021/22
 */

public class PrikazInventar extends Prikaz {
        public PrikazInventar(HerniPlan plan) {
            super("inventar", plan);
        }

        /**
         * zobrazi predmety v inventari
         *
         * @param parametry počet parametrů závisí na konkrétním příkazu.
         */
        @Override
        public String provedPrikaz(String... parametry) {
            return this.getHerniPlan().getInventar().zobrazitObsah();
        }
}
