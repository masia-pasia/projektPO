import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        /*Tramwaj dwojka = new Tramwaj(2, 23, 8);
        System.out.println(dwojka.random());
        */
        String[][] mapa = new String[9][9];

        RozkladMiasta wroclaw = new RozkladMiasta(mapa);
        wroclaw.BudowanieMapy();

        Pasazer krzys = new Pasazer();

    }
}
