package symulacja.przejazd;


import java.time.LocalTime;

/**
 * Aktor bedacy pasazerem tramwaju ktorym porusza sie w symulacji.
 */
public class Pasazer extends Komunikacja {

    protected String przystanekPoczatkowy;
    protected String przystanekKoncowy;
    public LocalTime godzinaOdjazdu;

    public String getPrzystanekPoczatkowy() {
        return przystanekPoczatkowy;
    }

    public String getPrzystanekKoncowy(){
        return przystanekKoncowy;
    }
}
