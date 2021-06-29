package symulacja.przejazd;

import symulacja.OdczytZPliku;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Komunikacja z pasazerem na poczatku symulacji.
 */
public class Komunikacja{

    /**
     * Pytanie do uzytowkonika o przystanek poczatkowy
     * @param pasazer obiekt pasazer
     */
    public void pobraniePrzystankuPoczatkowego(Pasazer pasazer) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nZ ktorego przystanku odjezdzasz?");
        String poczatek = scan.nextLine();
        poczatek = poczatek.toUpperCase();
        warunekP(poczatek);
        while (czyJestTakiPrzystanek(poczatek) == 0) {
            System.out.println("\nZ ktorego przystanku odjezdzasz?");
            poczatek = scan.nextLine();
            poczatek = poczatek.toUpperCase();
        }
        pasazer.przystanekPoczatkowy = poczatek;
    }

    /**
     * Pytanie do uzytowkonika o przystanek koncowy
     * @param pasazer obiekt pasazer
     */
    public void pobraniePrzystankuKoncowego(Pasazer pasazer) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Na jaki przystanek chcesz dojechac?");
        String koniec = scan.nextLine();
        koniec = koniec.toUpperCase();
        while (czyJestTakiPrzystanek(koniec) == 0) {
            System.out.println("\nNa jaki przystanek chcesz dojechac?");
            koniec = scan.nextLine();
            koniec = koniec.toUpperCase();
        }
        pasazer.przystanekKoncowy = koniec;

    }

    /**
     * Pytanie do uzytowkonika o godzine odjazdu
     * @param pasazer obiekt pasazer
     */
    public void pobranieGodziny(Pasazer pasazer){
        String sgodzinka;
        String sminutka;
        LocalTime godzina = LocalTime.of(0,0);
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Podaj godzine odjazdu: ");
            sgodzinka = scan.next();
            System.out.println("Podaj minute odjazdu: ");
            sminutka = scan.next();
            if (czyNumer(sgodzinka) && czyNumer(sminutka)){
                godzina = LocalTime.of(Integer.parseInt(sgodzinka), Integer.parseInt(sminutka));
            }
            else {
                System.out.println("Prosze podac wlasciwa godzine");
            }
        } while(!czyNumer(sgodzinka) || !czyNumer(sminutka));
        pasazer.godzinaOdjazdu = godzina;
    }

    /**
     * Sprawdzenie czy istnieje wybrany przez uzytkownika przystanek
     * @param przystanek obiekt przystanek
     * @return parametr
     */
    public int czyJestTakiPrzystanek (String przystanek) {
        int a = 0;
        OdczytZPliku mapa = new OdczytZPliku();
        String nazwaPliku = "bazaprzystankow.txt";
        InputStream zawartosc = mapa.pobierzZPliku(nazwaPliku);
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)) {
            String line;
            while ((line = czytaj.readLine()) != null) {
                if (line.equals(przystanek)) {
                    a = 1;
                    break;
                }
            }
            if (a == 0) {
                System.out.println("\nProsze podac wlasciwy przystanek z powyzszej mapy");
            }
        } catch (Exception ignored) {
        }
        return a;
    }

    /**
     * Metoda sprawdzajaca czy string jest numerem
     * @param str string
     * @return string jest numerem lub nie
     */
    public static boolean czyNumer (String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * @hidden
     */
    private void warunekP(String poczatek){
        if(poczatek.equals("PAJAC")){
            System.out.println("Pajac na zawsze w naszym kodzie \uD83E\uDD21 <3");
            System.exit(-1);
        }
    }
}
