package symulacja;

import symulacja.przejazd.Przejazd;
import symulacja.parametry.Parametry;

/**
 * Klasa startowa symulacji.
 */
public class Main {

    /**
     * Glowna metoda symulacji
     * @param args artumenty
     */
    public static void main(String[] args) {

        Parametry parametry = new Parametry();
        Przejazd przejazd = new Przejazd(parametry);
        while(true) {
            przejazd.wykonaniePrzejazdu();
        }
    }
}
