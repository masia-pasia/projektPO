package symulacja.miasta;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Trasa przejazdu tramwaju.
 */
public class Trasa {

    private final Koordynaty pozPoczatkowa;
    private final Koordynaty pozKoncowa;
    public Mapa mapa;
    public String[] droga;
    ArrayList<Przystanek> przystanki = new ArrayList<>();
    private int ileNaOsiX;
    private int ileNaOsiY;

    /**
     * Konstruktor obiektu trasa.
     * @param mapa mapa przystankow
     * @param pozPoczatkowaX pozycja X przystanku poczatkowego
     * @param pozKoncowaX pozycja X przystanku koncowego
     * @param pozPoczatkowaY pozycja Y przystanku poczatkowego
     * @param pozKoncowaY pozycja Y przystanku koncowego
     */
    public Trasa(Mapa mapa, int pozPoczatkowaX, int pozKoncowaX, int pozPoczatkowaY, int pozKoncowaY) {
        this.pozPoczatkowa = new Koordynaty();
        this.pozKoncowa = new Koordynaty();
        pozPoczatkowa.przypiszKoordynaty(pozPoczatkowaX, pozPoczatkowaY);
        pozKoncowa.przypiszKoordynaty(pozKoncowaX, pozKoncowaY);
        this.mapa = new Mapa();
    }

    /**
     * Metoda wykonywana przy wyborze trasy przejazdu przez uzytkownika.
     * @param mapa mapa przystankow
     * @return Zwraca wybrana trase
     */
    public String[] wyborTrasy(Mapa mapa) {
        ileNaOsiX = pozKoncowa.pozX - pozPoczatkowa.pozX;
        ileNaOsiY = pozKoncowa.pozY - pozPoczatkowa.pozY;
        int ilePrzystankow = przeliczIlePrzystankow();
        String[] droga1 = new String[ilePrzystankow + 1];
        String[] droga2 = new String[ilePrzystankow + 1];
        if (ileNaOsiX == 0 && ileNaOsiY == 0) {
            tenSamPrzystanek();
            return null;
        } else {
            int poz=0;
            droga1[0] = mapa.getMapa().get(pozPoczatkowa.pozY).get(pozPoczatkowa.pozX);
            droga2[0] = mapa.getMapa().get(pozPoczatkowa.pozY).get(pozPoczatkowa.pozX);
            if(ileNaOsiX != 0) {
                budujTrase1(droga1);
            }
            if(ileNaOsiY != 0) {
                budujTrase2(droga2);
            }
            if(ileNaOsiX != 0 && ileNaOsiY != 0){
                String wybor;
                do{
                    System.out.print("\nChcesz jechac trasa 1 czy 2: ");
                    Scanner scan = new Scanner(System.in);
                    wybor = scan.next();
                    System.out.print("\n");
                    if (wybor.equals("1")) return droga1;
                    else if(wybor.equals("2")) return droga2;
                    else System.out.println("\nProsze wybrac jedno z mozliwych rozwiazan");
                }while(true);
            }
            else if(ileNaOsiY == 0) return droga1;
            else return droga2;
        }
    }

    /**
     * Metoda losujaca stan techniczny torow przy przystanku.
     * @return szansa na wykolejenie spowodowana stanem technicznym torow
     */
    public int losujUszkodzenia(){
        return (int) (Math.random() * 26);
    }

    /**
     * Metoda budujaca przystanki na wybranej trasie.
     * @param droga tablica zawierajaca nazwy przystankow na trasie przejazdu
     */
    public void zbudujPrzystanki(String[] droga){
        int a=0;
        int pozx, pozy;
        int StanTech = losujUszkodzenia();
        int dlugosc=droga.length;
        while(dlugosc!=0){
            int wysokoscMapy = 5;
            int szerokoscMapy = 5;
            for(int i = 0; i < wysokoscMapy; i++){
                for(int j = 0; j < szerokoscMapy; j++){
                    if(droga[a].equals(mapa.getMapa().get(i).get(j))){
                        pozx = i;
                        pozy = j;
                        przystanki.add(new Przystanek(droga[a], pozx, pozy, StanTech));
                  }
                }
            }
            a++;
            dlugosc--;
        }
    }

