package ch.bissbert.battleSim.data.drawing;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a Runnable to be used in a Thread. It draws the given list of DrawableObjects with a framerate defined in the {@link DrawRunnable#FPS} constant.
 */
public class DrawRunnable implements Runnable {

    private static final int FPS = 10;
    public static final List<Drawable> DRAWABLES = new ArrayList<>();

    private final GraphicsContext graphicsContext;

    public DrawRunnable(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    @Override
    public void run() {
        for (Drawable drawable : DRAWABLES) {
            drawable.draw(graphicsContext);
        }
        try {
            Thread.sleep(1000 * 60 / FPS);
            run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
