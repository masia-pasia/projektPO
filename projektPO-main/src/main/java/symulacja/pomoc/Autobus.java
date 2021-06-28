package symulacja.pomoc;

import java.time.LocalTime;
import symulacja.obliczenia.KalkulatorCzasuDojazdu;

public class Autobus implements Pomoc{

    private LocalTime ileAutobus;

    @Override
    public void przyzwanie(int pozX, int pozY) {
        ileAutobus = KalkulatorCzasuDojazdu.czasDojazduAutobusu(pozX, pozY);
        System.out.println("\nPrzyjechales na miejsce po czasie: " + ileAutobus.getHour() + " godzinach i " + ileAutobus.getMinute() + " minutach");
        System.out.println("\nGratulacje!\nDojechales do przystanku koncowego!\nDziekujemy za wybranie lini MPK Wroclaw");
    }

    @Override
    public LocalTime getCzas(){
        return ileAutobus;
    }
}
