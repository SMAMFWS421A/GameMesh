package chess.game;

import java.awt.image.BufferedImage;

public class König extends Figur{
    private boolean color = false;
    boolean firstmove = true;

    public König(boolean color){
        this.color = color;
        this.firstmove = true;
    }

    @Override
    public boolean getColor() {
        return this.color;
    }

    @Override
    public BufferedImage getImage() {
        if (getColor()){
            return ImageLoader.FigurW[5];
        }else {
            return ImageLoader.FigurB[5];
        }
    }
    public void setFirstMove(boolean firstMove){
        this.firstmove = firstMove;
    }

    @Override
    public boolean[][] Bewegung(Feld feld) {
        boolean [][] allowedFields = this.initBewegArray(feld);
        int x = this.getCoordinate().x;
        int y = this.getCoordinate().y;
        int xcur;
        int ycur;
        int farbe = 0;

        if (this.color){
            farbe = 1;
        }

        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++){
                xcur = x + i;
                ycur = y + j;
                for (int a = 0; a < 8; a++){
                    for (int b = 0; b < 8;b++){
                        if (xcur >= 0 && xcur <= 7 && ycur >= 0 && ycur <= 7) {
                            allowedFields[xcur][ycur] = true;
                            if (Feld.playingBoard[xcur][ycur].getAttacked(farbe)[a][b]){
                                if (!Feld.playingBoard[xcur][ycur].isOccupied()) {
                                    allowedFields[xcur][ycur] = false;
                                } else if (Feld.playingBoard[xcur][ycur].getFigur().getColor() == this.color) {
                                    allowedFields[xcur][ycur] = false;
                                }
                            }
                        }
                    }
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
