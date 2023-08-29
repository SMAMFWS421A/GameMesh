package smamfws421a.gamemesh.chess;

public class SpielFeld {

    public boolean color;
    public Figur occupied;
    public int FeldLängeX,FeldLängeY;
    public FeldPosition coordinate;

    private boolean active;
    private boolean allowed;
    private boolean[][][] attacked = new boolean[2][8][8]; //White = 0 => von Weiß angegriffen 2. & 3. []: Koordinaten von Angreifer

    public SpielFeld(boolean color, FeldPosition coordinate, int FeldLängeX, int FeldLängeY){
        this.color = color;
        this.active = active;
        this.allowed = allowed;
        this.coordinate = coordinate;
        this.occupied = occupied;
        this.FeldLängeX = FeldLängeX;
        this.FeldLängeY = FeldLängeY;
    }

    public boolean getColor(){
        return this.color;
    }

    public boolean getActive(){
        return this.active;
    }

    public FeldPosition getCoordinate() {
        return this.coordinate;
    }

    public boolean isOccupied() {
        return (this.occupied != null);
    }

    public String getName(){
        return this.coordinate.name;
    }

    public boolean getAllowed(){
        return this.allowed;
    }

    public boolean[][] getAttacked(int Farbe){
        return this.attacked[Farbe];
    }

    public void setAttacked(boolean attacked, int Farbe, int x, int y){
        this.attacked[Farbe][x][y] = attacked;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public void setFigur(Figur occupied){
        this.occupied = occupied;
        this.occupied.setBoardpos(this.coordinate);
    }

    public void removeFigur(){
        this.occupied = null;
    }

    public Figur getFigur(){
        if (this.isOccupied()){
            return this.occupied;
        }else {
            return null;
        }
    }
}
