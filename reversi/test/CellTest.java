import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void isEmpty_detects_only_white_cells() {
        assertTrue(Cell.empty().isEmpty());
        assertFalse(Cell.white().isEmpty());
        assertFalse(Cell.black().isEmpty());
    }

    @Test
    void isWhite_detects_only_white_cells() {
        assertTrue(Cell.white().isWhite());
        assertFalse(Cell.empty().isWhite());
        assertFalse(Cell.black().isWhite());
    }

    @Test
    void isBlack_detects_only_black_cells() {
        assertTrue(Cell.black().isBlack());
        assertFalse(Cell.empty().isBlack());
        assertFalse(Cell.white().isBlack());
    }

    @Test
    void reverse_of_empty_is_empty() {
        Cell cell = Cell.empty();
        cell.reverse();
        assertTrue(cell.isEmpty());
    }

    @Test
    void reverse_of_white_is_black() {
        Cell cell = Cell.white();
        cell.reverse();
        assertTrue(cell.isBlack());
    }

    @Test
    void reverse_of_black_is_white() {
        Cell cell = Cell.black();
        cell.reverse();
        assertTrue(cell.isWhite());
    }

    @Test
    void to_string() {
        assertEquals("·", Cell.empty().toString());
        assertEquals("w", Cell.white().toString());
        assertEquals("b", Cell.black().toString());
    }
}