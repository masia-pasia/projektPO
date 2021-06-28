package symulacja.parametry;

import java.util.List;

import symulacja.OdczytZPliku;

public class Motorniczy{
    private int numerMotorniczego;         //liczba porzadkowa przypisana motorniczemu
    private int wiek;          //wiek motorniczego podany w latach
    private int doswiadczenie; //doswiadczenie motorniczego podane w latach
    private List parametryMotorniczego = List.of(numerMotorniczego, wiek, doswiadczenie);

    //Konstruktor klasy motorniczy
    public Motorniczy(){
       parametryMotorniczego = OdczytZPliku.czytanieMotorniczego();
    }

    public int getNumerMotorniczego() {
        return numerMotorniczego;
    }

    public int getWiek() {
        return wiek;
    }

    public int getDoswiadczenie() {
        return doswiadczenie;
    }
}
