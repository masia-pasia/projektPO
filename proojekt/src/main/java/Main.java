import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String[][] mapka = new String[9][9];
        String[][] mapa = new String[5][5];
        Motorniczy mietek = new Motorniczy();
        Pogoda chujowa = new Pogoda();
        RozkladMiasta wroclaw = new RozkladMiasta(mapka);
        wroclaw.BudowanieMapy();
        //double z przecinkiem ziom, idk kurwa dlaczego
        double czas1, czas2;
        czas1 = MPKWroclaw.wezwijMPK();
        czas2 = MPKWroclaw.wezwijAutobus();
        Pasazer krzys = new Pasazer();
//        przesiadka:;
        Tramwaj dwojka = new Tramwaj(krzys.getPoczatkowy(), krzys.getKoncowy());
        dwojka.PoczatkowaPozycja();
        dwojka.KoncowaPozycja();
        Trasa trasaDwojka = new Trasa(mapa, dwojka.getPozx(), dwojka.getPozxk(), dwojka.getPozy(), dwojka.getPozyk());
        trasaDwojka.BudowanieMapy();
        trasaDwojka.droga = trasaDwojka.JakaTrasaByq(trasaDwojka.mapa);
        System.out.println(Arrays.toString(trasaDwojka.droga));
        trasaDwojka.ZbudujPrzystanki(trasaDwojka.droga);
        ArrayList<Przystanek> NowePrzystanki = trasaDwojka.getPrzystanki();

        KalkulatorOpoznien opoznienie = new KalkulatorOpoznien();
        KalkulatorWykolejen wykolejenie = new KalkulatorWykolejen();

        int i=1;
        System.out.println("No to zaczynamy, zioooooooooom");
        nala: for(int a=NowePrzystanki.size();a>1; a--, i++){
            wykolejenie.obliczSzanseWykolejenia(dwojka, chujowa, mietek, NowePrzystanki.get(i));
            String wybor;
            if(wykolejenie.czyJestWykolejenie()){
               do {
                   System.out.println("Chcesz skorzystac z pomocy MPKWroclaw czy kontynuowac jazde autobusem?\n" +
                           "MPKWroclaw/Autobus");
                   Scanner scan = new Scanner(System.in);
                   wybor = scan.nextLine();
                   if (wybor.equals("MPKWroclaw")) {
                       MPKWroclaw mpk = new MPKWroclaw();
                       mpk.wezwijMPK();
                       break;

                   } else if (wybor.equals("Autobus")) {
                       MPKWroclaw autobus = new MPKWroclaw();
                       autobus.wezwijAutobus();
                       break nala;

                   } else System.out.println("Czy Ty nie umiesz pisac byq?");
               } while(!"MPKWroclaw".equals(wybor) && !"Autobus".equals(wybor));

            };


            opoznienie.obliczSzanseOpoznienia(mietek, chujowa);
            if(opoznienie.czyJestOpoznienie()>5){
                do{
                System.out.println("Czy chcesz zmienic tramwaj?\n" +
                        "Tak/Nie");
                Scanner scan = new Scanner(System.in);
                wybor = scan.nextLine();
                if(wybor.equals("tak")||wybor.equals("TAK")||wybor.equals("Tak")){
                    break ;
                } else if (wybor.equals("nie")||wybor.equals("NIE")||wybor.equals("Nie")){
                    System.out.println("Okay byq, lecimy dalej");
                    break;
                } else System.out.println("Czy Ty nie umiesz pisac byq?");
            } while(!wybor.equals("TAK")&&!wybor.equals("Tak")&&!wybor.equals("tak")&&!wybor.equals("NIE")&&!wybor.equals("Nie")&&!wybor.equals("nie"));
        };
            NowePrzystanki.get(i).PoinformujOPrzystanku();
            }
        System.out.println("Bezpiecznie dojechales do przystanku koncowego! Gratulacje!");
        }
    }

