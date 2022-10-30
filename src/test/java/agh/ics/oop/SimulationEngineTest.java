package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {
    @Test
    public void engineTest() {
        String[] moves = new String[]{"f",  "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(moves);
        IWorldMap map = new RectangularMap(5, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Animal animal1 = (Animal) map.objectAt(new Vector2d(2,0));
        Animal animal2 = (Animal) map.objectAt(new Vector2d(3,4));

        assertNotEquals(animal1,null);
        assertNotEquals(animal2, null);

        assertEquals(animal1.toString(), "S");
        assertEquals(animal2.toString(), "N");
    }
}
