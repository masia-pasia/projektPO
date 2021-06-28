package symulacja.miasta;

import java.util.ArrayList;
import symulacja.OdczytZPliku;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Mapa {

    private final ArrayList<ArrayList<String>> mapa;
    // private ArrayList<String> podmapa;
    private final int wysokoscMapy = 5;
    private final int szerokoscMapy = 5;


    public Mapa(){
        this.mapa = new ArrayList<>();

        OdczytZPliku plik = new OdczytZPliku();
        String nazwaPliku = "bazaprzystankow.txt";
        InputStream zawartosc = plik.pobierzZPliku(nazwaPliku);
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)){

            for (int i = 0; i < wysokoscMapy; i++) {
                ArrayList<String> podmapa = new ArrayList<>();
                for (int j = 0; j < szerokoscMapy; j++) {
                    podmapa.add(czytaj.readLine());
                }
                mapa.add(podmapa);
            }
        } catch (Exception noFile) {
            //return 0;
        }
    }

    public ArrayList<ArrayList<String>> getMapa() {
        return mapa;
    }

}

/*
    [ ]     [    ] [ ]
     |          |
    [1, 2 ]    [1,2]


 */
