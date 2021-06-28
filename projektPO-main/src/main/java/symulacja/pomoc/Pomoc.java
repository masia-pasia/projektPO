package symulacja.pomoc;


import java.time.LocalTime;

public interface Pomoc {

    void przyzwanie(int pozX, int pozY);
    LocalTime getCzas();

}
