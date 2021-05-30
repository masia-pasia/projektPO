public class Przystanek{
    public String name;
    public int pozx;
    public int pozy;
    public int stanTech;
    public String[] droga;


    public Przystanek(String name, int pozx, int pozy, int stanTech) {
        this.name = name;
        this.pozx = pozx;
        this.pozy = pozy;
        this.stanTech = stanTech;
    }

    public void PoinformujOPrzystanku(){
        System.out.println("Dojechales/as do przystanku " + name + "!" );
    }
}
