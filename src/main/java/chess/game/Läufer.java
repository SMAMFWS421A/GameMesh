package chess.game;

import java.awt.image.BufferedImage;

public class Läufer extends Figur{
    private boolean color = false;

    public Läufer(boolean color){
        this.color = color;
    }

    @Override
    public BufferedImage getImage() {
        if (getColor()){
            return ImageLoader.FigurW[3];
        }else {
            return ImageLoader.FigurB[3];
        }
    }

    @Override
    public boolean getColor() {
        return this.color;
    }
    public boolean[][] Bewegung(Feld feld) {
        boolean[][] allowedFields = this.initBewegArray(feld);
        int x = this.getCoordinate().x;
        int y = this.getCoordinate().y;
        int xcur;
        int ycur;

        for (int i = -1; i <= 1; i = i + 2) {
            for (int j = -1; j <= 1; j += 2){
                xcur = x + i;
                ycur = y + j;
                while (xcur >= 0 && xcur <= 7 && ycur >= 0 && ycur <= 7 && !(Feld.playingBoard[xcur][ycur].isOccupied())){
                    allowedFields[xcur][ycur] = true;
                    xcur = xcur + i;
                    ycur = ycur + j;
                }
                if (xcur >= 0 && xcur <= 7 && ycur >= 0 && ycur <= 7 && Feld.playingBoard[xcur][ycur].getFigur().getColor() != this.color) {
                    allowedFields[xcur][ycur] = true;
                }
            }
        }

        return allowedFields;
    }

    @Override
    public boolean[][] Attack(Feld feld, int x, int y) {
        return this.Bewegung(feld);
    }
}
