import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import acm.graphics.GOval;

import java.awt.*;

public class Problema2 extends GraphicsProgram {

    public int NUM_TURTLES = 5;
    public double TIMEOUT = 10.0;

    public int rollDie() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        return rgen.nextInt(1, 6);
    }

    public GOval[] createTurtles() {
        GOval[] turtles = new GOval[NUM_TURTLES];
        double size = getHeight() / NUM_TURTLES;
        for (int i = 0; i < NUM_TURTLES; i++) {
            turtles[i] =  new GOval(0, size * i, size, size);
            turtles[i].setFilled(true);
            turtles[i].setColor(Color.GREEN);
            add(turtles[i]);
        }
        return turtles;
    }

    public void turtleRace(GOval[] turtles) {
        boolean victory = false;
        while (!victory) {
            for (int i = 0; i < NUM_TURTLES; i++) {
                turtles[i].move(rollDie(), 0);
                turtles[i].pause(TIMEOUT);
                if (turtles[i].getLocation().getX() >= (getWidth() - turtles[i].getWidth())) {
                    victory = true;
                    turtles[i].setColor(Color.RED);
                }
            }
        }
    }

    public void run() {
        GOval[] turtles = createTurtles();
        turtleRace(turtles);
    }
}
