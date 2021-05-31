import java.io.BufferedReader;
import java.io.FileReader;

public class Motorniczy implements LosoweLiczby{
    int numer;         //liczba porzadkowa przypisana motorniczemu
    int wiek;          //wiek motorniczego podany w latach
    int doswiadczenie; //doswiadczenie motorniczego podane w latach

    //Konstruktor klasy motorniczy
    Motorniczy(){
        random();
        CzytanieZPliku();
    }

    //Metoda implementujaca liczby losowe
    @Override
    public int random(){
        int randoom = (int) (Math.random() * 4);
        numer = randoom;
        return numer;
    }

    //Metoda odczytujaca dane z pliku bazamotorniczych.txt
    public void CzytanieZPliku(){
        try {
            BufferedReader brr = new BufferedReader(
                    new FileReader("C:\\Users\\Dawid\\Desktop\\projektPO-main\\proojekt\\bazamotorniczych.txt"));

            String odczyt;
            String numerWStringu = String.valueOf(numer);

            while((odczyt=brr.readLine())!=null){

                if(odczyt.equals(numerWStringu)){
                    wiek = Integer.parseInt(brr.readLine());
                    doswiadczenie = Integer.parseInt(brr.readLine());
                    break;
                }
            }
            brr.close();
        } catch (Exception noFile) {
            //return 0;
        }
    }
}
