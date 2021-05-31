public class Czas {

    int minuta;
    int godzina;

    Czas(int minuta,int godzina){
        this.minuta=minuta;
        this.godzina=godzina;
    }

    //Funkcja dodaje zadaną liczbę minut i godzin a następnie przelicza czas aby wyświetlał się w odpowiednim formacie
    public void przeliczCzas(int minute, int hour){
        godzina+=hour;
        minuta+=minute;
        while(minuta>=60 || godzina>=24){
            if(minuta>=60) {
                minuta-=60;
                godzina++;
            }
            if(godzina>=24) godzina-=24;
        }
    }

    public void wypiszCzas(){
        if(godzina>9 && minuta>9) { System.out.println("[" + godzina + ":" + minuta + "]"); }
        else if(godzina>9 && minuta<=9) { System.out.println("[" + godzina + ":0" + minuta + "]"); }
        else if(godzina<=9 && minuta>9) { System.out.println("[0" + godzina + ":" + minuta + "]"); }
        else if(godzina<=9 && minuta<=9) { System.out.println("[0" + godzina + ":0" + minuta + "]"); }
    }

    static void stoper(int ileMiliSekund){
        try {
            Thread.sleep(ileMiliSekund);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}