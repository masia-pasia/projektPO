import java.util.Scanner;

public class Pasazer {
    public String poczatkowy;
    public String koncowy;
    public double godzina;

    public Pasazer() {
        Komunikacja();
    }

    public void Komunikacja(){
        Scanner P = new Scanner(System.in);
        Scanner K = new Scanner(System.in);
        Scanner G = new Scanner(System.in);
        System.out.println("\nZ ktorego przystanku odjezdzasz?");
        String poczatek = P.nextLine();
        System.out.println("Na jaki przystanek chcesz dojechac?");
        String koniec = K.nextLine();
        System.out.println("O jakiej godzinie chcesz odjechac?");
        double godzinka = G.nextDouble();

        poczatkowy=poczatek;
        koncowy=koniec;
        godzina=godzinka;
        System.out.println("Wszystko git byq");


        System.out.println(poczatkowy + " " + koncowy + " " + godzina);
    }
}
