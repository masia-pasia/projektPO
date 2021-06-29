package symulacja.pomoc;

import symulacja.obliczenia.KalkulatorCzasuDojazdu;
import java.time.LocalTime;

/**
 * MPK Wroclaw naprawiajace tramwaj w razie wykolejenia.
 */
public class MPKWroclaw implements Pomoc{

    private LocalTime ileNaprawa;

    /**
     * Metoda wykonywana po wezwaniu MPK w razie wykolejenia
     * @param pozX aktualna pozycja X pasazera
     * @param pozY aktualna pozycja Y pasazera
     */
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
