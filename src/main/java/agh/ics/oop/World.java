package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("Start \n");

        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println("PRZED: \n");
        System.out.println(map);
        engine.run();
        System.out.println("PO: \n");
        System.out.println(map);

        System.out.println("Koniec.");
    }
}


