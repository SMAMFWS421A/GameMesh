package Chess.Game;

import java.awt.image.BufferedImage;

public class Springer extends Figur {
    private boolean color = false;

    public Springer(boolean color){
        this.color = color;
    }
    public boolean getColor(){
        return this.color;
    }

    @Override
    public BufferedImage getImage() {
        if (getColor()){
            return Chess.Game.ImageLoader.FigurW[2];
        }else {
            return ImageLoader.FigurB[2];
        }
    }

    @Override
    public boolean[][] Bewegung(Chess.Game.Feld feld) {
        boolean [][] allowedFields = this.initBewegArray(feld);
        int x = this.getCoordinate().x;
        int y = this.getCoordinate().y;
        for (int xdir = -2; xdir <= 2; xdir += 2){
            for (int ydir = -2; ydir <= 2; ydir += 2){
                for (int off = -1; off <= 1; off += 2){
                    if (xdir != ydir && xdir != ydir * (-1)){
                        int xnew = x + (xdir + off * ((ydir/2) % 2));
                        int ynew = y + (ydir + off * ((xdir/2) % 2));

                        int xmax = feld.getFeldGröße()[0];
                        int ymax = feld.getFeldGröße()[1];

                        if (xnew < xmax && ynew < ymax && xnew >= 0 && ynew >= 0){
                            SpielFeld desiredField = feld.playingBoard[xnew][ynew];
                            if ((!desiredField.isOccupied()) || (desiredField.isOccupied() && desiredField.getFigur().getColor() != this.color)){
                                allowedFields[xnew][ynew] = true;
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
