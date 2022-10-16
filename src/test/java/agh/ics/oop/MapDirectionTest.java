package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    MapDirection north = MapDirection.NORTH;
    MapDirection south = MapDirection.SOUTH;
    MapDirection east = MapDirection.EAST;
    MapDirection west = MapDirection.WEST;

    @Test
    public void TestNext() {
        assertEquals(north, west.next());
        assertEquals(east, north.next());
        assertEquals(south, east.next());
        assertEquals(west, south.next());
    }

    @Test
    public void TestPrevious() {
        assertEquals(north, east.previous());
        assertEquals(east, south.previous());
        assertEquals(south, west.previous());
        assertEquals(west, north.previous());
    }
}
