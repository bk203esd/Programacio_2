import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DirectionTest {

    @Test
    void north() {
        assertEquals(new Position(3, 2), Direction.N.move(new Position(4, 2)));
    }

    @Test
    void south() {
        assertEquals(new Position(5, 2), Direction.S.move(new Position(4, 2)));
    }

    @Test
    void east() {
        assertEquals(new Position(4, 3), Direction.E.move(new Position(4, 2)));
    }

    @Test
    void west() {
        assertEquals(new Position(4, 1), Direction.W.move(new Position(4, 2)));
    }

    @Test
    void north_west() {
        assertEquals(new Position(3, 1), Direction.NW.move(new Position(4, 2)));
    }

    @Test
    void north_east() {
        assertEquals(new Position(3, 3), Direction.NE.move(new Position(4, 2)));
    }

    @Test
    void south_west() {
        assertEquals(new Position(5, 1), Direction.SW.move(new Position(4, 2)));
    }

    @Test
    void south_east() {
        assertEquals(new Position(5, 3), Direction.SE.move(new Position(4, 2)));
    }

    private static boolean contains(Direction[] dirArray, Direction direction) {
        for (Direction value : dirArray)
            if (value == direction)
                return true;
        return false;
    }

    @Test
    void all_contains_all_directions() {
        assertEquals(8, Direction.ALL.length);
        assertTrue(contains(Direction.ALL, Direction.N));
        assertTrue(contains(Direction.ALL, Direction.S));
        assertTrue(contains(Direction.ALL, Direction.E));
        assertTrue(contains(Direction.ALL, Direction.W));
        assertTrue(contains(Direction.ALL, Direction.NE));
        assertTrue(contains(Direction.ALL, Direction.NW));
        assertTrue(contains(Direction.ALL, Direction.SE));
        assertTrue(contains(Direction.ALL, Direction.SW));
    }
}