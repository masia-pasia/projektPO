public class KalkulatorWykolejen {

    public int szansaWykolejenia;

    //Co ma wpływ na wykolejenia: pogoda (int pogoda), wiek i doswiadczenie motorniczego (int wiek, int doswiadczenie),
    //                            stan techniczny tramwaju (stanTechTram), stan techniczny torow (stanTech)
    //zmienna szansaWykolejenia przyjumje wartosci od 0 do 100

    void obliczSzanseWykolejenia(Tramwaj tramwaj, Pogoda pogoda, Motorniczy motorniczy, Przystanek przystanek){

        //kazdy z parametrów: ryzyko, stanTech i stanTechTram skaluje się do maks. 25pkt
        int szansaWykolejenia=(pogoda.ryzyko)+(przystanek.stanTech)+(tramwaj.stanTechTram);
        //Obliczanie szansy na wykolejenie ze wzgledu na wiek matorniczego
        if(motorniczy.wiek>=18 && motorniczy.wiek<=25) {szansaWykolejenia+=2;}       //wiek motorniczego(0-10pkt)
        else if(motorniczy.wiek >=26 && motorniczy.wiek<=35){szansaWykolejenia+=0;}  //doswiadczenie motorniczego(0-15pkt)
        else if(motorniczy.wiek >=36 && motorniczy.wiek<=45){szansaWykolejenia+=2;}
        else if(motorniczy.wiek >=46 && motorniczy.wiek<=55){szansaWykolejenia+=4;}
        else if(motorniczy.wiek >=56 && motorniczy.wiek<=65){szansaWykolejenia+=6;}
        else if(motorniczy.wiek >=66 && motorniczy.wiek<=70){szansaWykolejenia+=8;}
        else if(motorniczy.wiek >=71 && motorniczy.wiek<=75){szansaWykolejenia+=10;}

        //Obliczanie szansy na wykolejenie ze wzgledu na doswiadczenie motorniczego
        if(motorniczy.doswiadczenie >=0 && motorniczy.doswiadczenie <=1){szansaWykolejenia+=15;}
        else if(motorniczy.doswiadczenie>=2 && motorniczy.doswiadczenie<=3){szansaWykolejenia+=12;}
        else if(motorniczy.doswiadczenie>=4 && motorniczy.doswiadczenie<=5){szansaWykolejenia+=9;}
        else if(motorniczy.doswiadczenie>=6 && motorniczy.doswiadczenie<=9){szansaWykolejenia+=7;}
        else if(motorniczy.doswiadczenie>=10 && motorniczy.doswiadczenie<=12){szansaWykolejenia+=4;}
        else if(motorniczy.doswiadczenie>=13 && motorniczy.doswiadczenie<=18){szansaWykolejenia+=2;}
        else if(motorniczy.doswiadczenie>=19){szansaWykolejenia+=0;}

        this.szansaWykolejenia=szansaWykolejenia;
    }


    boolean czyJestWykolejenie(){
        int randoom = (int) (Math.random() * 100);
        if(randoom <= szansaWykolejenia){
                System.out.println("Nastapilo wykolejenie tramwaju!");
                return true;
        }
        else if(randoom > szansaWykolejenia){
                System.out.println("Brak wykolejenia");
                return false;
        }

        return false;
    }



}
