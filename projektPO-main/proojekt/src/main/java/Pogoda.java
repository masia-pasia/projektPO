import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Pogoda implements LosoweLiczby {
    private int numerPogody;
    private int ryzyko;
    private String nazwaPogody;

    //Konstruktor obiektu pogoda
    Pogoda(){
        losuj();
        czytanieZPliku();
    }

    //Metoda implementujaca interfejs losowe liczby
    @Override
    public int losuj(){
        numerPogody = (int) (Math.random() * 4);
        return getNumerPogody();
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
                    System.out.println("Pogoda na dzis: " + getNazwaPogody());
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
