import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Pasazer {
    public String poczatkowy;
    public String koncowy;
    public Czas godzina;

    public Pasazer() {
        Komunikacja();
    }

    public void Komunikacja() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nZ ktorego przystanku odjezdzasz?");
        String poczatek = scan.nextLine();
        while (CzyJestTakiPrzystanek(poczatek) == 0) {
            System.out.println("\nZ ktorego przystanku odjezdzasz?");
            poczatek = scan.nextLine();
        }
        ;
        System.out.println("Na jaki przystanek chcesz dojechac?");
        String koniec = scan.nextLine();
        while (CzyJestTakiPrzystanek(koniec) == 0) {
            System.out.println("\nZ ktorego przystanku odjezdzasz?");
            koniec = scan.nextLine();
        }
        int godzinka=0;
        int minutka=0;
        do {
            System.out.println("Podaj godzine odjazdu: ");
            godzinka = scan.nextInt();
            System.out.println("Podaj minute odjazdu: ");
            minutka = scan.nextInt();
            if(godzinka>23||minutka>59) System.out.println("Ty sie w caban jebnij pajacu. Naucz sie pisac godziny elo czesc.");
        }while(godzinka>23||minutka>59);
        Czas odjazd = new Czas(godzinka, minutka);
        poczatkowy = poczatek;
        koncowy = koniec;
        godzina = odjazd;
//        System.out.println("Wszystko git byq");
//
//
//        System.out.println(poczatkowy + " " + koncowy + " " + godzina);
    }

    public void KomunikacjaPoPrzesiadce(){

    }

    public int CzyJestTakiPrzystanek(String przystanek) {
        int a = 0;
        try {
            BufferedReader brr = new BufferedReader(
                    new FileReader("C:\\Users\\Dawid\\Desktop\\projektPO-main\\proojekt\\nowy.txt"));

            String odczyt;

            while ((odczyt = brr.readLine()) != null) {
                if (odczyt.equals(przystanek)) {
                    a = 1;
                }
            }
            if (a == 0) {
                System.out.println("Ty sie w caban jebnij pajacu, nie ma takiego przystanku");
            }
            brr.close();
        } catch (Exception noFile) {

        }
        return a;

    }

    public String getPoczatkowy() {return poczatkowy;}

    public String getKoncowy(){return koncowy;}
}