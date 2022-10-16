package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void toStringTest() {
        assertEquals(new Vector2d(-3,-1).toString(), "(-3,-1)");
        assertEquals(new Vector2d(0,5).toString(), "(0,5)");
        assertNotEquals(new Vector2d(-3,-1).toString(), "(-3,5)");
        assertNotEquals(new Vector2d(0,5).toString(), "(5,0)");
    }

    @Test
    public void precedesTest() {
        assertTrue((new Vector2d(0,0)).precedes(new Vector2d(1, 2)));
        assertTrue((new Vector2d(1,1)).precedes(new Vector2d(1, 1)));
        assertFalse((new Vector2d(1,3)).precedes(new Vector2d(1, 0)));
        assertFalse((new Vector2d(0,0)).precedes(new Vector2d(-3, -2)));
    }

    @Test
    public void followTest() {
        assertTrue((new Vector2d(1,1)).follows(new Vector2d(1, 1)));
        assertTrue((new Vector2d(3,2)).follows(new Vector2d(2, -2)));
        assertFalse((new Vector2d(0,0)).follows(new Vector2d(1, 1)));
        assertFalse((new Vector2d(-1,-2)).follows(new Vector2d(1, 2)));
    }

    @Test
    public void addTest() {
        assertEquals((new Vector2d(-1,2)).add(new Vector2d(1,-2)), new Vector2d(0,0));
        assertEquals((new Vector2d(2,3)).add(new Vector2d(1,-2)), new Vector2d(3,1));
        assertNotEquals((new Vector2d(-1,2)).add(new Vector2d(1,-2)), new Vector2d(2,-4));
        assertNotEquals((new Vector2d(-1,2)).add(new Vector2d(1,-2)), new Vector2d(-2,4));
    }

    @Test
    public void subtractTest() {
        assertEquals((new Vector2d(-1,2)).subtract(new Vector2d(1,-2)), new Vector2d(-2,4));
        assertEquals((new Vector2d(5,3)).subtract(new Vector2d(1,-2)), new Vector2d(4,5));
        assertNotEquals((new Vector2d(3,3)).subtract(new Vector2d(-3,-3)), new Vector2d(0,0));
        assertNotEquals((new Vector2d(0,2)).subtract(new Vector2d(1,-2)), new Vector2d(-2,4));
    }

    @Test
    public void upperRightTest() {
        assertEquals((new Vector2d(-5, 2)).upperRight(new Vector2d(2, 1)), new Vector2d(2, 2));
        assertEquals((new Vector2d(3, 7)).upperRight(new Vector2d(-4, -8)), new Vector2d(3, 7));
        assertNotEquals((new Vector2d(5, 1)).upperRight(new Vector2d(-10, 2)), new Vector2d(10, 2));
        assertNotEquals((new Vector2d(3, 3)).upperRight(new Vector2d(2, 8)), new Vector2d(2, 8));
    }

    @Test
    public void lowerLeftTest() {
        assertEquals((new Vector2d(1, -4 )).lowerLeft(new Vector2d(-2, 3)), new Vector2d(-2, -4));
        assertEquals((new Vector2d(3, -7)).lowerLeft(new Vector2d(4, 8)), new Vector2d(3, -7));
        assertNotEquals((new Vector2d(5, 1)).lowerLeft(new Vector2d(-10, 2)), new Vector2d(5, 1));
        assertNotEquals((new Vector2d(-3, 3)).lowerLeft(new Vector2d(2, 8)), new Vector2d(2, 3));
    }

    @Test
    public void oppositeTest() {
        assertEquals((new Vector2d(-1,-1)).opposite(), new Vector2d(1,1));
        assertEquals((new Vector2d(8,-8)).opposite(), new Vector2d(-8,8));
        assertNotEquals((new Vector2d(-3,-3)).opposite(), new Vector2d(3,-3));
        assertNotEquals((new Vector2d(2,-1)).opposite(), new Vector2d(2,-1));
    }

    @Test
    public void equalsTest() {
        assertTrue((new Vector2d(1,1)).equals(new Vector2d(1, 1)));
        assertTrue((new Vector2d(-1,-2)).equals(new Vector2d(-1, -2)));
        assertFalse((new Vector2d(3,3)).equals(new Vector2d(-3, -3)));
        assertFalse((new Vector2d(-2,-2)).equals(new Vector2d(-2, 2)));
    }
}
