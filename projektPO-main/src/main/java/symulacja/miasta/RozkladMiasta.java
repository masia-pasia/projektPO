package symulacja.miasta;

import java.io.*;
import java.nio.charset.StandardCharsets;
import symulacja.OdczytZPliku;


public class RozkladMiasta {
    private String[][] plansza;
    private final int wysokoscMiasta = 9;
    private final int szerokoscMiasta = 9;

    //Konstruktor rozkladu miasta
    public RozkladMiasta(String[][] plansza) {
        this.plansza = plansza;
    }

    //Metoda budujaca obraz mapy miasta na podstawie przystankow z pliku bazaprzystankow.txt
    public void budowanieMapy() {
        OdczytZPliku plik = new OdczytZPliku();
        String nazwaPliku = "bazaprzystankow.txt";
        InputStream zawartosc = plik.pobierzZPliku(nazwaPliku);
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)) {

            for (int i = 0; i < wysokoscMiasta; i += 2) {
                for (int j = 0; j < szerokoscMiasta; j += 2) {
                    plansza[i][j] = czytaj.readLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < wysokoscMiasta; i += 2) {
            for (int j = 0; j < szerokoscMiasta; j += 2) {
                plansza[i][j] = "|";
            }
        }

        for (int i = 0; i < wysokoscMiasta; i += 2) {
            for (int j = 1; j < szerokoscMiasta; j += 2) {
                plansza[i][j] = "---";
            }
        }

        for (int i = 1; i < wysokoscMiasta; i += 2) {
            for (int j = 1; j < szerokoscMiasta; j += 2) {
                plansza[i][j] = "   ";
            }
        }

        plansza[1][1]="MPK";
        plansza[7][5]="AUT";


    }
    public void wypiszMape(){
        System.out.println("\n  |Mapa miasta|\n");

        for (int i = 0; i < wysokoscMiasta; i++) {
            for (int j = 0; j < szerokoscMiasta; j++) {
                System.out.print(plansza[i][j]);
            }
            System.out.print("\n");
        }
    }
}
