import java.util.concurrent.ThreadLocalRandom;

public class Przystanek{
    private final String nazwaPrzystanku;
    private final int pozX;
    private final int pozY;
    private final int stanTechnicznyPrzystanku;

    //Konstruktor obiektu przystanek
    public Przystanek (String nazwaPrzystanku, int pozX, int pozY, int stanTechnicznyPrzystanku) {
        this.nazwaPrzystanku = nazwaPrzystanku;
        this.pozX = pozX;
        this.pozY = pozY;
        this.stanTechnicznyPrzystanku = stanTechnicznyPrzystanku;
    }

    //Metoda wyswietlania informacji po dotarciu do danego przystanku
    public int poinformujOPrzystanku(){
        System.out.println("Dojechales/as do przystanku " + getNazwaPrzystanku() + "!" );
        int przejazd = ThreadLocalRandom.current().nextInt(1, 20);
        System.out.println("Przejazd zajal: " + przejazd + " minut(y)");
        return przejazd;
    }

    //gettery
    public int getPozX() {
        return pozX;
    }

    public int getPozY() {
        return pozY;
    }

    public String getNazwaPrzystanku() {
        return nazwaPrzystanku;
    }

    public int getStanTechnicznyPrzystanku() {
        return stanTechnicznyPrzystanku;
    }

}
