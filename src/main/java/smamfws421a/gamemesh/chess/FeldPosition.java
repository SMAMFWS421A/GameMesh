package smamfws421a.gamemesh.chess;

public class FeldPosition {

    public int x,y;
    public String name;

    public FeldPosition (int x, int y){
        this.x = x;
        this.y = y;
        this.name = PoszuName(this.x,this.y);
    }
    public String PoszuName(int x, int y){
        String name;
        char xlabel = (char)(x+(int)'A');
        char ylabel = (char)(y+(int)'1');
        return name = (xlabel + " " + ylabel);
    }
}
