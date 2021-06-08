public class Czas {

    private int minuta;
    private int godzina;

    //Konstruktor formatu godzinowego
    Czas(int minuta,int godzina){
        this.minuta=minuta;
        this.setGodzina(godzina);
    }

    //Metoda dodaje zadaną liczbę minut i godzin a następnie przelicza czas aby wyświetlał się w odpowiednim formacie
    public void przeliczCzas(int minute, int hour){
        setGodzina(getGodzina() + hour);
        minuta = getMinuta() + minute;
        while(getMinuta() >=60 || getGodzina() >=24){
            if(getMinuta() >=60) {
                minuta = getMinuta() - 60;
                setGodzina(getGodzina() + 1);
            }
            if(getGodzina() >=24) setGodzina(getGodzina() - 24);
        }
    }

    //Metoda wypisująca czas w postaci zegara
    public void wypiszCzas(){
        if(getGodzina() >9 && getMinuta() >9) { System.out.println("[" + getGodzina() + ":" + getMinuta() + "]"); }
        else if(getGodzina() >9 && getMinuta() <=9) { System.out.println("[" + getGodzina() + ":0" + getMinuta() + "]"); }
        else if(getGodzina() <=9 && getMinuta() >9) { System.out.println("[0" + getGodzina() + ":" + getMinuta() + "]"); }
        else if(getGodzina() <=9 && getMinuta() <=9) { System.out.println("[0" + getGodzina() + ":0" + getMinuta() + "]"); }
    }

    //Metoda powodująca opoźnienie wyświetlania kolejnych akcji w terminalu
    static void stoper(int ileMiliSekund){
        try {
            Thread.sleep(ileMiliSekund);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getMinuta() {
        return minuta;
    }

    public int getGodzina() {
        return godzina;
    }

    public void setGodzina(int godzina) {
        this.godzina = godzina;
    }
}
