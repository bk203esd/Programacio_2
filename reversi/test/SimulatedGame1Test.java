import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulatedGame1Test {

    @Test
    void game1() {
        Board board = new Board(2);
        Game game = new Game(board);
        String expected0 = "" +
                "····\n" +
                "·wb·\n" +
                "·bw·\n" +
                "····\n";
        String obtained0 = board.toString();
        assertEquals(expected0, obtained0);
        assertEquals("B:  2 W:  2 - BLACK moves", game.getStatus());

        game.move(new Position(0, 1));
        String expected1 = "" +
                "·b··\n" +
                "·bb·\n" +
                "·bw·\n" +
                "····\n";
        String obtained1 = board.toString();
        assertEquals(expected1, obtained1);
        assertEquals("B:  4 W:  1 - WHITE moves", game.getStatus());

        game.move(new Position(0, 2));
        String expected2 = "" +
                "·bw·\n" +
                "·bw·\n" +
                "·bw·\n" +
                "····\n";
        String obtained2 = board.toString();
        assertEquals(expected2, obtained2);
        assertEquals("B:  3 W:  3 - BLACK moves", game.getStatus());

        game.move(new Position(2, 3));
        String expected3 = "" +
                "·bw·\n" +
                "·bb·\n" +
                "·bbb\n" +
                "····\n";
        String obtained3 = board.toString();
        assertEquals(expected3, obtained3);
        assertEquals("B:  6 W:  1 - WHITE moves", game.getStatus());

        game.move(new Position(3, 2));
        String expected4 = "" +
                "·bw·\n" +
                "·bw·\n" +
                "·bwb\n" +
                "··w·\n";
        String obtained4 = board.toString();
        assertEquals(expected4, obtained4);
        assertEquals("B:  4 W:  4 - BLACK moves", game.getStatus());

        game.move(new Position(1, 3));
        String expected5 = "" +
                "·bw·\n" +
                "·bbb\n" +
                "·bwb\n" +
                "··w·\n";
        String obtained5 = board.toString();
        assertEquals(expected5, obtained5);
        assertEquals("B:  6 W:  3 - WHITE moves", game.getStatus());

        game.move(new Position(1, 0));
        String expected6 = "" +
                "·bw·\n" +
                "wbbb\n" +
                "·wwb\n" +
                "··w·\n";
        String obtained6 = board.toString();
        assertEquals(expected6, obtained6);
        assertEquals("B:  5 W:  5 - BLACK moves", game.getStatus());

        game.move(new Position(0, 3));
        String expected7 = "" +
                "·bbb\n" +
                "wbbb\n" +
                "·wwb\n" +
                "··w·\n";
        String obtained7 = board.toString();
        assertEquals(expected7, obtained7);
        assertEquals("B:  7 W:  4 - WHITE moves", game.getStatus());

        game.move(new Position(0, 0));
        String expected8 = "" +
                "wbbb\n" +
                "wwbb\n" +
                "·wwb\n" +
                "··w·\n";
        String obtained8 = board.toString();
        assertEquals(expected8, obtained8);
        assertEquals("B:  6 W:  6 - BLACK moves", game.getStatus());

        game.move(new Position(2, 0));
        String expected9 = "" +
                "wbbb\n" +
                "wbbb\n" +
                "bbbb\n" +
                "··w·\n";
        String obtained9 = board.toString();
        assertEquals(expected9, obtained9);
        assertEquals("B: 10 W:  3 - WHITE moves", game.getStatus());

        game.move(new Position(3, 0));
        String expected10 = "" +
                "wbbb\n" +
                "wbbb\n" +
                "wbbb\n" +
                "w·w·\n";
        String obtained10 = board.toString();
        assertEquals(expected10, obtained10);
        assertEquals("B:  9 W:  5 - WHITE moves", game.getStatus());

        game.move(new Position(3, 3));
        String expected11 = "" +
                "wbbb\n" +
                "wwbb\n" +
                "wbwb\n" +
                "w·ww\n";
        String obtained11 = board.toString();
        assertEquals(expected11, obtained11);
        assertEquals("B:  7 W:  8 - BLACK moves", game.getStatus());

        game.move(new Position(3, 1));
        String expected12 = "" +
                "wbbb\n" +
                "wwbb\n" +
                "wbbb\n" +
                "wbww\n";
        String obtained12 = board.toString();
        assertEquals(expected12, obtained12);
        assertEquals("B:  9 W:  7 - FINISHED", game.getStatus());
    }
}
