public class Tramwaj implements LosoweLiczby {
    public final int stanTechTram;
    public int pozx;
    public int pozy;

    public Tramwaj(int stanTechTram, int pozx, int pozy){
        this.stanTechTram=stanTechTram;
        this.pozx=pozx;
        this.pozy=pozy;
    }

    public int random(){
        int randoom = (int) (Math.random() * 11);
        return randoom;
    };
}
