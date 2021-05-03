
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
        for (int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[0].length; j++) {
                if ((i == this.order - 1 && j == this.order - 1) || (i == this.order && j == this.order)) {
                    cells[i][j] = Cell.white();
                    white++;
                    if (display != null) display.setWhite(new Position (i, j));
                } else if ((i == this.order && j == this.order - 1) || (i == this.order - 1 && j == this.order)) {
                    cells[i][j] = Cell.black();
                    black++;
                    if (display != null) display.setBlack(new Position (i, j));
                } else {
                    cells[i][j] = Cell.empty();
                }
            }
        }
    }

    public boolean contains(Position position) {
        return (position.getRow() < this.cells.length && position.getRow() >= 0 && position.getColumn() < this.cells.length && position.getColumn() >= 0);
    }

    public boolean isEmpty(Position position) {
        if (contains(position)) {
            return (cells[position.getRow()][position.getColumn()].isEmpty());
        }
        return false;
    }

    public boolean isWhite(Position position) {
        if (contains(position)) {
            return (cells[position.getRow()][position.getColumn()].isWhite());
        }
        return false;
    }

    public boolean isBlack(Position position) {
        if (contains(position)) {
            return (cells[position.getRow()][position.getColumn()].isBlack());
        }
        return false;
    }

    public void setWhite(Position position) {
        if (isEmpty(position)) {
            cells[position.getRow()][position.getColumn()].setWhite();
            white++;
            if (display != null) display.setWhite(position);
        }
    }

    public void setBlack(Position position) {
        if (isEmpty(position)) {
            cells[position.getRow()][position.getColumn()].setBlack();
            black++;
            if (display != null) display.setBlack(position);
        }
    }

    public void reverse(Position position) {
        if (!isEmpty(position) && contains(position)) {
            if(cells[position.getRow()][position.getColumn()].isBlack()) {
                cells[position.getRow()][position.getColumn()].reverse();
                white++;
                black--;
                if (display != null) display.reverse(position);

            } else if (cells[position.getRow()][position.getColumn()].isWhite()) {
                cells[position.getRow()][position.getColumn()].reverse();
                black++;
                white--;
                if (display != null) display.reverse(position);

            }
        }
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
