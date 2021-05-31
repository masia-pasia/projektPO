import java.util.concurrent.ThreadLocalRandom;

public class KalkulatorCzasuDojazdu {
    public static Czas czasDojazduMPK(int pozx, int pozy){
        int pozxMPK = 1;
        int pozyMPK = 1;
        int ile = Math.abs((pozxMPK-pozx + pozyMPK-pozy+ ThreadLocalRandom.current().nextInt(1,50))*10);
        Czas czas = new Czas(ile,0);
        czas.przeliczCzas(czas.minuta,czas.godzina);
        if(czas.godzina>2) czas.godzina = 2;
        return czas;
    }

    public static Czas czasDojazduAutobusu(int pozx, int pozy){
        int pozxAu = 7;
        int pozyAu = 5;
        int ile = Math.abs((pozxAu-pozx + pozyAu-pozy + ThreadLocalRandom.current().nextInt(1,30)));
        Czas czas = new Czas(ile,0);
        czas.przeliczCzas(czas.minuta,czas.godzina);
        if(czas.godzina>2) czas.godzina = 2;
        return czas;
    }
}
