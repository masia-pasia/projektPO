import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Tramwaj implements LosoweLiczby, Pozycja {
    private int stanTechTramwaju;
    private int pozX = 0;
    private int pozY = 0;
    private int pozKoncowaX = 0;
    private int pozKoncowaY = 0;
    public String przystanekPoczatkowy;
    public String przystanekKoncowy;

    //Konstruktor obiektu tramwaj
    public Tramwaj (String przystanekPoczatkowy, String przystanekKoncowy){
        losuj();
        this.przystanekPoczatkowy = przystanekPoczatkowy;
        this.przystanekKoncowy = przystanekKoncowy;
    }

    //Metoda implementujaca interfejs losowe liczby
    @Override
    public int losuj(){
        int randoom = (int) (Math.random() * 26);
        stanTechTramwaju = randoom;
        return randoom;
    }

    //Metoda wyznaczajaca pozycje poczatkowa
    @Override
    public void poczatkowaPozycja(){
        int a = 0;
        OdczytZPliku plik = new OdczytZPliku();
        String nazwaPliku = "bazaprzystankow.txt";
        InputStream zawartosc = plik.pobierzZPliku(nazwaPliku);
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)) {

            String line;

            while ((line =czytaj.readLine())!=null){

                if (line.equals(przystanekPoczatkowy)){
                    break;
                }
                else {
                    a++;
                }
            }
        } catch (Exception noFile) {
            //return 0;
        }
        while (a > 4){
            pozY++;
            a -= 5;
            pozX = a;
        }
        pozX = a;
    }

    //Metoda wyznaczajaca pozycje koncowa
    @Override
    public void koncowaPozycja(){
        int a = 0;
        OdczytZPliku mapa = new OdczytZPliku();
        String nazwaPliku = "bazaprzystankow.txt";
        InputStream zawartosc = mapa.pobierzZPliku(nazwaPliku);
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)) {

            String line;

            while ((line = czytaj.readLine())!=null){

                if (line.equals(przystanekKoncowy)){
                    break;
                }
                else {
                    a++;
                }
            }
        } catch (Exception noFile) {
            //return 0;
        }
        while (a > 4){
            pozKoncowaY++;
            a -= 5;
            pozKoncowaX = a;
        }
        pozKoncowaX = a;
    }

   //gettery
    public int getPozX() {
        return pozX;
    }

    public int getPozY() {
        return pozY;
    }

    public int getPozKoncowaX() {
        return pozKoncowaX;
    }

    public int getPozKoncowaY() {
        return pozKoncowaY;
    }

    public int getStanTechTramwaju() {
        return stanTechTramwaju;
    }

}
