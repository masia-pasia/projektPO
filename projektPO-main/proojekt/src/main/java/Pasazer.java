import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Pasazer {
    public String przystanekPoczatkowy;
    public String przystanekKoncowy;
    public Czas godzinaOdjazdu;

    //Konstruktor obiektu pasazer
    public Pasazer() {
        komunikacja();
    }

    //Metoda implementujaca komunikacje z uzytkownikiem w ktorej podaje dane poczatkowe dotyczace przejazdu tramwajem
    public void komunikacja() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nZ ktorego przystanku odjezdzasz?");
        String poczatek = scan.nextLine();
        while (czyJestTakiPrzystanek(poczatek) == 0) {
            System.out.println("\nZ ktorego przystanku odjezdzasz?");
            poczatek = scan.nextLine();
        }
        System.out.println("Na jaki przystanek chcesz dojechac?");
        String koniec = scan.nextLine();
        while (czyJestTakiPrzystanek(koniec) == 0) {
            System.out.println("\nZ ktorego przystanku odjezdzasz?");
            koniec = scan.nextLine();
        }
        przystanekPoczatkowy = poczatek;
        przystanekKoncowy = koniec;

        int godzinka = 0;
        String sgodzinka;
        int minutka = 0;
        String sminutka;
        do {
            System.out.println("Podaj godzine odjazdu: ");
            sgodzinka = scan.next();
            System.out.println("Podaj minute odjazdu: ");
            sminutka = scan.next();
            if (czyNumer(sgodzinka) && czyNumer(sminutka)){
                godzinka = Integer.parseInt(sgodzinka);
                minutka = Integer.parseInt(sminutka);
            } else {
                System.out.println("Prosze podac wlasciwa godzine");
            }
            if (godzinka>23||minutka>59) {
                System.out.println("Prosze podac wlasciwa godzine");
            }
        }while(!czyNumer(sgodzinka) || !czyNumer(sminutka) || godzinka>23|| minutka>59);
        godzinaOdjazdu = new Czas(Integer.parseInt(sgodzinka), Integer.parseInt(sminutka));
    }

    //Metoda odczytujaca dane z pliku bazaprzystankow.txt
    public int czyJestTakiPrzystanek (String przystanek) {
        int a = 0;
        OdczytZPliku mapa = new OdczytZPliku();
        String nazwaPliku = "bazaprzystankow.txt";
        InputStream zawartosc = mapa.pobierzZPliku(nazwaPliku);
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
            BufferedReader czytaj = new BufferedReader(odczyt)){

            String line;
            while ((line = czytaj.readLine()) != null) {
                if (line.equals(przystanek)) {
                    a = 1;
                    break;
                }
            }
            if (a == 0) {
                System.out.println("Prosze podac wlasciwy przystanek z powyzszej mapy");
            }
        } catch (Exception ignored) {

        }
        return a;
    }

    //Metoda sprawdzajaca czy string jest numerem
    public static boolean czyNumer (String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    //gettery
    public String getPrzystanekPoczatkowy() {
        return przystanekPoczatkowy;
    }

    public String getPrzystanekKoncowy(){
        return przystanekKoncowy;
    }
}
