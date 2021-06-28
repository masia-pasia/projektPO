package symulacja.przejazd;


import java.time.LocalTime;

public class Pasazer extends Komunikacja {
    protected String przystanekPoczatkowy;
    protected String przystanekKoncowy;
    public LocalTime godzinaOdjazdu;

    public Pasazer(){
    }


    //gettery
    public String getPrzystanekPoczatkowy() {
        return przystanekPoczatkowy;
    }

    public String getPrzystanekKoncowy(){
        return przystanekKoncowy;
    }
}
