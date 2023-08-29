package smamfws421a.gamemesh.components;

import com.vaadin.flow.theme.lumo.LumoUtility;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.vaadin.pekkam.Canvas;
import org.vaadin.pekkam.CanvasRenderingContext2D;
import smamfws421a.gamemesh.chess.Feld;
import smamfws421a.gamemesh.chess.Gui;
import smamfws421a.gamemesh.chess.ImageLoader;

import java.awt.*;

@Getter
@Component
public class ChessComponent {

    private final Canvas canvas;

    public ChessComponent() {

        int height = 800;
        int width = 1800;
        new ImageLoader();
        Feld feld = new Feld(8, 8);
        feld.reset();

        this.canvas = new Canvas(width, height);


        CanvasRenderingContext2D ctx = canvas.getContext();



        ctx.setFillStyle("brown");
        ctx.fillRect((double) (width - 720) / 2, (double) (height - 720) / 2, 720, 720);
        ctx.setFillStyle("beige");
        for (int i = 0;i<16;i++) {
            ctx.fillRect((double) (width - 720) / 2 + (i / 4) * 180, (double) (height - 720) / 2 + (i % 4) * 180,90,90);
            ctx.fillRect((double) (width - 720) / 2 + 90 + (i / 4) * 180, (double) (height - 720) / 2 + 90 + (i % 4) * 180,90,90);
        }




        for (int i = 0;i<8;i++){
            for (int j = 0;j<8;j++) {
                if (Feld.playingBoard[i][j] != null) {
                    if (Feld.playingBoard[i][j].getAllowed() && Feld.playingBoard[i][j].isOccupied()){
                        ctx.setFillStyle("red");
                        ctx.drawImage(Feld.playingBoard[i][j].occupied.getImage(), (i + 5) * 100, (j + 1) * 100, 100, 100);
                        ctx.arc((i + 5) * 100 + 25,(j + 1) * 100 + 25,50,0, 0, false);
                    }else if (Feld.playingBoard[i][j].isOccupied()) {
                        ctx.drawImage(Feld.playingBoard[i][j].occupied.getImage(), (i + 5) * 100, (j + 1) * 100, 100, 100);
                    }else if (Feld.playingBoard[i][j].getAllowed() &&!Feld.playingBoard[i][j].isOccupied()){
                        ctx.setFillStyle("green");
                        ctx.arc((i + 5) * 100 + 25,(j + 1) * 100 + 25,50,0, 0, false);
                    }
                }
            }
        }
    }
}
