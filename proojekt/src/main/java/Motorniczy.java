import java.io.BufferedReader;
import java.io.FileReader;

public class Motorniczy implements LosoweLiczby{
    int numer;         //liczba porzadkowa przypisana motorniczemu
    int wiek;          //wiek motorniczego podany w latach
    int doswiadczenie; //doswiadczenie motorniczego podane w latach

    Motorniczy(){
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
                    new FileReader("C:\\Users\\maria\\IdeaProjects\\proojekt\\bazamotorniczych.txt"));

            String odczyt;
            String numerWStringu = String.valueOf(numer);

            while((odczyt=brr.readLine())!=null){

                if(odczyt.equals(numerWStringu)){
                    wiek = Integer.parseInt(brr.readLine());
                    doswiadczenie = Integer.parseInt(brr.readLine());
//                    System.out.println("Numer: " + numer + "\nWiek: " + wiek + "\nDoswiadczenie: " + doswiadczenie);
                    break;
                }
            }
            brr.close();
        } catch (Exception noFile) {
            //return 0;
        }
    }
}
