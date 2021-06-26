package ElementyMiasta;

import ObslugaSymulacji.OdczytZPliku;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.ArrayList;

public class Trasa {
    private final Koordynaty pozPoczatkowa;
    private final Koordynaty pozKoncowa;

    public String[][] mapa;
    public String[] droga;
    ArrayList<Przystanek> przystanki = new ArrayList<>();

    //Konstruktor obiektu trasa
    public Trasa(String[][] mapa, int pozPoczatkowaX, int pozKoncowaX, int pozPoczatkowaY, int pozKoncowaY){
        this.pozPoczatkowa = new Koordynaty();
        this.pozKoncowa = new Koordynaty();
        pozPoczatkowa.przypiszKoordynaty(pozPoczatkowaX, pozPoczatkowaY);
        pozKoncowa.przypiszKoordynaty(pozKoncowaX,pozKoncowaY);
        this.mapa = mapa;
    }

    //Metoda budujaca mape pomocnicza
    public void budowanieMapy() {
        OdczytZPliku plik = new OdczytZPliku();
        String nazwaPliku = "bazaprzystankow.txt";
        InputStream zawartosc = plik.pobierzZPliku(nazwaPliku);
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)){

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    mapa[i][j] = czytaj.readLine();
                }
            }
        } catch (Exception noFile) {
            //return 0;
        }
    }

    //Metoda wykonywana przy wyborze trasy przez uzytkownika, budujaca mozliwe trasy
    public String[] wyborTrasy(String[][] mapa) {
        int ileNaOsiX = pozKoncowa.pozX - pozPoczatkowa.pozX;
        int ileNaOsiY = pozKoncowa.pozY - pozPoczatkowa.pozY;
        int ilePrzystankow; //dlugosc trasy
        if (ileNaOsiX < 0) {
            if (ileNaOsiY < 0) {
                ilePrzystankow = -ileNaOsiX - ileNaOsiY;
            } else {
                ilePrzystankow = -ileNaOsiX + ileNaOsiY;
            }
        } else if (ileNaOsiY < 0) {
            ilePrzystankow = ileNaOsiX - ileNaOsiY;
        } else {
            ilePrzystankow = ileNaOsiX + ileNaOsiY;
        }
        String[] droga1 = new String[ilePrzystankow + 1]; //dwie mozliwe drogi
        String[] droga2 = new String[ilePrzystankow + 1];

        if (ileNaOsiX == 0 && ileNaOsiY == 0) {
            System.out.println("Ale to smieszne, isc na tramwaj zeby nigdzie nie pojechac"); //wyjatek jesli przystanekPoczatkowy = przystanekKoncowy
            String[] komedia = new String[1];
            komedia[0]="🤡  Krol komedii  🤡";
            System.out.println(komedia[0]);
            System.exit(0);
            return komedia;
        } else {
            int poz;
            droga1[0] = mapa[pozPoczatkowa.pozY][pozPoczatkowa.pozX];
            droga2[0] = mapa[pozPoczatkowa.pozY][pozPoczatkowa.pozX];

            if(ileNaOsiX !=0) {//pierwsza trasa
                poz = 1;
                if (ileNaOsiX > 0) {
                    for (int i = 1; i <= ileNaOsiX; i++) {
                        droga1[poz] = mapa[pozPoczatkowa.pozY][pozPoczatkowa.pozX + i];
                        poz++;
                    }
                } else {
                    for (int i = 1; i <= -ileNaOsiX; i++) {
                        droga1[poz] = mapa[pozPoczatkowa.pozY][pozPoczatkowa.pozX - i];
                        poz++;
                    }
                }
                if (ileNaOsiY > 0) {
                    for (int i = 1; i <= ileNaOsiY; i++) {
                        droga1[poz] = mapa[pozPoczatkowa.pozY + i][pozKoncowa.pozX];
                        poz++;
                    }
                } else {
                    for (int i = 1; i <= -ileNaOsiY; i++) {
                        droga1[poz] = mapa[pozPoczatkowa.pozY - i][pozKoncowa.pozX];
                        poz++;
                    }
                }
                System.out.println("\nTrasa 1: ");
                for (int i = 0; i < droga1.length - 1; i++) { //wypisanie trasy1
                    System.out.print(droga1[i] + " --> ");
                }
                System.out.println(droga1[droga1.length - 1]);
            }

            if(ileNaOsiY !=0) {//druga trasa
                poz = 1;
                if (ileNaOsiY > 0) {
                    for (int i = 1; i <= ileNaOsiY; i++) {
                        droga2[poz] = mapa[pozPoczatkowa.pozY + i][pozPoczatkowa.pozX];
                        poz++;
                    }
                } else {
                    for (int i = 1; i <= -ileNaOsiY; i++) {
                        droga2[poz] = mapa[pozPoczatkowa.pozY - i][pozPoczatkowa.pozX];
                        poz++;
                    }
                }
                if (ileNaOsiX > 0) {
                    for (int i = 1; i <= ileNaOsiX; i++) {
                        droga2[poz] = mapa[pozKoncowa.pozY][pozPoczatkowa.pozX + i];
                        poz++;
                    }
                } else {
                    for (int i = 1; i <= -ileNaOsiX; i++) {
                        droga2[poz] = mapa[pozKoncowa.pozY][pozPoczatkowa.pozX - i];
                        poz++;
                    }
                }
                System.out.println("\nTrasa 2: ");
                for (int i = 0; i < droga2.length - 1; i++) { //wypisanie trasy2
                    System.out.print(droga2[i] + " --> ");
                }
                System.out.println(droga2[droga2.length - 1]);
            }

            if(ileNaOsiX !=0&& ileNaOsiY !=0){
                String wybor;
                do{
                    System.out.print("\nChcesz jechać trasą 1 czy 2: "); //wybor trasy
                    Scanner scan = new Scanner(System.in);
                    wybor = scan.next();
                    System.out.print("\n");
                    if (wybor.equals("1")) return droga1;
                    else if(wybor.equals("2")) return droga2;
                    else System.out.println("\nProsze wybrac jedno z mozliwych rozwiazan");
                }while(true);
            }
            else if(ileNaOsiY ==0) return droga1;
            else return droga2;
        }
    }

    //Metoda implemetujaca interfejs losowe liczby
    public int losujUszkodzenia(){
        return (int) (Math.random() * 26);
    }

    //Metoda tworzaca przystanki na wybranej trasie
    public void zbudujPrzystanki(String[] droga){
        int a=0;
        int pozx, pozy;
        int StanTech = losujUszkodzenia();
        int dlugosc=droga.length;
        while(dlugosc!=0){
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(droga[a].equals(mapa[i][j])){
                        pozx=i;
                        pozy=j;
                        przystanki.add(new Przystanek(droga[a], pozx, pozy, StanTech));
                    }
                }
            }
            a++;
            dlugosc--;
        }
    }

    //getter
    public ArrayList<Przystanek> getPrzystanki() {return przystanki;}
}