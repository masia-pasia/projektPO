package ObslugaSymulacji;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Komunikacja{

    public void pobraniePrzystankuPoczatkowego(Pasazer pasazer) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nZ ktorego przystanku odjezdzasz?");
        String poczatek = scan.nextLine();
        poczatek = poczatek.toUpperCase();
        if(poczatek.equals("PAJAC")){
            System.out.println(
                    "Ty kurde, pajacu. Co ty sobie wyobrażasz? Myślisz, że to zabawne tak obrażać polski hip hop?\n" +
                            " Może byś coś palancie w końcu docenił? Dzięki Magikowi, znanego i bardzo cenionego artystę,\n" +
                            " zaczął rozwijać się nowy gatunek muzyczny, a wy, ludzie, którzy nic nie robicie i tylko krytykujecie innych,\n" +
                            " nic nie wprowadziliście. Siejecie zamęt, sprawiacie, że inni czują się gorzej bo słuchają hip hopu.\n" +
                            " Za co to? Za to, że ktoś lubi słuchać inną muzykę niż tym sam? Coś ci powiem, niemiły człowieku, że tak cię nazwę,\n" +
                            " bo takim samym szacunkiem darzysz innych ludzi swoim chorymi poglądami, odczep się od rapu, od prawdziwych\n" +
                            " artystów, nie jakiś pseudo twórców, którzy nawet dobrego tekstu do piosenki napisać nie potrafią, ale doceń\n" +
                            " tych prawdziwych, tych, którzy wnieśli coś do tego gatunku. Mówię tu o Magiku, Peji, czy nawet Tedym. Jesteś zwykłym\n" +
                            " hejterem, którego nie umiałbym w żaden sposób darzyć jakimkolwiek szacunkiem. Nie potrafię również\n" +
                            " wyobrazić sobie twoich zainteresowań, bo po tym co widzę, to ich kurde po prostu nie ma. Krytyka innych nie\n" +
                            " wlicza się do zainteresowań, ponieważ ta krytyka jaką odwalasz tutaj w internecie, jest zwykłym brakiem RIGCZU i\n" +
                            " dowodem na niski poziom intelektualny.");
        }
        while (czyJestTakiPrzystanek(poczatek) == 0) {
            System.out.println("\nZ ktorego przystanku odjezdzasz?");
            poczatek = scan.nextLine();
            poczatek = poczatek.toUpperCase();
        }
        pasazer.przystanekPoczatkowy = poczatek;
    }

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

    public void pobranieGodziny(Pasazer pasazer){
        int godzinka = 0;
        String sgodzinka;
        int minutka = 0;
        String sminutka;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Podaj godzine odjazdu: ");
            sgodzinka = scan.next();
            System.out.println("Podaj minute odjazdu: ");
            sminutka = scan.next();
            if (czyNumer(sgodzinka) && czyNumer(sminutka)){
                godzinka = Integer.parseInt(sgodzinka);
                minutka = Integer.parseInt(sminutka);
                if(godzinka < 0 || minutka < 0 || godzinka>23 || minutka>59){
                    System.out.println("Prosze podac wlasciwa godzine");
                }
            } else {
                System.out.println("Prosze podac wlasciwa godzine");
            }
        }while(!czyNumer(sgodzinka) || !czyNumer(sminutka) || godzinka>23 || minutka>59 || godzinka < 0 || minutka < 0);
        pasazer.godzinaOdjazdu = new Czas(Integer.parseInt(sgodzinka), Integer.parseInt(sminutka));
    }

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
                System.out.println("\nProsze podac wlasciwy przystanek z powyzszej mapy");
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


}
