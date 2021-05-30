public class Czas {

    int minuta=0, godzina=0;

    Czas(int minuta,int godzina){
        this.minuta=minuta;
        this.godzina=godzina;
    }

//    void przeliczCzas{
//
//
//
//    };

//    void pokazCzas{
//        System.out.println("Godzina:")
//    }

    static void stoper(int ileMiliSekund){
        try {
            Thread.sleep(ileMiliSekund);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
