package symulacja.przejazd;

import symulacja.miasta.Trasa;
import symulacja.parametry.Parametry;
import symulacja.parametry.Tramwaj;
import symulacja.pomoc.TypyPomocy;
import symulacja.obliczenia.KalkulatorOpoznien;
import symulacja.obliczenia.KalkulatorWykolejen;
import symulacja.pomoc.WezwijPomoc;
import java.util.Scanner;

public class Przejazd {

    private Parametry parametry;
    private static int kalkulatorPrzesiadek = 0;
    private static int i = 1;
    private static boolean sztucznaPetla = true;

    public Przejazd(Parametry parametry) {
        this.parametry = parametry;
    }

    public void planujPrzejazd() {
        if(kalkulatorPrzesiadek== 0) {
            Tramwaj tramwaj = new Tramwaj(parametry.getPasazer().getPrzystanekPoczatkowy(), parametry.getPasazer().getPrzystanekKoncowy());
            parametry.setTramwaj(tramwaj);
            //tramwaj = new Tramwaj(pasazer.getPrzystanekPoczatkowy(), pasazer.getPrzystanekKoncowy());
        }
        else {
            parametry.setTramwaj(new Tramwaj(parametry.getAktualnyPrzystanek(), parametry.getPasazer().getPrzystanekKoncowy()));
        }

        parametry.getTramwaj().poczatkowaPozycja();
        parametry.getTramwaj().koncowaPozycja();
        parametry.setTrasa(new Trasa(parametry.getMapa(), parametry.getTramwaj().getPozX(), parametry.getTramwaj().getPozKoncowaX(), parametry.getTramwaj().getPozY(), parametry.getTramwaj().getPozKoncowaY()));
        parametry.getRozkladMiasta().budowanieMapy();

        parametry.getTrasa().setDroga(parametry.getTrasa().wyborTrasy(parametry.getTrasa().getMapa()));
        parametry.getTrasa().zbudujPrzystanki(parametry.getTrasa().getDroga());
        //nowePrzystanki = null;
        parametry.setNowePrzystanki(parametry.getTrasa().getPrzystanki());
        parametry.setOpoznienie(new KalkulatorOpoznien());
        parametry.setWykolejenie(new KalkulatorWykolejen());
    }

