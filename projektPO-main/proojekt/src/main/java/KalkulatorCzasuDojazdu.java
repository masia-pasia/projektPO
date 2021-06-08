import java.util.concurrent.ThreadLocalRandom;

public class KalkulatorCzasuDojazdu {

    //Metoda obliczająca czas jaki zajmie naprawa tramwaju
    public static Czas czasDojazduMPK(int pozX, int pozY){
        int pozXMPK = 1;
        int pozYMPK = 1;
        int ile = Math.abs((pozXMPK - pozX + pozYMPK - pozY + ThreadLocalRandom.current().nextInt(1,50))*10);
        Czas czas = new Czas(ile,0);
        czas.przeliczCzas(czas.getMinuta(), czas.getGodzina());
        if(czas.getGodzina() >2) czas.setGodzina(2);
        return czas;
    }

    //Metoda obliczająca czas po jakim autobus dowiezie pasażera do przystanku docelowego
    public static Czas czasDojazduAutobusu(int pozX, int pozY){
        int pozXAu = 7;
        int pozYAu = 5;
        int ile = Math.abs((pozXAu -pozX + pozYAu - pozY + ThreadLocalRandom.current().nextInt(1,30)));
        Czas czas = new Czas(ile,0);
        czas.przeliczCzas(czas.getMinuta(), czas.getGodzina());
        if(czas.getGodzina() >2) czas.setGodzina(2);
        return czas;
    }
}
