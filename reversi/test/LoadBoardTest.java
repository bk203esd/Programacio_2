import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadBoardTest {

    private static final String someBoard =
            "··w·····\n" +
            "··w··b··\n" +
            "··w·b···\n" +
            "··wwbb··\n" +
            "···bw···\n" +
            "···b·w··\n" +
            "···w····\n" +
            "··bbb···\n";

    @Test
    void test_loadBoard() {
        Board board = new Board(4);
        board.loadBoard(someBoard);
        assertEquals(someBoard, board.toString());
        assertEquals("B:  9 W:  8", board.getStatus());
    }
}
