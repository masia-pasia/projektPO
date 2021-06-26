package Utrudnienia;

import ElementyMiasta.Przystanek;
import ElementySymulacji.Motorniczy;
import ElementySymulacji.Pogoda;
import ElementySymulacji.Tramwaj;

public class KalkulatorWykolejen {

    public int szansaWykolejenia;

    //Co ma wpływ na wykolejenia: pogoda (int pogoda), wiek i doswiadczenie motorniczego (int wiek, int doswiadczenie),
    //                            stan techniczny tramwaju (stanTechTramwaju), stan techniczny torow (stanTechnicznyPrzystanku)
    //zmienna szansaWykolejenia przyjumje wartosci od 0 do 100

    //Metoda obliczajaca prawdopodobienstwo wystapienia wykolejenia na podstawie warunkow pogodowych, doswiadczeia, wiku motorniczego, stanu technicznego tramwaju oraz torow przy przysyanku
    public void obliczSzanseWykolejenia(Tramwaj tramwaj, Pogoda pogoda, Motorniczy motorniczy, Przystanek przystanek){

        //kazdy z parametrów: ryzyko, stanTechnicznyPrzystanku i stanTechTramwaju skaluje się do maks. 25pkt
        this.szansaWykolejenia = pogoda.getRyzyko() + przystanek.getStanTechnicznyPrzystanku() + tramwaj.getStanTechTramwaju() + RegulyWykolejen.regulaWiek(motorniczy.getWiek()) + RegulyWykolejen.regulaDoswiadczenie(motorniczy.getDoswiadczenie());
    }

    //Metoda stwierdzajaca czy faktycznie wystapilo wykolejenie
    public boolean czyJestWykolejenie(){
        int losowy = (int) (Math.random() * 100)+20;
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