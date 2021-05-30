import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        /*Tramwaj dwojka = new Tramwaj(2, 23, 8);
        System.out.println(dwojka.random());
        */
        String[][] mapka = new String[9][9];
        String[][] mapa = new String[5][5];
        RozkladMiasta wroclaw = new RozkladMiasta(mapka);
        wroclaw.BudowanieMapy();
        //double z przecinkiem ziom, idk kurwa dlaczego

        Pasazer krzys = new Pasazer();
        Tramwaj dwojka = new Tramwaj(krzys.getPoczatkowy(), krzys.getKoncowy());
        dwojka.PoczatkowaPozycja();
        dwojka.KoncowaPozycja();
        Trasa trasaDwojka = new Trasa(mapa, dwojka.getPozx(), dwojka.getPozxk(), dwojka.getPozy(), dwojka.getPozyk());
        trasaDwojka.BudowanieMapy();
        trasaDwojka.droga = trasaDwojka.JakaTrasaByq(trasaDwojka.mapa);
        Motorniczy mietek = new Motorniczy();
        Pogoda chujowa = new Pogoda();
        //Linia trojka = new Linia()


    }
}
