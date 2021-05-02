import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    @Test
    void get_row() {
        Position pos = new Position(3, 2);
        assertEquals(3, pos.getRow());
    }

    @Test
    void get_column() {
        Position pos = new Position(3, 2);
        assertEquals(2, pos.getColumn());
    }
}