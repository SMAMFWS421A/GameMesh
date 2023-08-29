package chess.game;

import java.awt.image.BufferedImage;

public class Bauer extends Figur {
    private boolean color = false;

    public Bauer(boolean color){
        this.color = color;
    }

    @Override
    public BufferedImage getImage() {
        if (getColor()){
            return ImageLoader.FigurW[0];
        }else {
            return ImageLoader.FigurB[0];
        }
    }

    public boolean getColor(){
        return this.color;
    }

    public boolean[][] Bewegung(Feld feld){
        boolean [][] allowedFields = this.initBewegArray(feld);
        int x = this.getCoordinate().x;
        int y = this.getCoordinate().y;
        int yoff = 1;
        int startposition = 1;

        if(this.color){
            yoff = -1;
            startposition = 6;
        }
            if (!(feld.playingBoard[x][y + yoff].isOccupied())) {
                allowedFields[x][y + yoff] = true;
                if (startposition == y) {
                    if (!(feld.playingBoard[x][y + (2 * yoff)].isOccupied())) {
                        allowedFields[x][y + (2 * yoff)] = true;
                    }
                }
            }

            for (int i = -1; i <= 1; i = i + 2) {
                if (x + i >= 0 && x + i <= 7 && feld.playingBoard[x + i][y + yoff].isOccupied() && feld.playingBoard[x + i][y + yoff].getFigur().getColor() != this.color) {
                    allowedFields[x + i][y + yoff] = true;
                }
            }

        return allowedFields;
    }
    public boolean[][] Attack(Feld feld, int x, int y){
        boolean[][] attackedFields = this.initBewegArray(feld);
        int yoff = 1;
        if(this.color){
            yoff = -1;
        }
        for (int i = -1;i <= 1; i = i + 2){
            if (x + i >= 0 && x + i <= 7){
                attackedFields[x + i][y + yoff] = true;
            }
        }

        return attackedFields;
    }
}
