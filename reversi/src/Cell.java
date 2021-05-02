

public class Cell {

    private static final char WHITE = 'w';
    private static final char BLACK = 'b';
    private static final char EMPTY = '·';

    private char state;

    private Cell(char state) {
        this.state = state;
    }

    public static Cell empty() {
        return new Cell(EMPTY);
    }

    public static Cell white() {
        return new Cell(WHITE);
    }

    public static Cell black() {
        return new Cell(BLACK);
    }

    public boolean isEmpty() {
        return (this.state == EMPTY);
    }

    public boolean isWhite() {
        return (this.state == WHITE);
    }

    public boolean isBlack() {
        return (this.state == BLACK);
    }

    public void setWhite() {
        this.state = WHITE;
    }

    public void setBlack() {
        this.state = BLACK;
    }

    public void reverse() {
        if (this.isBlack()) {
            setWhite();
        } else if (this.isWhite()) {
            setBlack();
        }
    }

    public String toString() {
        return String.valueOf(this.state);
    }

    public static Cell cellFromChar(char c) {
        switch (c) {
            case 'w': return white();
            case 'b': return black();
            default : return empty();
        }
    }
}
