package symulacja.obliczenia;

import symulacja.miasta.Koordynaty;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class KalkulatorCzasuDojazdu {

    //Metoda obliczająca czas jaki zajmie naprawa tramwaju
    public static LocalTime czasDojazduMPK(int pozX, int pozY){
        Koordynaty pozMPK = new Koordynaty();
        pozMPK.przypiszKoordynaty(1,1);
        int ile = Math.abs((pozMPK.pozX - pozX + pozMPK.pozY - pozY + ThreadLocalRandom.current().nextInt(1,50))*10);
        LocalTime czas = LocalTime.of(0,0);
        czas = czas.plusMinutes(ile);
        return czas;
    }

    //Metoda obliczająca czas po jakim autobus dowiezie pasażera do przystanku docelowego
    public static LocalTime czasDojazduAutobusu(int pozX, int pozY){
        Koordynaty pozAutobusu = new Koordynaty();
        pozAutobusu.przypiszKoordynaty(7,5);
        int ile = Math.abs((pozAutobusu.pozX -pozX + pozAutobusu.pozY - pozY + ThreadLocalRandom.current().nextInt(1,30)));
        LocalTime czas = LocalTime.of(0,0);
        if(ile > 180) { ile -= 100;}
        czas = czas.plusMinutes(ile);
        return czas;
    }
}
