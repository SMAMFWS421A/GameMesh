package smamfws421a.gamemesh.chess;

public class Turm extends Figur{
    private boolean color = false;
    boolean firstmove = true;

    public Turm(boolean color){
        this.color = color;
        this.firstmove = true;
    }

    public void setFirstmove(boolean firstmove) {
        this.firstmove = firstmove;
    }

    @Override
    public boolean getColor() {
        return this.color;
    }

    @Override
    public String getImage() {
        if (getColor()){
            return ImageLoader.FigurW[1];
        }else {
            return ImageLoader.FigurB[1];
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
