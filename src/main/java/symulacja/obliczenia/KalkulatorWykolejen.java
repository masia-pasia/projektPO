package symulacja.obliczenia;

import symulacja.miasta.Przystanek;
import symulacja.parametry.Motorniczy;
import symulacja.parametry.Pogoda;
import symulacja.parametry.Tramwaj;
import symulacja.utrudnienia.RegulyWykolejen;

/**
 * Kalkulator wykolejen ktore moga miec miejsce w trakcie przejazdu.
 */
public class KalkulatorWykolejen {

    public int szansaWykolejenia;

    /**
     * Metoda obliczajaca prawdopodobienstwo wystapienia wykolejenia na podstawie warunkow pogodowych, doswiadczeia, wiku motorniczego, stanu technicznego tramwaju oraz torow przy przysyanku
     * @param tramwaj obiekt tramwaj
     * @param pogoda obiekt pogoda
     * @param motorniczy obiekt motorniczy
     * @param przystanek obiekt przystanek
     */
    public void obliczSzanseWykolejenia(Tramwaj tramwaj, Pogoda pogoda, Motorniczy motorniczy, Przystanek przystanek){
        RegulyWykolejen regulyWykolejen= new RegulyWykolejen();
        this.szansaWykolejenia = pogoda.getRyzyko() + przystanek.getStanTechnicznyPrzystanku() + tramwaj.getStanTechTramwaju() + regulyWykolejen.regulaWiek(motorniczy.getWiek()) + regulyWykolejen.regulaDoswiadczenie(motorniczy.getDoswiadczenie());
    }

    /**
     * Metoda sprawdzajaca czy wykolejenie wystapilo na danym odcinku trasy.
     * @return wykolejenie wystapilo lub nie
     */
    public boolean czyJestWykolejenie(){
        int losowy = (int) (Math.random() * 130) ;
        if (losowy <= szansaWykolejenia){
            System.out.println("Nastapilo wykolejenie tramwaju!");
            return true;
        }
        else {
            System.out.println("Brak wykolejenia");
            return false;
        }
    }
}
