package Utrudnienia;

import ElementySymulacji.Motorniczy;
import ElementySymulacji.Pogoda;

public class KalkulatorOpoznien {
    private int szansaOpoznienia = 0;
    private int opoznienie = 0;
    //Co ma wpływ na opóźnienia: pogoda (int ryzyko), doswiadczenie i wiek motorniczego(int doswiadczenie, int wiek)
    //Zmienna szanszaOpoznienia przyjmuje wartosci od 0 do 100

    //Metoda obliczająca prawdopodobienstwo wystąpienia opoźnienia na podstawie doświadczenia, wieku motorniczego i warunków pogodowych
    public void obliczSzanseOpoznienia(Motorniczy motorniczy, Pogoda pogoda){

        //Przeliczanie szansy na wykolejenie ze względu na pogodę
        this.szansaOpoznienia = pogoda.getRyzyko() * 2 + RegulyOpoznien.regulaWiek(motorniczy.getWiek() + RegulyOpoznien.regulaDoswiadczenie(motorniczy.getDoswiadczenie()));
    }

    //Metoda stwierdzajaca czy opoznienie faktycznie wystapilo
    public int czyJestOpoznienie(){
        int losowy = (int) (Math.random() * 100) - 20;
        int opoznienie = 3;
        if(losowy <= szansaOpoznienia){
            for(int i = 0; i <= 90; i += 10){
                if(szansaOpoznienia >= i && szansaOpoznienia < i + 10)  break;
                opoznienie+=(Math.random() * 3);
            }
            System.out.println("Pojawilo sie opoznienie, wynosi: " + opoznienie + "minut(y)!");
            this.opoznienie = opoznienie;
            return opoznienie;
        }
        else {
            System.out.println("Brak opoznienia");
            return 0;
        }

    }




}
