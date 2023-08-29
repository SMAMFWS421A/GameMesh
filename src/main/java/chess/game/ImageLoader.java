package chess.game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    public static BufferedImage[] FigurW = new BufferedImage[6]; //Bauer,Turm,Springer, Läufer, Dame, König
    public static BufferedImage[] FigurB = new BufferedImage[6];

    public ImageLoader(){
        try {
            for (int i = 0;i<6;i++){
                FigurB[i] = ImageIO.read(new File("res/chess/b" + (i + 1) + ".png"));
                FigurW[i] = ImageIO.read(new File("res/chess/w" + (i + 1) + ".png"));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
