import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] mapka = new String[9][9];
        String[][] mapa = new String[5][5];
        int sztucznapetla = 1;
        int kalkulatorPrzesiadek=0;
        String aktualnyPrzystanek=null;
        int i = 1;
        Motorniczy mietek = new Motorniczy();
        Pogoda chujowa = new Pogoda();
        RozkladMiasta wroclaw = new RozkladMiasta(mapka);
        wroclaw.BudowanieMapy();
        //double z przecinkiem ziom, idk kurwa dlaczego
        Pasazer krzys = new Pasazer();
        Czas aktualnaGodzina = new Czas(krzys.godzina.godzina,krzys.godzina.minuta);
        System.out.println("Rozpoczynasz jazde o: ");
        aktualnaGodzina.wypiszCzas();


        while(true) {
            przesiadka:
            while (sztucznapetla == 1) {
                Tramwaj dwojka = new Tramwaj(krzys.getPoczatkowy(), krzys.getKoncowy());
                if(kalkulatorPrzesiadek!=0){
                    dwojka = new Tramwaj(aktualnyPrzystanek, krzys.getKoncowy());
                }
                dwojka.PoczatkowaPozycja();
                dwojka.KoncowaPozycja();
                Trasa trasaDwojka = new Trasa(mapa, dwojka.getPozx(), dwojka.getPozxk(), dwojka.getPozy(), dwojka.getPozyk());
                trasaDwojka.BudowanieMapy();
                trasaDwojka.droga = trasaDwojka.JakaTrasaByq(trasaDwojka.mapa);
                trasaDwojka.ZbudujPrzystanki(trasaDwojka.droga);
                ArrayList<Przystanek> NowePrzystanki = trasaDwojka.getPrzystanki();
//                Czas czas1, czas2;
//                czas1 = MPKWroclaw.wezwijMPK(NowePrzystanki.get(i).getPozx(),NowePrzystanki.get(i).getPozy());
//                czas2 = MPKWroclaw.wezwijAutobus(NowePrzystanki.get(i).getPozx(),NowePrzystanki.get(i).getPozy());
                KalkulatorOpoznien opoznienie = new KalkulatorOpoznien();
                KalkulatorWykolejen wykolejenie = new KalkulatorWykolejen();

                System.out.println("\nNo to zaczynamy, zioooooooooom");
                nala:
                for (int a = NowePrzystanki.size(); a > 1; a--, i++) {
                    Czas.stoper(2000);
                    wykolejenie.obliczSzanseWykolejenia(dwojka, chujowa, mietek, NowePrzystanki.get(i));
                    String wybor;
                    if (wykolejenie.czyJestWykolejenie()) {
                        do {
                            System.out.println("Chcesz skorzystac z pomocy MPKWroclaw czy kontynuowac jazde autobusem?\n" +
                                    "MPKWroclaw/Autobus");
                            Scanner scan = new Scanner(System.in);
                            wybor = scan.nextLine();
                            if (wybor.equals("MPKWroclaw")) {
                                Czas ileNaprawa = new Czas(0,0);
                                ileNaprawa = MPKWroclaw.wezwijMPK(NowePrzystanki.get(i).getPozx(),NowePrzystanki.get(i).getPozy());
                                aktualnaGodzina.przeliczCzas(ileNaprawa.minuta, ileNaprawa.godzina);
                                System.out.println("Aktualna godzina: ");
                                aktualnaGodzina.wypiszCzas();
                                break;

                            } else if (wybor.equals("Autobus")) {
                                Czas ileAutobus = new Czas(0,0);
                                ileAutobus = MPKWroclaw.wezwijAutobus(NowePrzystanki.get(i).getPozx(),NowePrzystanki.get(i).getPozy());
                                aktualnaGodzina.przeliczCzas(ileAutobus.minuta, ileAutobus.godzina);
                                System.out.print("Aktualna godzina: ");
                                aktualnaGodzina.wypiszCzas();
                                break nala;

                            } else System.out.print("Czy Ty nie umiesz pisac byq?");
                        } while (!"MPKWroclaw".equals(wybor) && !"Autobus".equals(wybor));

                    }
                    ;
                    Czas.stoper(2000);
                    opoznienie.obliczSzanseOpoznienia(mietek, chujowa);
                    aktualnaGodzina.przeliczCzas(opoznienie.czyJestOpoznienie(),0);
                    if (opoznienie.czyJestOpoznienie() > 5) {
                        do {
                            System.out.println("Czy chcesz zmienic tramwaj?\n" +
                                    "Tak/Nie");
                            Scanner scan = new Scanner(System.in);
                            wybor = scan.nextLine();
                            if (wybor.equals("tak") || wybor.equals("TAK") || wybor.equals("Tak")) {
                                ;
                                aktualnyPrzystanek = NowePrzystanki.get(i).getName();
                                kalkulatorPrzesiadek++;
                                break przesiadka;
                            } else if (wybor.equals("nie") || wybor.equals("NIE") || wybor.equals("Nie")) {
                                System.out.println("Okay byq, lecimy dalej");
                                break;
                            } else System.out.println("Czy Ty nie umiesz pisac byq?");
                        } while (!wybor.equals("TAK") && !wybor.equals("Tak") && !wybor.equals("tak") && !wybor.equals("NIE") && !wybor.equals("Nie") && !wybor.equals("nie"));
                    }
                    ;
                    Czas.stoper(2000);
                    int czasPrzejazdu=0;
                    czasPrzejazdu = NowePrzystanki.get(i).PoinformujOPrzystanku(czasPrzejazdu);
                    aktualnaGodzina.przeliczCzas(czasPrzejazdu,0);
                    aktualnaGodzina.wypiszCzas();
                }
                sztucznapetla = 0;
                System.out.println("Bezpiecznie dojechales do przystanku koncowego! Gratulacje!");
                return;
            }
        }
    }
}
