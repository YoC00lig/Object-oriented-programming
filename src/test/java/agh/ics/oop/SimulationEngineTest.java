package agh.ics.oop;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class SimulationEngineTest {
//    @Test
//    public void engineTest() {
//        try {
//            String[] moves = new String[]{"f", "a", "b", "r", "l", "f", "f", "r", "r"};
//            MoveDirection[] directions = OptionsParser.parse(moves);
//            IWorldMap map = new RectangularMap(5, 5);
//            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//
//            Animal animal1 = (Animal) map.objectAt(new Vector2d(2,3));
//            Animal animal2 = (Animal) map.objectAt(new Vector2d(3,3));
//
//            assertNotEquals(animal1,null);
//            assertNotEquals(animal2, null);
//
//            assertEquals(animal1.toString(), "S");
//            assertEquals(animal2.toString(), "N");
//        }
//        catch(IllegalArgumentException ex){
//            assertEquals(ex.getMessage(),"a is not legal move specification");
//        }
//    }
//}
