import acm.graphics.GDimension;
import acm.graphics.GPoint;

public class Geometry {

    private final int windowWidth;
    private final int windowHeight;
    private final int numCols;
    private final int numRows;
    private final double boardPadding;
    private final double cellPadding;

    public Geometry(int windowWidth, int windowHeight, int numCols, int numRows, double boardPadding, double cellPadding) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.numCols = numCols;
        this.numRows = numRows;
        this.boardPadding = boardPadding;
        this.cellPadding = cellPadding;
    }

    public int getRows() {
        return this.numRows;
    }

    public int getColumns() {
        return this.numCols;
    }

    public GDimension boardDimension() {
        return new GDimension(this.windowWidth - (this.windowWidth * this.boardPadding) * 2, this.windowHeight - (this.windowHeight * this.boardPadding) * 2);
    }

    public GPoint boardTopLeft() {
        return new GPoint(this.windowWidth * this.boardPadding, this.windowHeight * this.boardPadding);
    }

    public GDimension cellDimension() {
        return new GDimension(boardDimension().getWidth() / this.numCols, boardDimension().getHeight() / this.numRows);
    }

    public GPoint cellTopLeft(int x, int y) {
        return new GPoint(boardTopLeft().getX() + cellDimension().getWidth() * x, boardTopLeft().getY() + cellDimension().getHeight() * y);
    }

    public GDimension tokenDimension() {
        return new GDimension(cellDimension().getWidth() - (cellDimension().getWidth() * this.cellPadding * 2), cellDimension().getHeight() - (cellDimension().getHeight() * this.cellPadding * 2));
    }

    public GPoint tokenTopLeft(int x, int y) {
        throw new UnsupportedOperationException("Step 3");
    }

    public GPoint centerAt(int x, int y) {
        throw new UnsupportedOperationException("Step 3");
    }

    //Implemented
    public Position xyToCell(double x, double y) {
        GPoint boardTopLeft = boardTopLeft();
        GDimension cellDimension = cellDimension();
        return new Position(
                (int) ((x - boardTopLeft.getX()) / cellDimension.getWidth()),
                (int) ((y - boardTopLeft.getY()) / cellDimension.getHeight()));
    }
}
