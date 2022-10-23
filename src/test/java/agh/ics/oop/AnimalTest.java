package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void allFuncTest(){
        Animal dog = new Animal();
        String[] input = new String[]{"f", "a", "f", "l", "lef","backward", "right", "r","f","f"};
        MapDirection[] correctOrientation = {MapDirection.NORTH, MapDirection.NORTH, MapDirection.WEST,
        MapDirection.WEST,MapDirection.NORTH,MapDirection.EAST,MapDirection.EAST,MapDirection.EAST};
        Vector2d[] correctPosition = {new Vector2d(2,3), new Vector2d(2,4), new Vector2d(2,4),
                new Vector2d(3,4), new Vector2d(3,4), new Vector2d(3,4), new Vector2d(4,4), new Vector2d(4,4)};
        MoveDirection[] correctMove = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT,
                MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD,
                MoveDirection.FORWARD };

        MoveDirection[] result = OptionsParser.parse(input);
        assertEquals(result.length, correctOrientation.length);

        for (int i = 0; i <result.length; i++) {
            dog.move(result[i]);
            assertEquals(result[i], correctMove[i]);
            assertEquals(correctOrientation[i], dog.getOrientation());
            assertTrue(dog.isAt(correctPosition[i]));
        }

    }

    @Test
    public void OptionsParserTest(){
        String[] input = {"rrr","backward", "b", "ao", "ll", "back", "forward", "f", "l", "left", "right", "r", "forw"};
        MoveDirection[] correct = {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT,
                MoveDirection.RIGHT };
        MoveDirection[] result = OptionsParser.parse(input);
        assertEquals(result.length, correct.length);
        for (int i = 0; i < result.length; i++){
            assertEquals(result[i], correct[i]);
        }
    }

    @Test
    public void OrientationTest(){
        Animal cat1 = new Animal();
        String[] input = {"rrr","backward", "b", "ao", "ll", "back", "forward", "f", "l", "left", "right", "forw"};
        MapDirection[] correct = {MapDirection.NORTH, MapDirection.NORTH, MapDirection.NORTH, MapDirection.NORTH,
                                    MapDirection.WEST, MapDirection.SOUTH, MapDirection.WEST};
        MoveDirection[] result = OptionsParser.parse(input);
        assertEquals(result.length, correct.length);
        for (int i=0; i < result.length; i++){
            cat1.move(result[i]);
            assertEquals(correct[i], cat1.getOrientation());
        }
    }

    @Test
    public void PositionTest(){
        Animal cat2 = new Animal();
        String[] input = {"b", "b", "l", "f", "f", "f", "r", "r","f","f","f","f","f"};
        Vector2d[] correct = {new Vector2d(2,1), new Vector2d(2,0),new Vector2d(2,0), new Vector2d(1,0),
                new Vector2d(0,0), new Vector2d(0,0), new Vector2d(0,0), new Vector2d(0,0),
                new Vector2d(1,0), new Vector2d(2,0), new Vector2d(3,0), new Vector2d(4,0), new Vector2d(4,0)};
        MoveDirection[] result = OptionsParser.parse(input);
        assertEquals(result.length, correct.length);
        for (int i=0; i < result.length; i++){
            cat2.move(result[i]);
            assertTrue(cat2.isAt(correct[i]));
        }
    }
}
