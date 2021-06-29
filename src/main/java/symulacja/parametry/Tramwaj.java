package symulacja.parametry;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import symulacja.miasta.Koordynaty;
import symulacja.OdczytZPliku;

/**
 * Tramwaj ktorym porusza sie pasazer.
 */
public class Tramwaj{
    private int stanTechTramwaju;
    private final Koordynaty pozPoczatkowa;
    private final Koordynaty pozKoncowa;
    public String przystanekPoczatkowy;
    public String przystanekKoncowy;

    /**
     * Konstruktor obiektu tramwaj
     */
    public Tramwaj (String przystanekPoczatkowy, String przystanekKoncowy){
        losujStanTechniczny();
        this.pozPoczatkowa = new Koordynaty();
        this.pozKoncowa = new Koordynaty();
        this.przystanekPoczatkowy = przystanekPoczatkowy;
        this.przystanekKoncowy = przystanekKoncowy;
    }

    /**
     * Metoda ustawiajaca stan techniczny tramwaju
     */
    public void losujStanTechniczny(){
        stanTechTramwaju = (int) (Math.random() * 26);
    }

    /**
     * Metoda wyznaczajaca pozycje poczatkowa na podstawie mapy
     */
    public void poczatkowaPozycja(){
        pozPoczatkowa.przypiszKoordynaty(0,0);
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
            System.out.println("Brak pliku bazamotorniczych.txt");
        }
        while (a > 4){
            pozPoczatkowa.pozY++;
            a -= 5;
            pozPoczatkowa.pozX = a;
        }
        pozPoczatkowa.pozX = a;
    }

    /**
     * Metoda wyznaczajaca pozycje koncowa na podstawie mapy
     */
    public void koncowaPozycja(){
        pozKoncowa.przypiszKoordynaty(0,0);
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
            System.out.println("Brak pliku bazaprzystankow.txt");
        }
        while (a > 4){
            pozKoncowa.pozY++;
            a -= 5;
            pozKoncowa.pozX = a;
        }
        pozKoncowa.pozX = a;
    }

    public int getPozX() {
        return pozPoczatkowa.pozX;
    }

    public int getPozY() {
        return pozPoczatkowa.pozY;
    }

    public int getPozKoncowaX() {
        return pozKoncowa.pozX;
    }

    public int getPozKoncowaY() {
        return pozKoncowa.pozY;
    }

    public int getStanTechTramwaju() {
        return stanTechTramwaju;
    }

}
