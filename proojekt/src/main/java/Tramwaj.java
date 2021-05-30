import java.io.BufferedReader;
import java.io.FileReader;

public class Tramwaj implements LosoweLiczby, Pozycja {
    public int stanTechTram;
    private int pozx=0;
    private int pozy=0;
    private int pozxk=0;
    private int pozyk=0;
    public String poczatkowy;
    public String koncowy;

    public Tramwaj(String poczatkowy, String koncowy){
        random();
        this.poczatkowy=poczatkowy;
        this.koncowy=koncowy;
    }

    @Override
    public int random(){
        int randoom = (int) (Math.random() * 26);
        stanTechTram = randoom;
        return randoom;
    };


    @Override
    public void PoczatkowaPozycja(){
        int a=0;
        try {
            BufferedReader brr = new BufferedReader(
                    new FileReader("C:\\Users\\maria\\IdeaProjects\\proojekt\\nowy.txt"));

            String odczyt;

            while((odczyt=brr.readLine())!=null){

                if(odczyt.equals(poczatkowy)){
                    //System.out.println("Dobrze byq " + a);
                    break;
                }
                else {
                    a++;
                }
            }
            brr.close();
        } catch (Exception noFile) {
            //return 0;
        }
        while(a>4){
            pozy++;
            a-=5;
            pozx=a;
        }
        if(a<=4){pozx=a;};
//        System.out.println("Pozycja x: " + pozx + "\nPozycja y: " + pozy);
    }

    @Override
    public void KoncowaPozycja(){
        int a=0;
        try {
            BufferedReader brr = new BufferedReader(
                    new FileReader("C:\\Users\\maria\\IdeaProjects\\proojekt\\nowy.txt"));

            String odczyt;

            while((odczyt=brr.readLine())!=null){

                if(odczyt.equals(koncowy)){
                    //System.out.println("Dobrze byq " + a);
                    break;
                }
                else {
                    a++;
                }
            }
            brr.close();
        } catch (Exception noFile) {
            //return 0;
        }
        while(a>4){
            pozyk++;
            a-=5;
            pozxk=a;
        }
        if(a<=4){pozxk=a;};
//        System.out.println("Pozycja xk: " + pozxk + "\nPozycja yk: " + pozyk);
    }

   //gettery
    public int getPozx() {
        return pozx;
    };

    public int getPozy() {
        return pozy;
    };

    public int getPozxk() {
        return pozxk;
    };

    public int getPozyk() {
        return pozyk;
    };

}
