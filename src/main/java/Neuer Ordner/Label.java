package Chess.Game;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.Objects;

public class Label extends JLabel {
    Point p;

    @Serial
    private static final long serialVersionUID = 1L;

    protected void paintComponent (Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Background

        g.setColor(new Color(150, 183, 232));
        g.fillRect(0,0, Gui.Width, Gui.Height);

        //Spielfeld

        g.setColor(Color.BLACK);

        g.setColor(new Color(200,125,0));
        g.fillRect(Gui.xfeld,Gui.yfeld,Gui.feldsize,Gui.feldsize);
        g.setColor(Color.WHITE);
        for (int i = 0;i<16;i++) {
            g.fillRect(Gui.xfeld + (i / 4) * 200, Gui.yfeld + (i % 4) * 200,100,100);
            g.fillRect(Gui.xfeld + 100 + (i / 4) * 200, Gui.yfeld + 100 + (i % 4) * 200,100,100);
        }
        //Mouse
        if (Mouse.InsideField) {
            p = Mouse.ptc(Mouse.pos);
            g.setColor(new Color(153, 255, 102, 100));
            g.fillRect(p.x, p.y, 100, 100);
        }

        //Figuren und Kreise zeichnen
        for (int i = 0;i<8;i++){
            for (int j = 0;j<8;j++) {
                if (Feld.playingBoard[i][j] != null) {
                    if (Feld.playingBoard[i][j].getAllowed() && Feld.playingBoard[i][j].isOccupied()){
                        g.setColor(Color.RED);
                        g.drawImage(Feld.playingBoard[i][j].occupied.getImage(), (i + 5) * 100, (j + 1) * 100, 100, 100, null);
                        g.fillOval((i + 5) * 100 + 25,(j + 1) * 100 + 25,50,50);
                    }else if (Feld.playingBoard[i][j].isOccupied()) {
                            g.drawImage(Feld.playingBoard[i][j].occupied.getImage(), (i + 5) * 100, (j + 1) * 100, 100, 100, null);
                    }else if (Feld.playingBoard[i][j].getAllowed() &&!Feld.playingBoard[i][j].isOccupied()){
                        g.setColor(Color.GREEN);
                        g.fillOval((i + 5) * 100 + 25,(j + 1) * 100 + 25,50,50);
                    }
                }
            }
        }

        if (Feld.player){
            g.setColor(Color.WHITE);
            g.drawString("Player: White",300,100);
        }else {
            g.setColor(Color.WHITE);
            g.drawString("Player: Black",300,100);
        }
        repaint();
    }
}
