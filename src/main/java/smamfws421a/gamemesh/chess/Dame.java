package Chess.Game;

import java.awt.image.BufferedImage;

public class Dame extends Figur{
    private boolean color = false;

    public Dame(boolean color){
        this.color = color;
    }

    @Override
    public boolean getColor() {
        return this.color;
    }

    @Override
    public BufferedImage getImage() {
        if (getColor()){
            return ImageLoader.FigurW[4];
        }else {
            return ImageLoader.FigurB[4];
        }
    }

    @Override
    public boolean[][] Bewegung(Feld feld) {
        boolean[][]allowedFields = this.initBewegArray(feld);
        int x = this.getCoordinate().x;
        int y = this.getCoordinate().y;
        int xcur;
        int ycur;
        for(int i = -1; i <= 1; i=i+2){
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
            ycur = y + i;
            xcur = x + i;
            while(xcur >= 0 && xcur <= 7 && !(feld.playingBoard[xcur][y].isOccupied()))
            {
                allowedFields[xcur][y] = true;
                xcur = xcur + i;
            }
            while(ycur >= 0 && ycur <= 7 && !(feld.playingBoard[x][ycur].isOccupied()))
            {
                allowedFields[x][ycur] = true;
                ycur = ycur + i;
            }
            if(ycur >= 0 && ycur <= 7 && feld.playingBoard[x][ycur].getFigur().getColor() != this.color)
            {
                allowedFields[x][ycur] = true;
            }
            if(xcur >= 0 && xcur <= 7 && feld.playingBoard[xcur][y].getFigur().getColor() != this.color)
            {
                allowedFields[xcur][y] = true;
            }
        }
        return allowedFields;
    }

    @Override
    public boolean[][] Attack(Feld feld, int x, int y) {
        return this.Bewegung(feld);
    }
}
