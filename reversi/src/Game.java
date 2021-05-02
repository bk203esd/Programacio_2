
public class Game {

    private final Board board;
    private State state;

    public Game(Board board) {
        this.board = board;
        // Suponemos que el jugador con las fichas negras puede hacer la primera jugada
        // (es decir, el tablero es de orden como mínimo 2)
        this.state = State.BLACK;
    }

    public boolean isFinished() {
        throw new UnsupportedOperationException("Step 5.1");
    }

    public boolean isSame(State player, Position position) {
        throw new UnsupportedOperationException("Step 5.1");
    }

    public boolean isOther(State player, Position position) {
        throw new UnsupportedOperationException("Step 5.1");
    }

    public boolean someSame(State player, Position position, Direction direction) {
        throw new UnsupportedOperationException("Step 5.1");
    }

    public boolean isReverseDirection(State player, Position position, Direction direction) {
        throw new UnsupportedOperationException("Step 5.2");
    }

    public boolean[] directionsOfReverse(State player, Position position) {
        throw new UnsupportedOperationException("Step 5.2");
    }

    private static boolean allFalse(boolean[] bools) {
        throw new UnsupportedOperationException("Step 5.2");
    }

    public boolean canPlay(State player) {
        throw new UnsupportedOperationException("Step 5.3");
    }

    public boolean canPlayPosition(State player, Position position) {
        throw new UnsupportedOperationException("Step 5.3");
    }

    private void disk(Position position) {
        throw new UnsupportedOperationException("Step 5.4");
    }

    private void reverse(Position position, Direction direction) {
        throw new UnsupportedOperationException("Step 5.4");
    }

    private void reverse(Position position, boolean[] directions) {
        throw new UnsupportedOperationException("Step 5.4");
    }

    private void changeTurn() {
        throw new UnsupportedOperationException("Step 5.4");
    }

    public void move(Position position) {
        if (!this.board.isEmpty(position)) return;
        boolean[] directions = this.directionsOfReverse(this.state, position);
        if (allFalse(directions)) return;
        this.disk(position);
        this.reverse(position, directions);
        this.changeTurn();
    }

    public String getStatus() {
        String move;
        if (this.state == State.FINISHED) {
            move = "FINISHED";
        } else {
            move = (this.state == State.BLACK ? "BLACK" : "WHITE") + " moves";
        }
        return String.format("%s - %s", this.board.getStatus(), move);
    }
}

