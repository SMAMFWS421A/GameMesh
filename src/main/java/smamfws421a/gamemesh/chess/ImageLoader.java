package smamfws421a.gamemesh.chess;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    public static String[] FigurW = new String[6]; //Bauer,Turm,Springer, Läufer, Dame, König
    public static String[] FigurB = new String[6];

    public ImageLoader(){
        for (int i = 0; i < 6; i++) {
            FigurB[i] = "src\\main\\resources\\chess\\b" + (i + 1) + ".png";
            FigurW[i] = "src\\main\\resources\\chess\\w" + (i + 1) + ".png";
        }
    }
}
