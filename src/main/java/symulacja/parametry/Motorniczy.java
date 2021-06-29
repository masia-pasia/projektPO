package symulacja.parametry;

import java.util.List;

import symulacja.OdczytZPliku;

/**
 * Motorniczy obslugujacy tramwaj.
 */
public class Motorniczy{

    private int wiek;
    private int doswiadczenie;

    /**
     * Konstruktor obiektu motorniczy
     */
    public Motorniczy(){
        List<Integer> parametryMotorniczego = OdczytZPliku.czytanieMotorniczego();
    }

    public int getWiek() {
        return wiek;
    }

    public int getDoswiadczenie() {
        return doswiadczenie;
    }

}
