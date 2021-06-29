package symulacja.pomoc;


import java.time.LocalTime;

/**
 * Interfejs pomocy w razie wykolejenia.
 */
public interface Pomoc {

    void przyzwanie(int pozX, int pozY);
    LocalTime getCzas();
}
