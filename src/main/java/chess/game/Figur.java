package chess.game;

import java.awt.image.BufferedImage;

public abstract class Figur {

    boolean color = false; //true = White
    private FeldPosition boardpos;
    private boolean firstmove;



    public boolean getColor(){
        return false;
    }
    public void setBoardpos(FeldPosition coordinate){
        this.boardpos = coordinate;
    }
    public boolean[][] Bewegung(Feld board){
        return initBewegArray(board);
    }
    public boolean[][] initBewegArray(Feld board){
        int x = board.getFeldGröße()[0];
        int y = board.getFeldGröße()[1];
        boolean[][] BewegArray = new boolean[x][y];
        return BewegArray;
    }
    public FeldPosition getCoordinate(){
        return this.boardpos;
    }

    public BufferedImage getImage(){
        return null;
    }
    public void setFirstMove(boolean firstMove){
        this.firstmove = firstMove;
    }
    public boolean[][] Attack(Feld feld,int x, int y){
        return Bewegung(feld);
    }
}
