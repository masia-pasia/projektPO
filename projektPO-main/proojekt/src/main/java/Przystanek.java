import java.util.concurrent.ThreadLocalRandom;

public class Przystanek{
    public String name;
    public int pozx;
    public int pozy;
    public int stanTech;
    public String[] droga;

    //Konstruktor obiektu przystanek
    public Przystanek(String name, int pozx, int pozy, int stanTech) {
        this.name = name;
        this.pozx = pozx;
        this.pozy = pozy;
        this.stanTech = stanTech;
    }

    //Metoda wyswietlania informacji po dotarciu do danego przystanku
    public int PoinformujOPrzystanku(int przejazd){
        System.out.println("Dojechales/as do przystanku " + name + "!" );
        przejazd = ThreadLocalRandom.current().nextInt(1,20);
        System.out.println("Przejazd zajal: " + przejazd + " minut(y)");
        return przejazd;
    }

    //gettery
    public int getPozx() {
        return pozx;
    }

    public int getPozy() {
        return pozy;
    }

    public String getName() {
        return name;
    }
}
