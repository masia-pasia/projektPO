import java.util.concurrent.ThreadLocalRandom;
public class MPKWroclaw {

    public static double wezwijMPK(){
        double czas;
        czas = ThreadLocalRandom.current().nextDouble()*100;
        System.out.println("Naprawa zajela: " + czas);
        return czas;
    }

    public static double wezwijAutobus(){
        double czas;
        czas = ThreadLocalRandom.current().nextDouble()*100;
        System.out.println("Przyjechałeś na miejsce po czasie: " + czas);
        return czas;
    }
}
