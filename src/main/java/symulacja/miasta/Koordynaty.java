package symulacja.miasta;

/**
 * Wspolrzedne X oraz Y.
 */
public class Koordynaty {

    public int pozX;
    public int pozY;

    /**
     * Metoda przypisuje koordynaty dla danej pozycji.
     * @param pozX przekazana pozycja X
     * @param pozY przekazana pozycja Y
     */
    public void przypiszKoordynaty(int pozX, int pozY){
        this.pozX = pozX;
        this.pozY = pozY;
    }
}
