package ch.bissbert.battleSim.data.drawing;

import javafx.scene.canvas.GraphicsContext;

/**
 * This interface defines a method that is used to draw something on a canvas.
 *
 * @author Bissbert
 * @version 1.0
 * @since 1.0
 */
public interface Drawable {
    public void draw(GraphicsContext graphicsContext);
}
