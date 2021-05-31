import java.io.BufferedReader;
import java.io.FileReader;

public class Pogoda implements LosoweLiczby {
    int numer;
    int ryzyko;
    String nazwa;

    Pogoda(){
        random();
        CzytanieZPliku();
    }


    @Override
    public int random(){
        int randoom = (int) (Math.random() * 4);
        numer = randoom;
//        System.out.println("Numer: " + numer);
        return numer;
    }
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
//                    System.out.println("Numer: " + numer + "\nRyzyko: " + ryzyko + "\nPogoda dzis: " + nazwa);
                    break;
                }
            }
            brr.close();
        } catch (Exception noFile) {
            //return 0;
        }
    }
}
