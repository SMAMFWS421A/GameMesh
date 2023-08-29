package smamfws421a.gamemesh.components;

import org.springframework.stereotype.Component;
import org.vaadin.pekkam.Canvas;
import org.vaadin.pekkam.CanvasRenderingContext2D;

@Component
public class ChessComponent {

    public ChessComponent() {

        Canvas canvas = new Canvas(1000, 1000);
        CanvasRenderingContext2D ctx = canvas.getContext();




    }
}
