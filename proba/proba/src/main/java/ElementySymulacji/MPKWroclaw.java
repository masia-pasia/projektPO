package ElementySymulacji;
import ObslugaSymulacji.Czas;
import ObslugaSymulacji.KalkulatorCzasuDojazdu;

public class MPKWroclaw {

    //Metoda wywolywana po wezwaniu pomocy MPK
    public static Czas wezwijMPK(int pozX, int pozY){
        Czas czas;
        czas = KalkulatorCzasuDojazdu.czasDojazduMPK(pozX, pozY);
        System.out.println("Naprawa zajela: " + czas.getGodzina() + " godzin(y) i " + czas.getMinuta() + " minut(y)");
        return czas;
    }

    //Metoda wywolywana po wybraniu opcji dojazdu autobusem
    public static Czas wezwijAutobus(int pozX, int pozY){
        Czas czas;
        czas = KalkulatorCzasuDojazdu.czasDojazduAutobusu(pozX, pozY);
        System.out.println("\nPrzyjechałeś na miejsce po czasie: " + czas.getGodzina() + " godzinach i " + czas.getMinuta() + " minutach");
        return czas;
    }
}
