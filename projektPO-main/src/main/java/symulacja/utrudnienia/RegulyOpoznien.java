package symulacja.utrudnienia;

public class RegulyOpoznien implements Regula {

    @Override
    public int regulaWiek(int wiek){
        if(wiek>=18 && wiek<=25) {return 4;}
        else if(wiek >=26 && wiek<=35){return 0;}
        else if(wiek >=36 && wiek<=45){return 4;}
        else if(wiek >=46 && wiek<=55){return 8;}
        else if(wiek >=56 && wiek<=65){return 12;}
        else if(wiek >=66 && wiek<=70){return 16;}
        else if(wiek >=71 && wiek<=75){return 20;}
        else return wiek;
    }

    @Override
    public int regulaDoswiadczenie(int doswiadczenie){
        if(doswiadczenie >=0 && doswiadczenie <=1){return 30;}
        else if(doswiadczenie>=2 && doswiadczenie<=3){return 24;}
        else if(doswiadczenie>=4 && doswiadczenie<=5){return 18;}
        else if(doswiadczenie>=6 && doswiadczenie<=9){return 14;}
        else if(doswiadczenie>=10 && doswiadczenie<=12){return 8;}
        else if(doswiadczenie>=13 && doswiadczenie<=18){return 4;}
        else if(doswiadczenie>=19){return 0;}
        else return doswiadczenie;

    }
}
