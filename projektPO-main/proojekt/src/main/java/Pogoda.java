import java.io.BufferedReader;
import java.io.FileReader;

public class Pogoda implements LosoweLiczby {
    int numer;
    int ryzyko;
    String nazwa;

    //Konstruktor obiektu pogoda
    Pogoda(){
        random();
        CzytanieZPliku();
    }

    //Metoda implementujaca interfejs losowe liczby
    @Override
    public int random(){
        int randoom = (int) (Math.random() * 4);
        numer = randoom;
        return numer;
    }

    //Metoda odczytujaca dane z pliku bazapogod.txt
    public void CzytanieZPliku(){
        try {
            BufferedReader brr = new BufferedReader(
                    new FileReader("C:\\Users\\Dawid\\Desktop\\projektPO-main\\proojekt\\bazapogod.txt"));

            String odczyt;
            String numerWStringu = String.valueOf(numer);

            while((odczyt=brr.readLine())!=null){

                if(odczyt.equals(numerWStringu)){
                    ryzyko = Integer.parseInt(brr.readLine());
                    nazwa = brr.readLine();
                    System.out.println("Pogoda na dzis: " + nazwa);
                    break;
                }
            }
            brr.close();
        } catch (Exception noFile) {
            //return 0;
        }
    }
}
