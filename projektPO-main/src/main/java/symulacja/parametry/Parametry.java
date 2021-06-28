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

public class Parametry {

    private LocalTime aktualnaGodzina;
    private Tramwaj tramwaj;
    private KalkulatorWykolejen wykolejenie;
    private KalkulatorOpoznien opoznienie;
    private Motorniczy motorniczy;
    private Pasazer pasazer;
    private Pogoda pogoda;
    private final String[][] rozkladMiasta = new String[9][9];



    private final Mapa mapa = new Mapa();
    private String aktualnyPrzystanek;
    private ArrayList<Przystanek> nowePrzystanki;
    private RozkladMiasta wroclaw;
    private Komunikacja komunikacja;
    private Trasa trasa;

    public Parametry(){
        motorniczy = new Motorniczy();
        pogoda = new Pogoda();
        wroclaw = new RozkladMiasta(rozkladMiasta);
        wroclaw.budowanieMapy();
        wroclaw.wypiszMape();
        pasazer = new Pasazer();
        komunikacja = new Komunikacja();
        komunikacja.pobraniePrzystankuPoczatkowego(pasazer);
        komunikacja.pobraniePrzystankuKoncowego(pasazer);
        komunikacja.pobranieGodziny(pasazer);
        aktualnaGodzina = pasazer.godzinaOdjazdu;
        aktualnyPrzystanek = null;
    }


    //Możliwe że część getterów trzeba będzie wywalić bo będą niepotrzebne
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

    public RozkladMiasta getWroclaw() { return wroclaw; }

    public Komunikacja getKomunikacja() { return komunikacja; }

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

    public void setMotorniczy(Motorniczy motorniczy) {
        this.motorniczy = motorniczy;
    }

    public void setPasazer(Pasazer pasazer) {
        this.pasazer = pasazer;
    }

    public void setPogoda(Pogoda pogoda) {
        this.pogoda = pogoda;
    }

    public void setAktualnyPrzystanek(String aktualnyPrzystanek) {
        this.aktualnyPrzystanek = aktualnyPrzystanek;
    }

    public void setNowePrzystanki(ArrayList<Przystanek> nowePrzystanki) {
        this.nowePrzystanki = nowePrzystanki;
    }

    public void setWroclaw(RozkladMiasta wroclaw) { this.wroclaw = wroclaw; }

    public void setKomunikacja(Komunikacja komunikacja) { this.komunikacja = komunikacja; }

    public void setTrasa(Trasa trasa) { this.trasa = trasa; }
}
