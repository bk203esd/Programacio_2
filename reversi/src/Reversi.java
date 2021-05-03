
import acm.program.GraphicsProgram;
import acm.program.ProgramMenuBar;

import java.awt.event.MouseEvent;

public class Reversi extends GraphicsProgram {

    public static final int APPLICATION_HEIGHT = 600;
    public static final int APPLICATION_WIDTH  = 600;

    private static final double BOARD_PADDING = 0.03;
    private static final double CELL_PADDING = 0.10;

    private static final int ORDER = 4;

    private Game game;
    private Display display;

    public void run() {
        addMouseListeners();
        initialize();
    }

    private void initialize() {
        Geometry geometry = new Geometry(APPLICATION_WIDTH, APPLICATION_HEIGHT, 2 * ORDER, 2 * ORDER, BOARD_PADDING, CELL_PADDING);
        display = new Display(geometry, getGCanvas());
        Board board = new Board(ORDER, display);
        game = new Game(board);
        display.showInitial();
        setTitle(game.getStatus());
    }

    public void mouseClicked(MouseEvent evt) {
        if (game.isFinished()) return;
        Position p = display.toPosition(evt.getX(), evt.getY());
        game.move(p);
        setTitle(game.getStatus());
    }

    public static void main(String[] args) {
        new Reversi().start(args);
    }

    protected ProgramMenuBar createMenuBar() {
        return null;
    }
}
