package symulacja;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Odczytywanie danych z plikow umieszczonych w folderze resources.
 */
public class OdczytZPliku {

    /**
     * Metoda pobierajaca dane z pliku
     * @param nazwaPliku nazwa pliku
     * @return zawartosc pliku
     */
    public InputStream pobierzZPliku(String nazwaPliku) {
        ClassLoader zaladuj = getClass().getClassLoader();
        InputStream zawartosc = zaladuj.getResourceAsStream(nazwaPliku);
        if (zawartosc == null) {
            throw new IllegalArgumentException("Brak pliku: " + nazwaPliku);
        } else {
            return zawartosc;
        }
    }

    /**
     * Metoda odczytujaca dane z bazy motorniczych
     * @return lista motorniczych
     */
    public static List<Integer> czytanieMotorniczego(){
        int numerMotorniczego;
        int wiek=0;
        int doswiadczenie = 0;
        String line;
        OdczytZPliku plik = new OdczytZPliku();
        InputStream zawartosc = plik.pobierzZPliku("bazamotorniczych.txt");
        String numerWStringu = String.valueOf( numerMotorniczego = (int) (Math.random() * 4));
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)) {
            while ((line = czytaj.readLine()) != null) {
                if (line.equals(numerWStringu)) {
                    wiek = Integer.parseInt(czytaj.readLine());
                    doswiadczenie = Integer.parseInt(czytaj.readLine());
                    break;
                }
                else{
                    for (int i = 0; i < 2; i++) {
                        line = czytaj.readLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of(numerMotorniczego, wiek, doswiadczenie);
    }

    /**
     * Metoda odczytujaca dane z bazy pogod
     * @return lista pogod
     */
    public static List<Object> czytaniePogody(){
        Object[] elementyPogody = new Object[3];
        elementyPogody[0]=0;
        elementyPogody[1]=0;
        elementyPogody[2]=null;
        String line;
        OdczytZPliku plik = new OdczytZPliku();
        InputStream zawartosc = plik.pobierzZPliku("bazapogod.txt");
        try (InputStreamReader odczyt = new InputStreamReader(zawartosc, StandardCharsets.UTF_8);
             BufferedReader czytaj = new BufferedReader(odczyt)) {
            String numerWStringu = String.valueOf(elementyPogody[0] = (int) (Math.random() * 4));
            while ((line = czytaj.readLine()) != null){
                if (line.equals(numerWStringu)){
                    elementyPogody[1] = Integer.parseInt(czytaj.readLine());
                    elementyPogody[2] = czytaj.readLine();
                    System.out.println("\nPogoda na dzis: " + elementyPogody[2]);
                    break;
                }
                else {
                    for (int i = 0; i < 2; i++) {
                        line = czytaj.readLine();
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return List.of(elementyPogody);
    }
}