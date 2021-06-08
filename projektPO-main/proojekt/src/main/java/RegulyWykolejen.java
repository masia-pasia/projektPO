public class RegulyWykolejen {

    public static int regulaWiek(int wiek){     //wiek motorniczego(0-10pkt)
        if(wiek>=18 && wiek<=25) {return 2;}
        else if(wiek >=26 && wiek<=35){return 0;}
        else if(wiek >=36 && wiek<=45){return 2;}
        else if(wiek >=46 && wiek<=55){return 4;}
        else if(wiek >=56 && wiek<=65){return 6;}
        else if(wiek >=66 && wiek<=70){return 8;}
        else if(wiek >=71 && wiek<=75){return 10;}
        else return wiek;
    }

    public static int regulaDoswiadczenie(int doswiadczenie){     //doswiadczenie motorniczego(0-15pkt)
        if(doswiadczenie >=0 && doswiadczenie <=1){return 15;}
        else if(doswiadczenie>=2 && doswiadczenie<=3){return 12;}
        else if(doswiadczenie>=4 && doswiadczenie<=5){return 9;}
        else if(doswiadczenie>=6 && doswiadczenie<=9){return 7;}
        else if(doswiadczenie>=10 && doswiadczenie<=12){return 4;}
        else if(doswiadczenie>=13 && doswiadczenie<=18){return 2;}
        else if(doswiadczenie>=19){return 0;}
        else return doswiadczenie;
    }
}
