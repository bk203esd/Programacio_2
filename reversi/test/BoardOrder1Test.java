
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardOrder1Test {

    @Test
    void to_string() {
        Board board = new Board(1);
        String expected = "" +
                "wb\n" +
                "bw\n";
        assertEquals(expected, board.toString());
    }

    @Test
    void get_status() {
        Board board = new Board(1);
        assertEquals("B:  2 W:  2", board.getStatus());
    }
}
