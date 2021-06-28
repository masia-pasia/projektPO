package symulacja.pomoc;

//Można tutaj przenieść elementry kodu związane z wykolejeniem (z klasy Przejazd)

import symulacja.parametry.Parametry;


import java.time.LocalTime;


public class WezwijPomoc {

    private Pomoc autobus = new Autobus();
    private Pomoc mpkWroclaw = new MPKWroclaw();


    public void wzywaniePomocy(Pomoc pomoc, int x, int y, Parametry parametry){
        pomoc.przyzwanie(x,y);
        LocalTime czas = pomoc.getCzas();
        int ile = czas.getHour()*60;
        parametry.setAktualnaGodzina(czas.getMinute() + ile);
        System.out.print("Aktualna godzina ");
        System.out.println("[" + parametry.getAktualnaGodzina() + "]");
    }

    public Pomoc getAutobus() {
        return autobus;
    }

    public Pomoc getMPKWroclaw() {
        return mpkWroclaw;
    }
}

