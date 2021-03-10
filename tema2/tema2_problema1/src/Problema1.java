import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.Color;

public class Problema1 extends GraphicsProgram {

    public double TIMEOUT = 10.0;
    public double MOVEMENT = 5.0;
    public double FIGURE_WIDTH = 100.0;
    public double FIGURE_HEIGHT = 75.0;

    public GRect createRect(double x, double y) {
        GRect rect = new GRect(x, y, FIGURE_WIDTH, FIGURE_HEIGHT);
        rect.setFilled(true);
        rect.setColor(Color.RED);
        add(rect);
        return rect;
    }

    public void run() {
        double x = (getWidth() - FIGURE_WIDTH) / 2.0;
        double y = (getHeight() - FIGURE_HEIGHT) / 2.0;
        GRect rect = createRect(x, y);
        boolean direction = true;

        while(true) {
            if(direction) {
                if (rect.getLocation().getX() <= getWidth() - FIGURE_WIDTH) {
                    pause(TIMEOUT);
                    rect.move(MOVEMENT, 0);
                } else {
                    direction = false;
                }
            } else {
                if (rect.getLocation().getX() >= 0) {
                    pause(TIMEOUT);
                    rect.move(-MOVEMENT, 0);
                } else {
                    direction = true;
                }
            }
        }
    }
}
