package chess.game;

public class main{
    public static void main(){
        new ImageLoader();
        Gui x = new Gui();
        x.create();
        Feld y = new Feld(8,8);
        y.reset();
    }
}
