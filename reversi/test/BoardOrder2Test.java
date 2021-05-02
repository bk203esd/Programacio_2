import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardOrder2Test {

    @Test
    void test_to_string() {
        Board board = new Board(2);
        String expected = "" +
                "····\n" +
                "·wb·\n" +
                "·bw·\n" +
                "····\n";
        assertEquals(expected, board.toString());
    }

    @Test
    void test_getStatus() {
        Board board = new Board(2);
        assertEquals("B:  2 W:  2", board.getStatus());
    }

    @Test
    void test_isOnBoard() {
        Board board = new Board(2);
        assertFalse(board.contains(new Position(0, -1)));
        assertFalse(board.contains(new Position(-1, 0)));
        assertFalse(board.contains(new Position(0, 4)));
        assertFalse(board.contains(new Position(4, 0)));

        assertTrue(board.contains(new Position(1, 2)));
    }
    @Test
    void test_isEmpty() {
        Board board = new Board(2);
        assertTrue(board.isEmpty(new Position(0, 0)));
        assertFalse(board.isEmpty(new Position(1, 1)));
        assertFalse(board.isEmpty(new Position(1, 2)));

        // Out of board are considered not empty
        assertFalse(board.isEmpty(new Position(0, -1)));
        assertFalse(board.isEmpty(new Position(-1, 0)));
        assertFalse(board.isEmpty(new Position(0, 4)));
        assertFalse(board.isEmpty(new Position(4, 0)));
    }

    @Test
    void test_isWhite() {
        Board board = new Board(2);
        assertTrue(board.isWhite(new Position(1, 1)));
        assertFalse(board.isWhite(new Position(0, 0)));
        assertFalse(board.isWhite(new Position(1, 2)));

        // Out of board are considered not white
        assertFalse(board.isWhite(new Position(0, -1)));
        assertFalse(board.isWhite(new Position(-1, 0)));
        assertFalse(board.isWhite(new Position(0, 4)));
        assertFalse(board.isWhite(new Position(4, 0)));
    }

    @Test
    void test_isBlack() {
        Board board = new Board(2);
        assertTrue(board.isBlack(new Position(1, 2)));
        assertFalse(board.isBlack(new Position(0, 0)));
        assertFalse(board.isBlack(new Position(1, 1)));

        // Out of board are considered not black
        assertFalse(board.isBlack(new Position(0, -1)));
        assertFalse(board.isBlack(new Position(-1, 0)));
        assertFalse(board.isBlack(new Position(0, 4)));
        assertFalse(board.isBlack(new Position(4, 0)));
    }

    @Test
    void test_setBlack() {
        Board board = new Board(2);
        Position emptyPos = new Position(0, 0);
        Position blackPos = new Position(1, 2);
        Position whitePos = new Position(1, 1);
        Position outPos = new Position(-1, 0);
        assertEquals("B:  2 W:  2", board.getStatus());

        // Black cell
        assertTrue(board.isBlack(blackPos));
        board.setBlack(blackPos);
        assertTrue(board.isBlack(blackPos));
        assertEquals("B:  2 W:  2", board.getStatus());

        // White cell
        assertTrue(board.isWhite(whitePos));
        board.setBlack(whitePos);
        assertFalse(board.isBlack(whitePos));
        assertEquals("B:  2 W:  2", board.getStatus());

        // Out of bounds cell
        assertFalse(board.contains(outPos));
        board.setBlack(outPos);
        assertEquals("B:  2 W:  2", board.getStatus());

        // Empty cell
        assertTrue(board.isEmpty(emptyPos));
        board.setBlack(emptyPos);
        assertTrue(board.isBlack(emptyPos));
        assertEquals("B:  3 W:  2", board.getStatus());
    }

    @Test
    void test_setWhite() {
        Board board = new Board(2);
        Position emptyPos = new Position(0, 0);
        Position blackPos = new Position(1, 2);
        Position whitePos = new Position(1, 1);
        Position outPos = new Position(-1, 0);
        assertEquals("B:  2 W:  2", board.getStatus());

        // Black cell
        assertTrue(board.isBlack(blackPos));
        board.setWhite(blackPos);
        assertTrue(board.isBlack(blackPos));
        assertEquals("B:  2 W:  2", board.getStatus());

        // White cell
        assertTrue(board.isWhite(whitePos));
        board.setWhite(whitePos);
        assertTrue(board.isWhite(whitePos));
        assertEquals("B:  2 W:  2", board.getStatus());

        // Out of bounds cell
        assertFalse(board.contains(outPos));
        board.setWhite(outPos);
        assertEquals("B:  2 W:  2", board.getStatus());

        // Empty cell
        assertTrue(board.isEmpty(emptyPos));
        board.setWhite(emptyPos);
        assertTrue(board.isWhite(emptyPos));
        assertEquals("B:  2 W:  3", board.getStatus());
    }

    @Test
    void test_reverse() {
        Board board = new Board(2);
        Position emptyPos = new Position(0, 0);
        Position blackPos = new Position(1, 2);
        Position whitePos = new Position(1, 1);
        Position outPos = new Position(-1, 0);
        assertEquals("B:  2 W:  2", board.getStatus());

        // Black cell
        assertTrue(board.isBlack(blackPos));
        board.reverse(blackPos);
        assertTrue(board.isWhite(blackPos));
        assertEquals("B:  1 W:  3", board.getStatus());

        // White cell
        assertTrue(board.isWhite(whitePos));
        board.reverse(whitePos);
        assertTrue(board.isBlack(whitePos));
        assertEquals("B:  2 W:  2", board.getStatus());

        // Out of bounds cell
        assertFalse(board.contains(outPos));
        board.reverse(outPos);
        assertEquals("B:  2 W:  2", board.getStatus());

        // Empty cell
        assertTrue(board.isEmpty(emptyPos));
        board.reverse(emptyPos);
        assertTrue(board.isEmpty(emptyPos));
        assertEquals("B:  2 W:  2", board.getStatus());
    }
}
