package symulacja;

import symulacja.miasta.Mapa;
import symulacja.parametry.Parametry;
import symulacja.przejazd.Przejazd;

public class Main {

    public static void main(String[] args) {

        Parametry parametry = new Parametry();
        Przejazd przejazd = new Przejazd(parametry);
        /*
        Mapa apam = new Mapa();
        while(apam.mapa.hasNext()) {
            System.out.println(apam.mapa.next());
        }
        */

        while(true) {
            przejazd.wykonaniePrzejazdu();

        }
    }

}
