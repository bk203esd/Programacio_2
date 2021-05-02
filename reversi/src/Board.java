
import java.util.StringTokenizer;

public class Board {
    private final Cell[][] cells;
    private final Display display;
    private final int order;

    private int black;
    private int white;

    public Board(int order, Display display) {
        this.order = order;
        this.cells = new Cell[2 * order][2 * order];
        this.black = 0;
        this.white = 0;
        this.display = display;
        initBoard();
    }

    public Board(int order) {
        this(order, null);
    }

    public int size() {
        return 2 * order;
    }

    private void initBoard() {
        throw new UnsupportedOperationException("Step 4.1");
    }

    public boolean contains(Position position) {
        throw new UnsupportedOperationException("Step 4.1");
    }

    public boolean isEmpty(Position position) {
        throw new UnsupportedOperationException("Step 4.1");
    }

    public boolean isWhite(Position position) {
        throw new UnsupportedOperationException("Step 4.1");
    }

    public boolean isBlack(Position position) {
        throw new UnsupportedOperationException("Step 4.1");
    }

    public void setWhite(Position position) {
        throw new UnsupportedOperationException("Step 4.2");
    }

    public void setBlack(Position position) {
        throw new UnsupportedOperationException("Step 4.2");
    }

    public void reverse(Position position) {
        throw new UnsupportedOperationException("Step 4.2");
    }

    public void loadBoard(String str) {
        StringTokenizer st = new StringTokenizer(str, "\n");
        int row = 0;
        this.white = 0;
        this.black = 0;
        while (st.hasMoreTokens()) {
            String rowChars = st.nextToken();
            loadRow(this.cells[row], rowChars);
            row += 1;
        }
    }

    private void loadRow(Cell[] cellRow, String rowChars) {
        for (int column = 0; column < cellRow.length; column++) {
            Cell cell = Cell.cellFromChar(rowChars.charAt(column));
            cellRow[column] = cell;
            if (cell.isWhite()) white += 1;
            else if (cell.isBlack()) black += 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        for (Cell[] cell : this.cells) {
            for (Cell value : cell) {
                sb.append(value.toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getStatus() {
        return String.format("B:%3d W:%3d", this.black, this.white);
    }
}
