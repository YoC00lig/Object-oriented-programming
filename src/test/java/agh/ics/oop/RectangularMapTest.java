package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RectangularMapTest {

    @Test
    public void objectAtTest() {
        IWorldMap map = new RectangularMap(5,5);
        Animal animal1 = new Animal(map, new Vector2d(2,0));
        Animal animal2 = new Animal(map, new Vector2d(4,2));
        map.place(animal1);
        map.place(animal2);
        assertEquals(map.objectAt(new Vector2d(2,0)), animal1);
        assertEquals(map.objectAt(new Vector2d(4,2)), animal2);
        assertNotEquals(map.objectAt(new Vector2d(1,3)), animal1);
        assertNotEquals(map.objectAt(new Vector2d(0,2)), animal2);
    }

    @Test
    public void isOccupiedTest() {
        IWorldMap map = new RectangularMap(5,5);
        Animal animal = new Animal(map, new Vector2d(2,0));
        map.place(animal);
        assertFalse(map.isOccupied(new Vector2d(0,2)));
        assertFalse(map.isOccupied(new Vector2d(3, 3)));
        assertTrue(map.isOccupied(new Vector2d(2,0)));
    }

    @Test
    public void placeTest() {
        IWorldMap map = new RectangularMap(5,5);
        Animal animal1 = new Animal(map, new Vector2d(2,0));
        Animal animal2 = new Animal(map, new Vector2d(0,2));
        Animal animal3 = new Animal(map, new Vector2d(3,4));
        Animal animal4 = new Animal(map, new Vector2d(2,0));
        assertTrue(map.place(animal1));
        assertTrue(map.place(animal2));
        assertTrue(map.place(animal3));
        assertFalse(map.place(animal4));
    }

    @Test
    public void canMoveToTest() {
        IWorldMap map = new RectangularMap(5,5);
        Animal animal = new Animal(map, new Vector2d(2,3));
        map.place(animal);
        assertFalse(map.canMoveTo(new Vector2d(2,3)));
        assertFalse(map.canMoveTo(new Vector2d(5,5)));
        assertFalse(map.canMoveTo(new Vector2d(6,7)));
        assertFalse(map.canMoveTo(new Vector2d(-1,-1)));
        assertTrue(map.canMoveTo(new Vector2d(3,1)));
        assertTrue(map.canMoveTo(new Vector2d(4,4)));
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
    }



}
