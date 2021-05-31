import java.io.BufferedReader;
import java.io.FileReader;

public class RozkladMiasta {
    public String[][] plansza;

    //Metoda budujaca obraz mapy miasta na podstawie przystankow z pliku bazaprzystankow.txt
    public void BudowanieMapy() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\Dawid\\Desktop\\projektPO-main\\proojekt\\bazaprzystankow.txt"));

            for (int i = 0; i < 9; i += 2) {
                for (int j = 0; j < 9; j += 2) {
                    plansza[i][j] = br.readLine();
                }
            }
            br.close();
        } catch (Exception noFile) {
            //return 0;
        }
        for (int i = 1; i < 9; i += 2) {
            for (int j = 0; j < 9; j += 2) {
                plansza[i][j] = "|";
            }
        }

        for (int i = 0; i < 9; i += 2) {
            for (int j = 1; j < 9; j += 2) {
                plansza[i][j] = "---";
            }
        }

        for (int i = 1; i < 9; i += 2) {
            for (int j = 1; j < 9; j += 2) {
                plansza[i][j] = "   ";
            }
        }

        plansza[1][1]="MPK";
        plansza[7][5]="AUT";

        System.out.println("Mapa miasta");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(plansza[i][j]);
            }
            System.out.print("\n");
        }
    }

    //getter
    public RozkladMiasta(String[][] plansza) {
        this.plansza = plansza;
    }
}