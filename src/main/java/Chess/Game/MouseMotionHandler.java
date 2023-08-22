package Chess.Game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Chess.Game.Mouse.pos = Chess.Game.Mouse.ctp(new Point(e.getX(),e.getY()));
        Chess.Game.Mouse.InsideField = Mouse.InsideField(e.getX(),e.getY());
    }
}
