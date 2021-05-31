public class KalkulatorOpoznien {
    public int szansaOpoznienia=0;
    public int opoznienie=0;
    //Co ma wpływ na opóźnienia: pogoda (int ryzyko), doswiadczenie i wiek motorniczego(int doswiadczenie, int wiek)
    //Zmienna szanszaOpoznienia przyjmuje wartosci od 0 do 100

    public void obliczSzanseOpoznienia(Motorniczy motorniczy, Pogoda pogoda){

        //Przeliczanie szansy na wykolejenie ze względu na pogodę
        int szansaOpoznienia=0;
        int ryzyko= (pogoda.ryzyko)*2;
        szansaOpoznienia+=ryzyko;

        //Obliczanie szansy na opoznienie ze wzgledu na wiek motorniczego
        if(motorniczy.wiek>=18 && motorniczy.wiek<=25){szansaOpoznienia+=4;}
        else if(motorniczy.wiek>=26 && motorniczy.wiek<=35){szansaOpoznienia+=0;}
        else if(motorniczy.wiek>=36 && motorniczy.wiek<=45){szansaOpoznienia+=4;}
        else if(motorniczy.wiek>=46 && motorniczy.wiek<=55){szansaOpoznienia+=8;}
        else if(motorniczy.wiek>=56 && motorniczy.wiek<=65){szansaOpoznienia+=12;}
        else if(motorniczy.wiek>=66 && motorniczy.wiek<=70){szansaOpoznienia+=16;}
        else if(motorniczy.wiek>=71 && motorniczy.wiek<=75){szansaOpoznienia+=20;}

        //Obliczanie szansy na opoznienie ze wzgledu na doswiadczenie motorniczego
        if(motorniczy.doswiadczenie >=0 && motorniczy.doswiadczenie <=1){szansaOpoznienia+=30;}
        else if(motorniczy.doswiadczenie>=2 && motorniczy.doswiadczenie<=3){szansaOpoznienia+=24;}
        else if(motorniczy.doswiadczenie>=4 && motorniczy.doswiadczenie<=5){szansaOpoznienia+=18;}
        else if(motorniczy.doswiadczenie>=6 && motorniczy.doswiadczenie<=9){szansaOpoznienia+=14;}
        else if(motorniczy.doswiadczenie>=10 && motorniczy.doswiadczenie<=12){szansaOpoznienia+=8;}
        else if(motorniczy.doswiadczenie>=13 && motorniczy.doswiadczenie<=18){szansaOpoznienia+=4;}
        else if(motorniczy.doswiadczenie>=19){szansaOpoznienia+=0;}

        this.szansaOpoznienia=szansaOpoznienia;
    }

    public int czyJestOpoznienie(){
        int randoom = (int) (Math.random() * 100);
        int opoznienie=3;
        if(randoom <= szansaOpoznienia){
            for(int i=0; i<=90; i+=10){
                if(szansaOpoznienia>=i && szansaOpoznienia<i+10)  break;
                opoznienie+=(Math.random() * 3);
            }
            System.out.println("Pojawilo sie opoznienie, wynosi: " + opoznienie + "minut!");
            this.opoznienie = opoznienie;
            return opoznienie;
        }
        else if(randoom > szansaOpoznienia){
            System.out.println("Brak opoznienia");
            return 0;
        }

        return opoznienie;
    }




}
