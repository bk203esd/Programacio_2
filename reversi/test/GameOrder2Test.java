import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOrder2Test {

    @Test
    void test_isSame() {
        Game game = new Game(new Board(2));
        /*
           ····
           ·wb·
           ·bw·
           ····
         */

        assertTrue(game.isSame(State.BLACK, new Position(1, 2)));   // black
        assertFalse(game.isSame(State.BLACK, new Position(1, 1)));  // white
        assertFalse(game.isSame(State.BLACK, new Position(0, 0)));  // empty
        assertFalse(game.isSame(State.BLACK, new Position(-1, 1))); // out

        assertFalse(game.isSame(State.WHITE, new Position(1, 2)));   // black
        assertTrue(game.isSame(State.WHITE, new Position(1, 1)));    // white
        assertFalse(game.isSame(State.WHITE, new Position(0, 0)));   // empty
        assertFalse(game.isSame(State.WHITE, new Position(-1, 1)));  // out
    }

    @Test
    void test_isOther() {
        Game game = new Game(new Board(2));
        /*
           ····
           ·wb·
           ·bw·
           ····
         */

        assertTrue(game.isOther(State.BLACK, new Position(1, 1)));   // white
        assertFalse(game.isOther(State.BLACK, new Position(1, 2)));  // black
        assertFalse(game.isOther(State.BLACK, new Position(0, 0)));  // empty
        assertFalse(game.isOther(State.BLACK, new Position(-1, 1))); // out

        assertFalse(game.isOther(State.WHITE, new Position(1, 1)));  // white
        assertTrue(game.isOther(State.WHITE, new Position(1, 2)));   // black
        assertFalse(game.isOther(State.WHITE, new Position(0, 0)));  // empty
        assertFalse(game.isOther(State.WHITE, new Position(-1, 1))); // out
    }

    @Test
    void test_someSame() {
        Game game = new Game(new Board(2));
        /*
           ····
           ·wb·
           ·bw·
           ····
         */

        Position black = new Position(1, 2);
        assertTrue(game.someSame(State.BLACK, black, Direction.N));
        assertTrue(game.someSame(State.BLACK, black, Direction.NE));
        assertTrue(game.someSame(State.BLACK, black, Direction.E));
        assertTrue(game.someSame(State.BLACK, black, Direction.SE));
        assertTrue(game.someSame(State.BLACK, black, Direction.S));
        assertTrue(game.someSame(State.BLACK, black, Direction.SW));
        assertTrue(game.someSame(State.BLACK, black, Direction.W));
        assertTrue(game.someSame(State.BLACK, black, Direction.NW));

        Position white = new Position(1, 1);
        assertFalse(game.someSame(State.BLACK, white, Direction.N));
        assertFalse(game.someSame(State.BLACK, white, Direction.NE));
        assertTrue(game.someSame(State.BLACK, white, Direction.E));
        assertFalse(game.someSame(State.BLACK, white, Direction.SE));
        assertTrue(game.someSame(State.BLACK, white, Direction.S));
        assertFalse(game.someSame(State.BLACK, white, Direction.SW));
        assertFalse(game.someSame(State.BLACK, white, Direction.W));
        assertFalse(game.someSame(State.BLACK, white, Direction.NW));

        Position empty = new Position(0, 1);
        assertFalse(game.someSame(State.BLACK, empty, Direction.N));
        assertFalse(game.someSame(State.BLACK, empty, Direction.NE));
        assertFalse(game.someSame(State.BLACK, empty, Direction.E));
        assertFalse(game.someSame(State.BLACK, empty, Direction.SE));
        assertFalse(game.someSame(State.BLACK, empty, Direction.S));
        assertFalse(game.someSame(State.BLACK, empty, Direction.SW));
        assertFalse(game.someSame(State.BLACK, empty, Direction.W));
        assertFalse(game.someSame(State.BLACK, empty, Direction.NW));

        Position out = new Position(-1, 0);
        assertFalse(game.someSame(State.BLACK, out, Direction.N));
        assertFalse(game.someSame(State.BLACK, out, Direction.NE));
        assertFalse(game.someSame(State.BLACK, out, Direction.E));
        assertFalse(game.someSame(State.BLACK, out, Direction.SE));
        assertFalse(game.someSame(State.BLACK, out, Direction.S));
        assertFalse(game.someSame(State.BLACK, out, Direction.SW));
        assertFalse(game.someSame(State.BLACK, out, Direction.W));
        assertFalse(game.someSame(State.BLACK, out, Direction.NW));
    }

    @Test
    void test_directionsOfReverse_only1() {
        Game game = new Game(new Board(2));
        /*
           ····
           ·wb·
           ·bw·
           ····
         */

        Position pos00 = new Position(1, 1);
        boolean[] allFalse = new boolean[] {
            false, false, false, false, false, false, false, false
        };
        assertArrayEquals(allFalse, game.directionsOfReverse(State.BLACK, pos00));

        Position pos01 = new Position(0, 1);
        boolean[] onlyS = new boolean [] {
            false, false, false, false, true, false, false, false
        };
        assertArrayEquals(onlyS, game.directionsOfReverse(State.BLACK, pos01));

        Position pos32 = new Position(3, 2);
        boolean[] onlyN = new boolean [] {
                true, false, false, false, false, false, false, false
        };
        assertArrayEquals(onlyN, game.directionsOfReverse(State.BLACK, pos32));
    }

    @Test
    void test_directionsOfReverse_multiple() {
        Board board = new Board(2);
        String initial = "" +
                "wb··\n" +
                "·bb·\n" +
                "wbw·\n" +
                "····\n";
        board.loadBoard(initial);

        Game game = new Game(board);

        boolean[] thirdQuadrant = new boolean[] {
                false, false, false, false, true, true, true, false
        };
        assertArrayEquals(thirdQuadrant, game.directionsOfReverse(State.WHITE, new Position(0, 2)));
    }

    @Test
    void test_canPlay_position() {
        Game game = new Game(new Board(2));

        assertFalse(game.canPlayPosition(State.BLACK, new Position(0, 0)));
        assertFalse(game.canPlayPosition(State.WHITE, new Position(0, 0)));

        assertTrue(game.canPlayPosition(State.BLACK, new Position(0, 1)));
        assertFalse(game.canPlayPosition(State.WHITE, new Position(0, 1)));

        assertFalse(game.canPlayPosition(State.BLACK, new Position(1, 1)));
        assertFalse(game.canPlayPosition(State.WHITE, new Position(1, 1)));
    }

    @Test
    void test_canPlay_board() {
        Game game = new Game(new Board(2));
        assertTrue(game.canPlay(State.BLACK));
        assertTrue(game.canPlay(State.WHITE));
    }
}
