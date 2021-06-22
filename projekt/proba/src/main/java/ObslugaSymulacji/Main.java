package ObslugaSymulacji;

import ElementyMiasta.Przystanek;
import ElementyMiasta.RozkladMiasta;
import ElementyMiasta.Trasa;
import ElementySymulacji.MPKWroclaw;
import ElementySymulacji.Motorniczy;
import ElementySymulacji.Pogoda;
import ElementySymulacji.Tramwaj;
import Utrudnienia.KalkulatorWykolejen;
import Utrudnienia.KalkulatorOpoznien;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Czas aktualnaGodzina;
    private static int i;
    private static Tramwaj tramwaj;
    private static KalkulatorWykolejen wykolejenie;
    private static KalkulatorOpoznien opoznienie;
    private static Motorniczy motorniczy;
    private static Pasazer pasazer;
    private static Pogoda pogoda;
    private static final String[][] rozkladMiasta = new String[9][9];
    private static final String[][] rozkladPrzystankow = new String[5][5];
    private static String aktualnyPrzystanek;
    private static int kalkulatorPrzesiadek;
    private static ArrayList<Przystanek> nowePrzystanki;
    private static int sztucznaPetla = 1;

    public static void main(String[] args) {

        ustawParametrySymulacji();

        while(true) {
            wykonaniePrzejazdu();

        }
    }

    //Tworzenie obiektow oraz ustalenie parametrow poczatkowych symulacji
    private static void ustawParametrySymulacji() {
        i = 1;
        motorniczy = new Motorniczy();
        pogoda = new Pogoda();
        RozkladMiasta wroclaw = new RozkladMiasta(rozkladMiasta);
        wroclaw.budowanieMapy();
        pasazer = new Pasazer();
        Komunikacja komunikacja = new Komunikacja();
        komunikacja.pobraniePrzystankuPoczatkowego(pasazer);
        komunikacja.pobraniePrzystankuKoncowego(pasazer);
        komunikacja.pobranieGodziny(pasazer);
        aktualnaGodzina = new Czas(pasazer.godzinaOdjazdu.getGodzina(), pasazer.godzinaOdjazdu.getMinuta());
        wykolejenie = new KalkulatorWykolejen();
        aktualnyPrzystanek = null;
        kalkulatorPrzesiadek = 0;
    }

    private static void planujPrzejazd() {
        if(kalkulatorPrzesiadek == 0) {
            tramwaj = new Tramwaj(pasazer.getPrzystanekPoczatkowy(), pasazer.getPrzystanekKoncowy());
        }
        else {
            tramwaj = new Tramwaj(aktualnyPrzystanek, pasazer.getPrzystanekKoncowy());
        }
        tramwaj.poczatkowaPozycja();
        tramwaj.koncowaPozycja();
        Trasa trasa = new Trasa(rozkladPrzystankow, tramwaj.getPozX(), tramwaj.getPozKoncowaX(), tramwaj.getPozY(), tramwaj.getPozKoncowaY());
        trasa.budowanieMapy();
        trasa.droga = trasa.wyborTrasy(trasa.mapa);
        trasa.zbudujPrzystanki(trasa.droga);
        nowePrzystanki = null;
        nowePrzystanki = trasa.getPrzystanki();
        opoznienie = new KalkulatorOpoznien();
        wykolejenie = new KalkulatorWykolejen();
    }

    //Metoda odpowiedzialna za przejazd tramwaju przez przystanki
    private static void wykonaniePrzejazdu() {


        przesiadka:
        while(sztucznaPetla == 1) {

            planujPrzejazd();
            System.out.println("\nRozpoczynasz jazde o: ");
            aktualnaGodzina.wypiszCzas();
            int pozostalePrzystanki = -1;
            na:
        for (pozostalePrzystanki = nowePrzystanki.size(); pozostalePrzystanki > 1; pozostalePrzystanki--, i++) {
            Czas.stoper(2000);
            wykolejenie.obliczSzanseWykolejenia(tramwaj, pogoda, motorniczy, nowePrzystanki.get(i));
            String wybor;
            if (wykolejenie.czyJestWykolejenie()) {

                do {

                    System.out.println("Chcesz skorzystac z pomocy MPKWroclaw czy kontynuowac jazde autobusem?\nWpisz: MPKWROCLAW/AUTOBUS");
                    Scanner scan = new Scanner(System.in);
                    wybor = scan.nextLine();
                    wybor = wybor.toUpperCase();
                    while (!Main.contains(wybor)) {
                        System.out.println("Wybierz jedna z podanych opcji");
                        System.out.println("MPKWROCLAW/AUTOBUS");
                        wybor = scan.nextLine();
                        wybor = wybor.toUpperCase();
                    }
                    TypyPomocy wybranaPomoc = TypyPomocy.valueOf(wybor);

                    if (wybranaPomoc == TypyPomocy.MPKWROCLAW) {
                        Czas ileNaprawa = new Czas(0, 0);
                        ileNaprawa = MPKWroclaw.wezwijMPK(nowePrzystanki.get(i).getPozX(), nowePrzystanki.get(i).getPozY());
                        aktualnaGodzina.przeliczCzas(ileNaprawa.getMinuta(), ileNaprawa.getGodzina());
                        System.out.print("Aktualna godzina ");
                        aktualnaGodzina.wypiszCzas();
                        break;
                    } else if (wybranaPomoc == TypyPomocy.AUTOBUS) {
                        Czas ileAutobus = new Czas(0, 0);
                        ileAutobus = MPKWroclaw.wezwijAutobus(nowePrzystanki.get(i).getPozX(), nowePrzystanki.get(i).getPozY());
                        aktualnaGodzina.przeliczCzas(ileAutobus.getMinuta(), ileAutobus.getGodzina());
                        System.out.print("Aktualna godzina ");
                        aktualnaGodzina.wypiszCzas();
                        sztucznaPetla = -1;
                        System.out.println("\nGratulacje!\nDojechales do przystanku koncowego!\nDziekujemy za wybranie lini MPK Wroclaw");
                        System.exit(0);
                    }
                    break na;

                } while(!Main.contains(wybor));



            }

            Czas.stoper(2000);
            opoznienie.obliczSzanseOpoznienia(motorniczy, pogoda);
            int czasOpoznienia = opoznienie.czyJestOpoznienie();
            aktualnaGodzina.przeliczCzas(czasOpoznienia, 0);
            if (czasOpoznienia > 5 && pozostalePrzystanki > 2) { //brak możliwości przesiadki na przedostatnim przystanku
                do {
                    if(nowePrzystanki.get(i).getPozX() == tramwaj.getPozKoncowaX() || nowePrzystanki.get(i).getPozY() == tramwaj.getPozKoncowaY() ){
                        break;
                    }
                    System.out.println("Czy chcesz zmienic tramwaj?\nTak/Nie");
                    Scanner scan = new Scanner(System.in);
                    wybor = scan.nextLine();
                    wybor = wybor.toUpperCase();
                    if (wybor.equals("TAK")) {
                        aktualnyPrzystanek = nowePrzystanki.get(i).getNazwaPrzystanku();
                        kalkulatorPrzesiadek++;
                        System.out.println("Nastapila przesiadka, kontynuujesz jazde");
                        break przesiadka;
                    } else if (wybor.equals("NIE")) {
                        break;
                    } else System.out.println("Prosze wybrac jedno z mozliwych rozwiazan");
                } while (!wybor.equals("TAK") && !wybor.equals("NIE"));
            }

                Czas.stoper(2000);
                int czasPrzejazdu = 0;
                czasPrzejazdu = nowePrzystanki.get(i).poinformujOPrzystanku();
                aktualnaGodzina.przeliczCzas(czasPrzejazdu, 0);
                System.out.print("Aktualna godzina ");
                aktualnaGodzina.wypiszCzas();
                System.out.print("\n");
        }
        sztucznaPetla = 0;
        if(pozostalePrzystanki ==1){
        System.out.println("\nGratulacje!\nDojechales do przystanku koncowego!\nDziekujemy za wybranie lini MPK Wroclaw");}
        System.exit(0);

    }

    }

    public static boolean contains (String wybor){
        for (TypyPomocy c : TypyPomocy.values()) {
            if (c.name().equals(wybor)) {
                return true;
            }
        }
        return false;
    }

}
