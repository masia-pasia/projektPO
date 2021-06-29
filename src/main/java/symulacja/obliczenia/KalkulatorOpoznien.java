package symulacja.obliczenia;

import symulacja.parametry.Motorniczy;
import symulacja.parametry.Pogoda;
import symulacja.utrudnienia.RegulyOpoznien;

/**
 * Kalkulator opoznienien ktore moga wystapic w trakcie przejazdu.
 */
public class KalkulatorOpoznien {

    private int opoznienie = 3;
    private int szansaOpoznienia = 0;

    /**
     * Metoda obliczająca prawdopodobienstwo wystąpienia opoźnienia na podstawie doświadczenia, wieku motorniczego i warunków pogodowych.
     * @param motorniczy obiekt motorniczy
     * @param pogoda obiekt pogoda
     */
    public void obliczSzanseOpoznienia(Motorniczy motorniczy, Pogoda pogoda){
        RegulyOpoznien regulyOpoznien = new RegulyOpoznien();
        this.szansaOpoznienia = pogoda.getRyzyko() * 2 + regulyOpoznien.regulaWiek(motorniczy.getWiek()) + regulyOpoznien.regulaDoswiadczenie(motorniczy.getDoswiadczenie());
    }

    /**
     * Metoda sprawdzajaca czy opoznienie wystapilo na danym odcinku trasy.
     * @return dlugosc opoznienia
     */
    public int czyJestOpoznienie(){
        int losowy = (int) (Math.random() * 100);
        if(losowy <= szansaOpoznienia){
            for(int i = 0; i <= 90; i += 10) {
                if (szansaOpoznienia >= i && szansaOpoznienia < (i + 10)) {
                    break;
                }
                else {
                    this.opoznienie += (Math.random() * 3);
                }
            }
            System.out.println("Pojawilo sie opoznienie, wynosi: " + opoznienie + "minut(y)!");
            return opoznienie;
        }
        else {
            System.out.println("Brak opoznienia");
            return 0;
        }

    }
}
