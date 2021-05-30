import java.io.BufferedReader;
import java.io.FileReader;

public class Linia { //extends Trasa
    public String[] przystanki;
    public double godzina;


    public Linia(String[] przystanki, double godzina) {
        this.przystanki = przystanki;
        this.godzina = godzina;
    }

}
