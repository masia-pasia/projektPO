package symulacja.miasta;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Przystanki na trasie przejazdu.
 */
public class Przystanek{
    private final String nazwaPrzystanku;
    private final Koordynaty pozycja;
    private final int stanTechnicznyPrzystanku;

    /**
     * Konstruktor tworzy obiekty przystanek uzywane przez trase.
     * @param nazwaPrzystanku nazwa przystanku
     * @param pozX pozycja X przystanku
     * @param pozY pozycja Y przystanku
     * @param stanTechnicznyPrzystanku stan techniczny przystanku
     */
    public Przystanek (String nazwaPrzystanku, int pozX, int pozY, int stanTechnicznyPrzystanku) {
        this.nazwaPrzystanku = nazwaPrzystanku;
        this.pozycja = new Koordynaty();
        pozycja.przypiszKoordynaty(pozX, pozY);
        this.stanTechnicznyPrzystanku = stanTechnicznyPrzystanku;
    }

    /**
     * Metoda informujaca o przyjechaniu na kolejny przystanek.
     * @return czas przejazdu miedzy aktualnym i poprzednim przystankiem
     */
    public int poinformujOPrzystanku(){
        System.out.println("Dojechales/as do przystanku " + getNazwaPrzystanku() + "!" );
        int czasPrzejazdu = ThreadLocalRandom.current().nextInt(1, 20);
        System.out.println("Przejazd zajal: " + czasPrzejazdu + " minut(y)");
        return czasPrzejazdu;
    }

    public int getPozX() {
        return pozycja.pozX;
    }

    public int getPozY() {
        return pozycja.pozY;
    }

    public String getNazwaPrzystanku() {
        return nazwaPrzystanku;
    }

    public int getStanTechnicznyPrzystanku() {
        return stanTechnicznyPrzystanku;
    }

}
