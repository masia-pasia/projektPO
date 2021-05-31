import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] mapka = new String[9][9];
        String[][] mapa = new String[5][5];
        int i = 1;
        Motorniczy mietek = new Motorniczy();
        Pogoda dzisiejszaPogoda = new Pogoda();
        RozkladMiasta wroclaw = new RozkladMiasta(mapka);
        wroclaw.BudowanieMapy();
        Pasazer krzys = new Pasazer();
        Czas aktualnaGodzina = new Czas(krzys.godzina.godzina,krzys.godzina.minuta);
        System.out.println("Rozpoczynasz jazde o: ");
        aktualnaGodzina.wypiszCzas();
        String aktualnyPrzystanek = null;
        int kalkulatorPrzesiadek = 0;
        int sztucznapetla = 1;
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
                trasaDwojka.droga = trasaDwojka.WyborTrasy(trasaDwojka.mapa);
                trasaDwojka.ZbudujPrzystanki(trasaDwojka.droga);
                ArrayList<Przystanek> NowePrzystanki = trasaDwojka.getPrzystanki();
                KalkulatorOpoznien opoznienie = new KalkulatorOpoznien();
                KalkulatorWykolejen wykolejenie = new KalkulatorWykolejen();
                System.out.println("\nRozpoczynasz jazde tramwajem");
                na:
                for (int a = NowePrzystanki.size(); a > 1; a--, i++) {
                    Czas.stoper(2000);
                    wykolejenie.obliczSzanseWykolejenia(dwojka, dzisiejszaPogoda, mietek, NowePrzystanki.get(i));
                    String wybor;
                    if (wykolejenie.czyJestWykolejenie()) {
                        do {
                            System.out.println("Chcesz skorzystac z pomocy MPKWroclaw czy kontynuowac jazde autobusem?\nWpisz: MPKWroclaw/Autobus");
                            Scanner scan = new Scanner(System.in);
                            wybor = scan.nextLine();
                            if (wybor.equals("MPKWroclaw")||wybor.equals("mpkwroclaw")) {
                                Czas ileNaprawa = new Czas(0,0);
                                ileNaprawa = MPKWroclaw.wezwijMPK(NowePrzystanki.get(i).getPozx(),NowePrzystanki.get(i).getPozy());
                                aktualnaGodzina.przeliczCzas(ileNaprawa.minuta, ileNaprawa.godzina);
                                System.out.println("Aktualna godzina: ");
                                aktualnaGodzina.wypiszCzas();
                                break;
                            } else if (wybor.equals("Autobus") || wybor.equals("autobus")) {
                                Czas ileAutobus = new Czas(0,0);
                                ileAutobus = MPKWroclaw.wezwijAutobus(NowePrzystanki.get(i).getPozx(),NowePrzystanki.get(i).getPozy());
                                aktualnaGodzina.przeliczCzas(ileAutobus.minuta, ileAutobus.godzina);
                                System.out.print("Aktualna godzina: ");
                                aktualnaGodzina.wypiszCzas();
                                break na;

                            } else System.out.println("Prosze wybrac jedno z mozliwych rozwiazan");
                        } while (!"MPKWroclaw".equals(wybor) && !"Autobus".equals(wybor) && !wybor.equals("mpkwroclaw") && wybor.equals("autobus"));
                    }
                    Czas.stoper(2000);
                    opoznienie.obliczSzanseOpoznienia(mietek, dzisiejszaPogoda);
                    int delay = opoznienie.czyJestOpoznienie();
                    aktualnaGodzina.przeliczCzas(delay,0);
                    if (delay > 5) {
                        do {
                            System.out.println("Czy chcesz zmienic tramwaj?\nTak/Nie");
                            Scanner scan = new Scanner(System.in);
                            wybor = scan.nextLine();
                            if (wybor.equals("tak") || wybor.equals("TAK") || wybor.equals("Tak")) {
                                aktualnyPrzystanek = NowePrzystanki.get(i).getName();
                                kalkulatorPrzesiadek++;
                                System.out.println("Nastapila przesiadka, kontynuujesz jazde");
                                break przesiadka;
                            } else if (wybor.equals("nie") || wybor.equals("NIE") || wybor.equals("Nie")) {
                                break;
                            } else System.out.println("Prosze wybrac jedno z mozliwych rozwiazan");
                        } while (!wybor.equals("TAK") && !wybor.equals("Tak") && !wybor.equals("tak") && !wybor.equals("NIE") && !wybor.equals("Nie") && !wybor.equals("nie"));
                    }
                    Czas.stoper(2000);
                    int czasPrzejazdu=0;
                    czasPrzejazdu = NowePrzystanki.get(i).PoinformujOPrzystanku(czasPrzejazdu);
                    aktualnaGodzina.przeliczCzas(czasPrzejazdu,0);
                    aktualnaGodzina.wypiszCzas();
                }
                sztucznapetla = 0;
                System.out.println("Dojechales do przystanku koncowego!\nDziekujemy za wybranie lini MPK Wroclaw\nGratulacje!");
                return;
            }
        }
    }
}
