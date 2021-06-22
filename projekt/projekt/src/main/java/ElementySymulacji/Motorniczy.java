package ElementySymulacji;

import java.io.*;
import java.nio.charset.StandardCharsets;
import ObslugaSymulacji.OdczytZPliku;

public class Motorniczy{
    private int numerMotorniczego;         //liczba porzadkowa przypisana motorniczemu
    private int wiek;          //wiek motorniczego podany w latach
    private int doswiadczenie; //doswiadczenie motorniczego podane w latach

    //Konstruktor klasy motorniczy
    public Motorniczy(){
        losujMotorniczego();
        czytanieZPliku();
    }

    //Metoda implementujaca liczby losowe
    public int losujMotorniczego(){
        numerMotorniczego = (int) (Math.random() * 4);
        return getNumerMotorniczego();
    }

    //Metoda odczytujaca dane z pliku bazamotorniczych.txt
    public void czytanieZPliku(){
        OdczytZPliku motorniczy = new OdczytZPliku();
        String nazwaPliku = "bazamotorniczych.txt";
        InputStream zawartosc = motorniczy.pobierzZPliku(nazwaPliku);
        String numerWStringu = String.valueOf(getNumerMotorniczego());

        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)) {
            String line;
            while ((line = czytaj.readLine()) != null) {
                if (line.equals(numerWStringu)) {
                    wiek = Integer.parseInt(czytaj.readLine());
                    doswiadczenie = Integer.parseInt(czytaj.readLine());
                    break;
                }
                else{
                    line = czytaj.readLine();
                    line = czytaj.readLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumerMotorniczego() {
        return numerMotorniczego;
    }

    public int getWiek() {
        return wiek;
    }

    public int getDoswiadczenie() {
        return doswiadczenie;
    }
}
