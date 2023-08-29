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
        Mouse.pos = Mouse.ctp(new Point(e.getX(),e.getY()));
        Mouse.InsideField = Mouse.InsideField(e.getX(),e.getY());
    }
}
