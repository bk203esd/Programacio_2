

public class Direction {

    public static final Direction N  = new Direction(-1,  0);
    public static final Direction S  = new Direction( 1,  0);
    public static final Direction E  = new Direction( 0,  1);
    public static final Direction W  = new Direction( 0, -1);
    public static final Direction NE = new Direction(-1,  1);
    public static final Direction NW = new Direction(-1, -1);
    public static final Direction SE = new Direction( 1,  1);
    public static final Direction SW = new Direction( 1, -1);

    public static final Direction[] ALL = new Direction[] {
            N, NE, E, SE, S, SW, W, NW
    };

    private final int changeInRow;
    private final int changeInColumn;

    private Direction(int changeInRow, int changeInColumn) {
        this.changeInRow = changeInRow;
        this.changeInColumn = changeInColumn;
    }

    public Position move(Position position) {
        return new Position(position.getRow() + this.changeInRow, position.getColumn() + this.changeInColumn);
    }
}
