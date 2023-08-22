package Chess.Game;

public class main{
    public static void main(){
        new ImageLoader();
        Chess.Game.Gui x = new Gui();
        x.create();
        Chess.Game.Feld y = new Feld(8,8);
        y.reset();
    }
}
