package Chess.Game;


import java.awt.*;

public class Mouse {
    public static boolean InsideField;
    public static Point pos = new Point();

    public static Point ctp(Point p){
        Point point = new Point(0,0);
        point.x = (p.x - Chess.Game.Gui.xfeld) / 100;
        point.y = (p.y - Chess.Game.Gui.yfeld) / 100;
        return point;
    }

    public static Point ptc(Point p){
        Point point = new Point(0,0);
        point.x = (p.x * 100) + Chess.Game.Gui.xfeld;
        point.y = (p.y * 100) + Chess.Game.Gui.yfeld;
        return point;
    }

    public static boolean InsideField(int x,int y) {
        return (x > Chess.Game.Gui.xfeld && x < Chess.Game.Gui.xfeld + Chess.Game.Gui.feldsize && y > Chess.Game.Gui.yfeld && y < Chess.Game.Gui.yfeld + Gui.feldsize);
    }
}
