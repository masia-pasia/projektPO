package ObslugaSymulacji;

public class Pasazer extends Komunikacja {
    protected String przystanekPoczatkowy;
    protected String przystanekKoncowy;
    public Czas godzinaOdjazdu;

    //gettery
    public String getPrzystanekPoczatkowy() {
        return przystanekPoczatkowy;
    }

    public String getPrzystanekKoncowy(){
        return przystanekKoncowy;
    }
}
