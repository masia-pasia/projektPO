import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Pasazer {
    public String poczatkowy;
    public String koncowy;
    public Czas godzina;

    //Konstruktor obiektu pasazer
    public Pasazer() {
        Komunikacja();
    }

    //Metoda implementujaca komunikacje z uzytkownikiem w ktorej podaje dane poczatkowe dotyczace przejazdu tramwajem
    public void Komunikacja() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nZ ktorego przystanku odjezdzasz?");
        String poczatek = scan.nextLine();
        while (CzyJestTakiPrzystanek(poczatek) == 0) {
            System.out.println("\nZ ktorego przystanku odjezdzasz?");
            poczatek = scan.nextLine();
        }
        System.out.println("Na jaki przystanek chcesz dojechac?");
        String koniec = scan.nextLine();
        while (CzyJestTakiPrzystanek(koniec) == 0) {
            System.out.println("\nZ ktorego przystanku odjezdzasz?");
            koniec = scan.nextLine();
        }
        int godzinka=0;
        String sgodzinka;
        int minutka=0;
        String sminutka;
        do {
            System.out.println("Podaj godzine odjazdu: ");
            sgodzinka = scan.next();
            System.out.println("Podaj minute odjazdu: ");
            sminutka = scan.next();
            if(isNumeric(sgodzinka) && isNumeric(sminutka)){
                godzinka = Integer.parseInt(sgodzinka);
                minutka = Integer.parseInt(sminutka);
            } else System.out.println("Prosze podac wlasciwa godzine");
            if(godzinka>23||minutka>59) System.out.println("Prosze podac wlasciwa godzine");
        }while(!isNumeric(sgodzinka) || !isNumeric(sminutka) || godzinka>23|| minutka>59);
        Czas odjazd = new Czas(Integer.parseInt(sgodzinka), Integer.parseInt(sminutka));
        poczatkowy = poczatek;
        koncowy = koniec;
        godzina = odjazd;
    }

    //Metoda odczytujaca dane z pliku bazaprzystankow.txt
    public int CzyJestTakiPrzystanek(String przystanek) {
        int a = 0;
        try {
            BufferedReader brr = new BufferedReader(
                    new FileReader("C:\\Users\\Dawid\\Desktop\\projektPO-main\\proojekt\\bazaprzystankow.txt"));

            String odczyt;

            while ((odczyt = brr.readLine()) != null) {
                if (odczyt.equals(przystanek)) {
                    a = 1;
                }
            }
            if (a == 0) {
                System.out.println("Prosze podac wlasciwy przystanek z powyzszej mapy");
            }
            brr.close();
        } catch (Exception noFile) {

        }
        return a;

    }

    //Metoda sprawdzajaca czy string jest numerem
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    //gettery
    public String getPoczatkowy() {return poczatkowy;}

    public String getKoncowy(){return koncowy;}
}
