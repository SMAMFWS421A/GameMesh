package chess.game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Feld implements MouseListener {

    private static final boolean black = false;
    private static final boolean white = true;
    public static int FeldGrößeX = 8, FeldGrößeY = 8;
    private static int FeldLängeX,FeldLängeY;
    public static SpielFeld[][] playingBoard;
    public static boolean player = true; //true = white

    public SpielFeld startFeld;

    public Feld(int FeldLängeX, int FeldLängeY){
        boolean color;
        this.FeldLängeX = FeldLängeX;
        this.FeldLängeY = FeldLängeY;
        this.playingBoard = new SpielFeld[this.FeldGrößeX][this.FeldGrößeY];
        for (int i = 0; i < this.FeldGrößeX;i++){
            for (int j = 0; j < this.FeldGrößeY;j++){
                this.playingBoard[i][j] = new SpielFeld(white, new FeldPosition(i,j),this.FeldLängeX,this.FeldLängeY);
                if ((i+j)%2 != 0){
                    this.playingBoard[i][j] = new SpielFeld(black, new FeldPosition(i,j),this.FeldLängeX,this.FeldLängeY);
                }
            }
        }
    }
    public void reset(){
        player = true;

        this.playingBoard[0][0].setFigur(new Turm(black));
        this.playingBoard[7][0].setFigur(new Turm(black));
        this.playingBoard[0][7].setFigur(new Turm(white));
        this.playingBoard[7][7].setFigur(new Turm(white));

        this.playingBoard[1][0].setFigur(new Springer(black));
        this.playingBoard[6][0].setFigur(new Springer(black));
        this.playingBoard[1][7].setFigur(new Springer(white));
        this.playingBoard[6][7].setFigur(new Springer(white));

        this.playingBoard[2][0].setFigur(new Läufer(black));
        this.playingBoard[5][0].setFigur(new Läufer(black));
        this.playingBoard[2][7].setFigur(new Läufer(white));
        this.playingBoard[5][7].setFigur(new Läufer(white));

        this.playingBoard[4][0].setFigur(new König(black));
        this.playingBoard[4][7].setFigur(new König(white));

        this.playingBoard[3][0].setFigur(new Dame(black));
        this.playingBoard[3][7].setFigur(new Dame(white));

        for (int i = 0; i < 8; i++){
            this.playingBoard[i][1].setFigur(new Bauer(black));
            this.playingBoard[i][6].setFigur(new Bauer(white));
        }
    }

        public void moveFigure(SpielFeld startField, SpielFeld endField){
        Figur figure = startField.getFigur();
        startField.removeFigur();
        if (endField.getFigur() != null) {
            endField.removeFigur();
        }
        endField.setFigur(figure);
    }
    public int[] getFeldGröße(){
        int [] xy = {FeldGrößeX,FeldGrößeY};
        return xy;
    }

    public SpielFeld getActiveBoardField(){
        SpielFeld activeField = new SpielFeld(white, new FeldPosition(-1,-1), FeldLängeX, FeldLängeY);
        for(int i = 0; i < this.FeldGrößeX; i++){
            for(int j = 0; j < this.FeldGrößeY; j++){
                if(this.playingBoard[i][j].getActive()){
                    activeField = this.playingBoard[i][j];
                }
            }
        }
        return activeField;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Mouse.pos = Mouse.ctp(new Point(e.getX(),e.getY()));
        Mouse.InsideField = Mouse.InsideField(e.getX(),e.getY());
        int x = Mouse.pos.x;
        int y = Mouse.pos.y;
        if (Mouse.InsideField && this.playingBoard[x][y].getFigur() != null && !this.playingBoard[x][y].getAllowed() && player == this.playingBoard[x][y].getFigur().getColor()) { //maus im feld und Feld hat Figur && nicht allowed und spieler Farbe = spiel figur
            boolean[][] allowedField = this.playingBoard[x][y].getFigur().Bewegung(this);
            for (int i = 0; i < this.FeldGrößeX; i++) {
                for (int j = 0; j < this.FeldGrößeY; j++) {
                    this.playingBoard[i][j].setActive(false);
                    this.playingBoard[i][j].setAllowed(false);
                    if (allowedField[i][j]){
                        this.playingBoard[i][j].setAllowed(true);
                    }
                }
            }
            this.playingBoard[x][y].setActive(true);
        }else if (Mouse.InsideField && this.playingBoard[x][y].getAllowed()){
            for (int i = 0; i < this.FeldGrößeX; i++) {
                for (int j = 0; j < this.FeldGrößeY; j++) {
                    this.playingBoard[i][j].setAllowed(false);
                    if (this.playingBoard[i][j].getActive()){
                        moveFigure(this.playingBoard[i][j],this.playingBoard[x][y]);
                        this.playingBoard[i][j].setActive(false);
                        player = !player;
                    }
                }
            }
        }else{
            for (int i = 0; i < this.FeldGrößeX; i++) {
                for (int j = 0; j < this.FeldGrößeY; j++) {
                    this.playingBoard[i][j].setActive(false);
                    this.playingBoard[i][j].setAllowed(false);
                }
            }
        }
        for (int i = 0; i < this.FeldGrößeX; i++){
            for (int j = 0; j < this.FeldGrößeY; j++){
                if (this.playingBoard[i][j].isOccupied()) {
                    boolean[][] allowedFields = this.playingBoard[i][j].getFigur().Attack(this,i,j);
                    for (int x1 = 0; x1 < this.FeldGrößeX; x1++) {
                        for (int y1 = 0; y1 < this.FeldGrößeY; y1++) {
                            if (allowedFields[x1][y1]) {
                                if (this.playingBoard[i][j].getFigur().getColor()){
                                    this.playingBoard[x1][y1].setAttacked(true,0,i,j);
                                }
                                if (!this.playingBoard[i][j].getFigur().getColor()){
                                    this.playingBoard[x1][y1].setAttacked(true,1,i,j);
                                }
                            }
                            allowedFields[x1][y1] = false;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static boolean[][][] Schach(){ //1.[]: bedrohte Farbe (0 = Weiß);
        boolean[][][] schach = new boolean[2][8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (Feld.playingBoard[i][j].getFigur() != null) {
                    int farbe = 1;
                    if (!Feld.playingBoard[i][j].getFigur().getColor()) {
                        farbe = 0;
                    }
                    for (int x = 0;x<8;x++){
                        for (int y = 0; y < 8; y++){
                            if (Feld.playingBoard[i][j].getFigur() instanceof König && Feld.playingBoard[i][j].getAttacked(farbe)[x][y]) {
                                schach[farbe][x][y] = true;
                            }
                        }
                    }
                }
            }
        }
        return schach;
    }
}
