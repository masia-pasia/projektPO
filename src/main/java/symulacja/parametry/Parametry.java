package symulacja.parametry;

import symulacja.miasta.Przystanek;
import symulacja.miasta.RozkladMiasta;
import symulacja.miasta.Trasa;
import symulacja.przejazd.Komunikacja;
import symulacja.przejazd.Pasazer;
import symulacja.obliczenia.KalkulatorOpoznien;
import symulacja.obliczenia.KalkulatorWykolejen;
import symulacja.miasta.Mapa;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Parametry symulacji.
 */
public class Parametry {

    private LocalTime aktualnaGodzina;
    private Tramwaj tramwaj;
    private KalkulatorWykolejen wykolejenie;
    private KalkulatorOpoznien opoznienie;
    private final Motorniczy motorniczy;
    private final Pasazer pasazer;
    private final Pogoda pogoda;
    private final Mapa mapa = new Mapa();
    private String aktualnyPrzystanek;
    private ArrayList<Przystanek> nowePrzystanki;
    private final RozkladMiasta wroclaw;
    private Trasa trasa;

    /**
     * Konstruktor ustawia parametry symulacji.
     */
    public Parametry(){
        motorniczy = new Motorniczy();
        pogoda = new Pogoda();
        String[][] rozkladMiasta = new String[9][9];
        wroclaw = new RozkladMiasta(rozkladMiasta);
        wroclaw.budowanieMapy();
        wroclaw.wypiszMape();
        pasazer = new Pasazer();
        Komunikacja komunikacja = new Komunikacja();
        komunikacja.pobraniePrzystankuPoczatkowego(pasazer);
        komunikacja.pobraniePrzystankuKoncowego(pasazer);
        komunikacja.pobranieGodziny(pasazer);
        aktualnaGodzina = pasazer.godzinaOdjazdu;
        aktualnyPrzystanek = pasazer.getPrzystanekPoczatkowy();
    }

    public LocalTime getAktualnaGodzina() {
        return aktualnaGodzina;
    }

    public Tramwaj getTramwaj() { return tramwaj; }

    public KalkulatorWykolejen getWykolejenie() {
        return wykolejenie;
    }

    public KalkulatorOpoznien getOpoznienie() {
        return opoznienie;
    }

    public Motorniczy getMotorniczy() {
        return motorniczy;
    }

    public Pasazer getPasazer() {
        return pasazer;
    }

    public Pogoda getPogoda() {
        return pogoda;
    }

    public RozkladMiasta getRozkladMiasta() {
        return wroclaw;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public String getAktualnyPrzystanek() {
        return aktualnyPrzystanek;
    }

    public ArrayList<Przystanek> getNowePrzystanki() {
        return nowePrzystanki;
    }

    public Trasa getTrasa() { return trasa; }


    public void setAktualnaGodzina(int aktualnaGodzina) { this.aktualnaGodzina = this.aktualnaGodzina.plusMinutes(aktualnaGodzina); }

    public void setTramwaj(Tramwaj tramwaj) {
        this.tramwaj = tramwaj;
    }

    public void setWykolejenie(KalkulatorWykolejen wykolejenie) {
        this.wykolejenie = wykolejenie;
    }

    public void setOpoznienie(KalkulatorOpoznien opoznienie) {
        this.opoznienie = opoznienie;
    }


    public void setAktualnyPrzystanek(String aktualnyPrzystanek) {
        this.aktualnyPrzystanek = aktualnyPrzystanek;
    }

    public void setNowePrzystanki(ArrayList<Przystanek> nowePrzystanki) {
        this.nowePrzystanki = nowePrzystanki;
    }


    public void setTrasa(Trasa trasa) { this.trasa = trasa; }
}
