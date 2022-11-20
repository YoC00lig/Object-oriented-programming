package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void testUpperLower() {
        GrassField map = new GrassField(0);
        Animal animal1 = new Animal(map, new Vector2d(3,4));
        Animal animal2 = new Animal(map, new Vector2d(4,1));
        Animal animal3 = new Animal(map, new Vector2d(2,2));

        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        Vector2d lower = new Vector2d(2,1);
        Vector2d upper = new Vector2d(4,4);
        assertEquals(lower, map.findLimits()[0]);
        assertEquals(upper, map.findLimits()[1]);
    }

    @Test
    public void plantGrassTest() {
        GrassField testMap = new GrassField(5);
        int numberOfFieldsDetected = 0;
        int high = (int) Math.floor(Math.sqrt(10 * 4));
        for (int i = 0; i <= high; i++) {
            for (int j =0 ; j <= high; j++){
                if (testMap.objectAt(new Vector2d(i,j)) != null && testMap.objectAt(new Vector2d(i,j)) instanceof Grass) {
                    numberOfFieldsDetected++;
                }
            }
        }
        assertEquals(numberOfFieldsDetected, 5);
    }

    @Test
    public void placeTest() {
        try {
            GrassField map = new GrassField(0);
            Animal animal1 = new Animal(map, new Vector2d(3,4));
            Animal animal2 = new Animal(map, new Vector2d(4,1));
            Animal animal3 = new Animal(map, new Vector2d(2,2));
            Animal animal4 = new Animal(map);
            assertTrue(map.place(animal1));
            assertTrue(map.place(animal2));
            assertTrue(map.place(animal3));
            assertFalse(map.place(animal4));
        }
        catch(IllegalArgumentException e){
            assertEquals(e.getMessage(),"(2,2): It is outside map boundary or occupied.");
        }
    }


    @Test
    public void objectAtTest() {
        GrassField map = new GrassField(0);
        Animal animal1 = new Animal(map, new Vector2d(3,4));
        Animal animal2 = new Animal(map, new Vector2d(4,1));
        Animal animal3 = new Animal(map, new Vector2d(2,2));

        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertEquals(map.objectAt(new Vector2d(3,4)), animal1);
        assertEquals(map.objectAt(new Vector2d(4,1)), animal2);
        assertEquals(map.objectAt(new Vector2d(2,2)), animal3);

    }

    @Test
    public void isOccupiedTest() {
        GrassField map = new GrassField(0);
        Animal animal1 = new Animal(map, new Vector2d(3,4));
        Animal animal2 = new Animal(map, new Vector2d(4,1));
        Animal animal3 = new Animal(map, new Vector2d(2,2));

        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertTrue(map.isOccupied(new Vector2d(3,4)));
        assertTrue(map.isOccupied(new Vector2d(4,1)));
        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(0,2)));
    }


    @Test
    public void canMoveToTest() {
        GrassField map = new GrassField(0);
        Animal animal1 = new Animal(map, new Vector2d(3,4));
        Animal animal2 = new Animal(map, new Vector2d(4,1));
        Animal animal3 = new Animal(map, new Vector2d(2,2));


        map.place(animal1);
        map.place(animal2);
        map.place(animal3);

        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertFalse(map.canMoveTo(new Vector2d(4,1)));
        assertFalse(map.canMoveTo(new Vector2d(3,4)));
        assertTrue(map.canMoveTo(new Vector2d(3,5)));
        assertTrue(map.canMoveTo(new Vector2d(5,5)));
        assertTrue(map.canMoveTo(new Vector2d(6,0)));
    }

}
