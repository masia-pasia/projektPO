public class MPKWroclaw {

    //Metoda wywolywana po wezwaniu pomocy MPK
    public static Czas wezwijMPK(int pozx, int pozy){
        Czas czas;
        czas = KalkulatorCzasuDojazdu.czasDojazduMPK(pozx,pozy);
        System.out.println("Naprawa zajela: " + czas.godzina + " godzin(y) i " + czas.minuta + " minut(y)");
        return czas;
    }

    //Metoda wywolywana po wybraniu opcji dojazdu autobusem
    public static Czas wezwijAutobus(int pozx, int pozy){
        Czas czas;
        czas = KalkulatorCzasuDojazdu.czasDojazduAutobusu(pozx,pozy);
        System.out.println("Przyjechałeś na miejsce po czasie: " + czas.godzina + " godzinach i " + czas.minuta + " minutach");
        return czas;
    }
}