    /**
     * Oblicza ilosc przystankow do przejechania.
     * @return liczba przystankow na trasie
     */
    private int przeliczIlePrzystankow(){
        if (ileNaOsiX < 0) {
            if (ileNaOsiY < 0) {
                return  -ileNaOsiX - ileNaOsiY;
            } else {
                return  -ileNaOsiX + ileNaOsiY;
            }
        } else if (ileNaOsiY < 0) {
            return ileNaOsiX - ileNaOsiY;
        } else {
            return ileNaOsiX + ileNaOsiY;
        }
    }

    /**
     * Wyjatek gdy przystanek poczatkowy jest tez przystankiem koncowym.
     */
    private void tenSamPrzystanek(){
        System.out.println("\nGratulacje!\nDojechales do przystanku koncowego!\nDziekujemy za wybranie lini MPK Wroclaw");
        System.exit(0);
    }

    /**
     * Metoda budujaca trase nr 1
     * @param droga1 przystanki na trasie 1
     */
    private void budujTrase1(String[] droga1){
            int poz = 1;
            if (ileNaOsiX > 0) {
                for (int i = 1; i <= ileNaOsiX; i++) {
                    droga1[poz] = mapa.getMapa().get(pozPoczatkowa.pozY).get(pozPoczatkowa.pozX + i);
                    poz++;
                }
            } else {
                for (int i = 1; i <= -ileNaOsiX; i++) {
                    droga1[poz] = mapa.getMapa().get(pozPoczatkowa.pozY).get(pozPoczatkowa.pozX - i);
                    poz++;
                }
            }
            if (ileNaOsiY > 0) {
                for (int i = 1; i <= ileNaOsiY; i++) {
                    droga1[poz] = mapa.getMapa().get(pozPoczatkowa.pozY + i).get(pozKoncowa.pozX);
                    poz++;
                }
            } else {
                for (int i = 1; i <= -ileNaOsiY; i++) {
                    droga1[poz] = mapa.getMapa().get(pozPoczatkowa.pozY - i).get(pozKoncowa.pozX);
                    poz++;
                }
            }
            System.out.println("\nTrasa 1: ");
            for (int i = 0; i < droga1.length - 1; i++) {
                System.out.print(droga1[i] + " --> ");
            }
            System.out.println(droga1[droga1.length - 1]);
    }

    /**
     * Metoda budujaca trase nr 2
     * @param droga2 przystanki na trasie nr 2
     */
    private void budujTrase2(String[] droga2){
            int poz = 1;
            if (ileNaOsiY > 0) {
                for (int i = 1; i <= ileNaOsiY; i++) {
                    droga2[poz] = mapa.getMapa().get(pozPoczatkowa.pozY + i).get(pozPoczatkowa.pozX);
                    poz++;
                }
            } else {
                for (int i = 1; i <= -ileNaOsiY; i++) {
                    droga2[poz] = mapa.getMapa().get(pozPoczatkowa.pozY - i).get(pozPoczatkowa.pozX);
                    poz++;
                }
            }
            if (ileNaOsiX > 0) {
                for (int i = 1; i <= ileNaOsiX; i++) {
                    droga2[poz] = mapa.getMapa().get(pozKoncowa.pozY).get(pozPoczatkowa.pozX + i);
                    poz++;
                }
            } else {
                for (int i = 1; i <= -ileNaOsiX; i++) {
                    droga2[poz] = mapa.getMapa().get(pozKoncowa.pozY).get(pozPoczatkowa.pozX - i);
                    poz++;
                }
            }
            System.out.println("\nTrasa 2: ");
            for (int i = 0; i < droga2.length - 1; i++) {
                System.out.print(droga2[i] + " --> ");
            }
            System.out.println(droga2[droga2.length - 1]);
    }

    public ArrayList<Przystanek> getPrzystanki() {return przystanki;}

    public Mapa getMapa() { return mapa; }

    public String[] getDroga() { return droga; }

    public void setDroga(String[] droga) { this.droga = droga; }

}