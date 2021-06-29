package symulacja.miasta;

import java.util.ArrayList;
import symulacja.OdczytZPliku;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Mapa miasta na ktorej wykonywane sa operacje.
 */
public class Mapa {

    private final ArrayList<ArrayList<String>> mapa;

    /**
     * Konstruktor tworzy mape wykorzystywana przez symulacje.
     */
    public Mapa(){
        this.mapa = new ArrayList<>();
        OdczytZPliku plik = new OdczytZPliku();
        InputStream zawartosc = plik.pobierzZPliku("bazaprzystankow.txt");
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)){
            int wysokoscMapy = 5;
            int szerokoscMapy = 5;
            for (int i = 0; i < wysokoscMapy; i++) {
                ArrayList<String> podmapa = new ArrayList<>();
                for (int j = 0; j < szerokoscMapy; j++) {
                    podmapa.add(czytaj.readLine());
                }
                mapa.add(podmapa);
            }
        } catch (Exception noFile) {
            System.out.println("Brak pliku bazaprzystankow.txt");
        }
    }

    public ArrayList<ArrayList<String>> getMapa() {
        return mapa;
    }

}

