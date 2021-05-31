import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Trasa implements LosoweLiczby {
    public int px;
    public int kx;
    public int py;
    public int ky;
    public String[][] mapa;
    public String[] droga;
    ArrayList<Przystanek> Przystanki = new ArrayList<>();

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
                    new FileReader("C:\\Users\\Dawid\\Desktop\\projektPO-main\\proojekt\\nowy.txt"));

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
                System.out.println("\nTrasa 1: ");

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
                System.out.println("\nTrasa 2: ");
                for (int i = 0; i < droga2.length - 1; i++) {
                    System.out.print(droga2[i] + " --> ");
                }

                System.out.println(droga2[droga2.length - 1]);
            }


            if(ilex!=0&&iley!=0){
                int wybor=0;
                do{
                System.out.println("\nChcesz jechać trasą 1 czy 2?"); //wybor trasy
                    Scanner scan = new Scanner(System.in);
                    wybor = scan.nextInt();
                if (wybor == 1) return droga1;
                else if(wybor == 2) return droga2;
                else //{String[] droga3 = {"Byq pisac nie umiesz? Wybierz 1 lub 2"};
                //return droga3;}
                    System.out.println("Co Ty robisz byq? 1 albo 2");
                }while(wybor!=1&&wybor!=2);
            }
            else if(iley==0) return droga1;
            else return droga2;
        }
        String[] pajac = new String[1];
        pajac[0]="Pajac";
        return pajac;
    }

    @Override
    public int random(){
        int randoom = (int) (Math.random() * 26);
        int StanTech = randoom;
//        System.out.println("Numer: " + numer);
        return StanTech;
    }

    public void ZbudujPrzystanki(String[] droga){
        int a=0;
        int pozx, pozy;
        int StanTech = random();
        int dlugosc=droga.length;
        while(dlugosc!=0){
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(droga[a]==mapa[i][j]){
                        pozx=i;
                        pozy=j;
                        Przystanki.add(new Przystanek(droga[a], pozx, pozy, StanTech));
                    }
                }
            }
            a++;
            dlugosc--;

        }
        //Przystanki.add(null);
    }

    public ArrayList<Przystanek> getPrzystanki() {
        return Przystanki;
    }


}