    public void wykonaniePrzejazdu() {

        int pozostalePrzystanki;
        planujPrzejazd();
        parametry.getRozkladMiasta().wypiszMape();
        while (true) {
            przesiadka:
            while (sztucznaPetla) {
                System.out.println("\nRozpoczynasz jazde o: ");
                System.out.println("[" + parametry.getAktualnaGodzina() + "]");
                pozostalePrzystanki = -1;
                na:
                for (pozostalePrzystanki = parametry.getNowePrzystanki().size(); pozostalePrzystanki > 1; pozostalePrzystanki--, i++) {

                    stoper(2000);
                    parametry.getWykolejenie().obliczSzanseWykolejenia(parametry.getTramwaj(), parametry.getPogoda(), parametry.getMotorniczy(), parametry.getNowePrzystanki().get(i));
                    String wyborW;
                    String wyborP;
                    if (parametry.getWykolejenie().czyJestWykolejenie()) {

                        do {

                            System.out.println("Chcesz skorzystac z pomocy MPKWroclaw czy kontynuowac jazde autobusem?\nWpisz: MPKWROCLAW/AUTOBUS");
                            Scanner scan = new Scanner(System.in);
                            wyborW = scan.nextLine();
                            wyborW = wyborW.toUpperCase();
                            while (!Przejazd.containsW(wyborW)) {
                                System.out.println("Wybierz jedna z podanych opcji");
                                System.out.println("MPKWROCLAW/AUTOBUS");
                                wyborW = scan.nextLine();
                                wyborW = wyborW.toUpperCase();
                            }
                            TypyPomocy wybranaPomoc = TypyPomocy.valueOf(wyborW);
                            WezwijPomoc wezwijPomoc = new WezwijPomoc();
                            if (wybranaPomoc == TypyPomocy.MPKWROCLAW) {
                                wezwijPomoc.wzywaniePomocy(wezwijPomoc.getMPKWroclaw(), parametry.getNowePrzystanki().get(i).getPozX(), parametry.getNowePrzystanki().get(i).getPozY(), parametry);
                                break przesiadka;
                            } else if (wybranaPomoc == TypyPomocy.AUTOBUS) {
                                wezwijPomoc.wzywaniePomocy(wezwijPomoc.getAutobus(), parametry.getNowePrzystanki().get(i).getPozX(), parametry.getNowePrzystanki().get(i).getPozY(), parametry);
                                System.exit(0);
                            }
                            break na;

                        } while (!Przejazd.containsP(wyborP));


                    }

                    stoper(2000);
                    parametry.getOpoznienie().obliczSzanseOpoznienia(parametry.getMotorniczy(), parametry.getPogoda());
                    int czasOpoznienia = parametry.getOpoznienie().czyJestOpoznienie();
                    parametry.setAktualnaGodzina(czasOpoznienia);
                    if (czasOpoznienia > 5 && pozostalePrzystanki > 2) { //brak możliwości przesiadki na przedostatnim przystanku
                        Wybor czyZmianaTramwaju;
                        do {
                            if (parametry.getNowePrzystanki().get(i).getPozX() == parametry.getTramwaj().getPozKoncowaX() || parametry.getNowePrzystanki().get(i).getPozY() == parametry.getTramwaj().getPozKoncowaY()) {
                                break;
                            }
                            System.out.println("Czy chcesz zmienic tramwaj?\nTak/Nie");
                            Scanner scan = new Scanner(System.in);
                            wyborP = scan.nextLine();
                            wyborP = wyborP.toUpperCase();
                            while (!Przejazd.containsP(wyborP)) {
                                System.out.println("Wybierz jedna z podanych opcji");
                                System.out.println("TAK/NIE");
                                wyborP = scan.nextLine();
                                wyborP = wyborP.toUpperCase();
                            }
                            czyZmianaTramwaju = Wybor.valueOf(wyborP);
                            if (czyZmianaTramwaju == Wybor.TAK) {
                                parametry.setAktualnyPrzystanek(parametry.getNowePrzystanki().get(i).getNazwaPrzystanku());
                                kalkulatorPrzesiadek++;
                                System.out.println("Nastapila przesiadka, kontynuujesz jazde");
                                break przesiadka;
                            } else if (czyZmianaTramwaju == Wybor.NIE) {
                                break;
                            } else System.out.println("Prosze wybrac jedno z mozliwych rozwiazan");
                        } while (!Przejazd.containsP(wyborP));
                    }

                    stoper(2000);
                    parametry.setAktualnaGodzina(parametry.getNowePrzystanki().get(i).poinformujOPrzystanku());
                    System.out.print("Aktualna godzina ");
                    System.out.println("[" + parametry.getAktualnaGodzina() + "]");
                    System.out.print("\n");
                }
                sztucznaPetla = false;
                if (pozostalePrzystanki == 1) {
                    System.out.println("\nGratulacje!\nDojechales do przystanku koncowego!\nDziekujemy za wybranie lini MPK Wroclaw");
                }
                System.exit(0);
            }
        }
    }

    private void stoper(int ileMilisekund){
        try {
            Thread.sleep(ileMilisekund);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean containsW (String wyborW){
        for (TypyPomocy c : TypyPomocy.values()) {
            if (c.name().equals(wyborW)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsP (String wyborP){
        for (TypyPomocy c : TypyPomocy.values()) {
            if (c.name().equals(wyborP)) {
                return true;
            }
        }
        return false;
    }

    public void setParametry(Parametry parametry) {
        this.parametry = parametry;
    }

    public Parametry getParametry() {
        return parametry;
    }
}
