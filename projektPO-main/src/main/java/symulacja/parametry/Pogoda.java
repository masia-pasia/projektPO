package symulacja.parametry;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import symulacja.OdczytZPliku;

public class Pogoda{
    private int numerPogody;
    private int ryzyko;
    private String nazwaPogody;
    private List parametryPogoda;

    //Konstruktor obiektu pogoda
    public Pogoda(){
        parametryPogoda = OdczytZPliku.czytaniePogody();

    }

    //Metoda odczytujaca dane z pliku bazapogod.txt
    public void czytanieZPliku(){
        OdczytZPliku plik = new OdczytZPliku();
        String nazwaPliku = "bazapogod.txt";
        InputStream zawartosc = plik.pobierzZPliku(nazwaPliku);
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)) {

            String line;
            String numerWStringu = String.valueOf(getNumerPogody());

            while ((line = czytaj.readLine()) != null){

                if (line.equals(numerWStringu)){
                    ryzyko = Integer.parseInt(czytaj.readLine());
                    nazwaPogody = czytaj.readLine();
                    System.out.println("\nPogoda na dzis: " + getNazwaPogody());
                    break;
                }
                else {
                    line = czytaj.readLine();
                    line = czytaj.readLine();
                }
            }
        } catch (Exception ignored) {
        }
    }

    public int getNumerPogody() {
        return numerPogody;
    }

    public int getRyzyko() {
        return ryzyko;
    }

    public String getNazwaPogody() {
        return nazwaPogody;
    }

}
