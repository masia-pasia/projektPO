import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Trasa  {
    public int px;
    public int kx;
    public int py;
    public int ky;
    public String[][] mapa;
    public String[] droga;


    public Trasa(String[][] mapa, int px, int kx, int py, int ky){
        this.px = px;
        this.kx = kx;
        this.py = py;
        this.ky = ky;
        this.mapa = mapa;
    }

    public void BudowanieMapy() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\maria\\IdeaProjects\\proojekt\\nowy.txt"));

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    mapa[i][j] = br.readLine();
                }
            }
            br.close();
        } catch (Exception noFile) {
            //return 0;
        }
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(mapa[i][j]+ " ");
//            }
//            System.out.print("\n");
//        }
    }

    public String[] JakaTrasaByq(String[][] mapa) {
        //        System.out.println(px + kx + py + ky);
        //ile przejedzie na osi x i y
        int ilex = kx - px;
        int iley = ky - py;
        int ilePrzystankow; //dlugosc trasy
        if (ilex < 0) {
            if (iley < 0) {
                ilePrzystankow = -ilex - iley;
            } else {
                ilePrzystankow = -ilex + iley;
            }
        } else if (iley < 0) {
            ilePrzystankow = ilex - iley;
        } else {
            ilePrzystankow = ilex + iley;
        }
        String[] droga1 = new String[ilePrzystankow + 1]; //dwie mozliwe drogi
        String[] droga2 = new String[ilePrzystankow + 1];

        if (ilex==0 && iley==0) {
            System.out.println("Ty sie w caban jebnij pajacu"); //wyjatek jesli poczatkowy=koncowy
            String[] pajac = new String[1];
            pajac[0]="Pajac";
            return pajac;
        } else {
            int poz;
            droga1[0] = mapa[py][px];
            droga2[0] = mapa[py][px];

            if(ilex!=0) {//pierwsza trasa
                poz = 1;
                if (ilex > 0) {
                    for (int i = 1; i <= ilex; i++) {
                        droga1[poz] = mapa[py][px + i];
                        poz++;
                    }
                } else {
                    for (int i = 1; i <= -ilex; i++) {
                        droga1[poz] = mapa[py][px - i];
                        poz++;
                    }
                }
                if (iley > 0) {
                    for (int i = 1; i <= iley; i++) {
                        droga1[poz] = mapa[py + i][kx];
                        poz++;
                    }
                } else {
                    for (int i = 1; i <= -iley; i++) {
                        droga1[poz] = mapa[py - i][kx];
                        poz++;
                    }
                }
                for (int i = 0; i < droga1.length - 1; i++) { //wypisanie tras
                    System.out.print(droga1[i] + " --> ");
                }
            }

            if(iley!=0) {//druga trasa
                poz = 1;
                if (iley > 0) {
                    for (int i = 1; i <= iley; i++) {
                        droga2[poz] = mapa[py + i][px];
                        poz++;
                    }
                } else {
                    for (int i = 1; i <= -iley; i++) {
                        droga2[poz] = mapa[py - i][px];
                        poz++;
                    }
                }
                if (ilex > 0) {
                    for (int i = 1; i <= ilex; i++) {
                        droga2[poz] = mapa[ky][px + i];
                        poz++;
                    }
                } else {
                    for (int i = 1; i <= -ilex; i++) {
                        droga2[poz] = mapa[ky][px - i];
                        poz++;
                    }
                }
                System.out.println(droga1[droga1.length - 1]);
                for (int i = 0; i < droga2.length - 1; i++) {
                    System.out.print(droga2[i] + " --> ");
                }
                System.out.println(droga2[droga2.length - 1]);
            }


            if(ilex!=0&&iley!=0){
                System.out.println("Chcesz jechać trasą 1 czy 2"); //wybor trasy
                Scanner scan = new Scanner(System.in);
                int wybor = scan.nextInt();
                if (wybor == 1) return droga1;
                else return droga2;
            }
            else if(iley==0) return droga1;
            else return droga2;
        }
    }
}