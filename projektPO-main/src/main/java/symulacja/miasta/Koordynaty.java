package symulacja.miasta;

public class Koordynaty {

    public int pozX;
    public int pozY;

    public Koordynaty (){
    }

    public void przypiszKoordynaty(int pozX, int pozY){
        this.pozX = pozX;
        this.pozY = pozY;
    }

    public int getPozX() {
        return pozX;
    }

    public int getPozY() {
        return pozY;
    }
}
