package ObslugaSymulacji;

import java.io.*;

public class OdczytZPliku {

    public InputStream pobierzZPliku(String fileName) {
        ClassLoader zaladuj = getClass().getClassLoader();
        InputStream zawartosc = zaladuj.getResourceAsStream(fileName);
        if (zawartosc == null) {
            throw new IllegalArgumentException("Brak pliku: " + fileName);
        } else {
            return zawartosc;
        }
    }
}