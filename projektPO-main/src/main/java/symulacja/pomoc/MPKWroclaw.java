package symulacja.pomoc;

import symulacja.obliczenia.KalkulatorCzasuDojazdu;
import java.time.LocalTime;

public class MPKWroclaw implements Pomoc{

    LocalTime ileNaprawa;

    @Override
    public void przyzwanie(int pozX, int pozY) {
        ileNaprawa = KalkulatorCzasuDojazdu.czasDojazduMPK(pozX, pozY);
        System.out.println("Naprawa zajela: " + ileNaprawa.getHour() + " godzin(y) i " + ileNaprawa.getMinute() + " minut(y)");
    }

    @Override
    public LocalTime getCzas() {
        return ileNaprawa;
    }
}
