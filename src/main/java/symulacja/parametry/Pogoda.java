package symulacja.parametry;

import symulacja.OdczytZPliku;

import java.util.List;

/**
 * Pogoda podczas trwania przejazdu.
 */
public class Pogoda{
    private int ryzyko;

    /**
     * Konstruktor obiektu pogoda
     */
    public Pogoda(){
        List<Object> parametryPogoda = OdczytZPliku.czytaniePogody();
    }

    public int getRyzyko() {
        return ryzyko;
    }
}
