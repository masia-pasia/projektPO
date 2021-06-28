package symulacja;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;

import symulacja.parametry.Motorniczy;

public class
OdczytZPliku {

    public InputStream pobierzZPliku(String fileName) {
        ClassLoader zaladuj = getClass().getClassLoader();
        InputStream zawartosc = zaladuj.getResourceAsStream(fileName);
        if (zawartosc == null) {
            throw new IllegalArgumentException("Brak pliku: " + fileName);
        } else {
            return zawartosc;
        }
    }

    public static List<Integer> czytanieMotorniczego(){
        int numerMotorniczego;
        int wiek=0;
        int doswiadczenie = 0;


        OdczytZPliku motorniczy = new OdczytZPliku();
        String nazwaPliku = "bazamotorniczych.txt";
        InputStream zawartosc = motorniczy.pobierzZPliku(nazwaPliku);
        String numerWStringu = String.valueOf( numerMotorniczego = (int) (Math.random() * 4));

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


        List parametryMotorniczego = List.of(numerMotorniczego, wiek, doswiadczenie);
        return parametryMotorniczego;

    }

    public static List<Object> czytaniePogody(){
        Object[] elementyPogody = new Object[3];
        int numerPogody =0;
        int ryzyko =0;
        String nazwaPogody=null;
        elementyPogody[0]=numerPogody;
        elementyPogody[1]=ryzyko;
        elementyPogody[2]=nazwaPogody;

        OdczytZPliku plik = new OdczytZPliku();
        String nazwaPliku = "bazapogod.txt";
        InputStream zawartosc = plik.pobierzZPliku(nazwaPliku);
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)) {

            String line;
            String numerWStringu = String.valueOf(elementyPogody[0] = (int) (Math.random() * 4));

            while ((line = czytaj.readLine()) != null){

                if (line.equals(numerWStringu)){
                    elementyPogody[1] = Integer.parseInt(czytaj.readLine());
                    elementyPogody[2] = czytaj.readLine();
                    System.out.println("\nPogoda na dzis: " + elementyPogody[2]);
                    break;
                }
                else {
                    line = czytaj.readLine();
                    line = czytaj.readLine();
                }
            }
        } catch (Exception ignored) {
        }
        List parametryPogody = List.of(elementyPogody);
        return parametryPogody;

    }
}