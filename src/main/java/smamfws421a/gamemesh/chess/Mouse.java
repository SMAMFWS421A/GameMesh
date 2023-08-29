package Chess.Game;


import java.awt.*;

public class Mouse {
    public static boolean InsideField;
    public static Point pos = new Point();

    public static Point ctp(Point p){
        Point point = new Point(0,0);
        point.x = (p.x - Gui.xfeld) / 100;
        point.y = (p.y - Gui.yfeld) / 100;
        return point;
    }

    public static Point ptc(Point p){
        Point point = new Point(0,0);
        point.x = (p.x * 100) + Gui.xfeld;
        point.y = (p.y * 100) + Gui.yfeld;
        return point;
    }

    public static boolean InsideField(int x,int y) {
        return (x > Gui.xfeld && x < Gui.xfeld + Gui.feldsize && y > Gui.yfeld && y < Gui.yfeld + Gui.feldsize);
    }
}
