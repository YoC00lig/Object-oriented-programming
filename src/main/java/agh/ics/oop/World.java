package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;
public class World {
    public static void main(String[] args){
//        try {
//            System.out.println("Start \n");
//
//            MoveDirection[] directions = OptionsParser.parse(args);
//            IWorldMap map = new GrassField(10);
//            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            System.out.println("PRZED: \n");
//            System.out.println(map);
//            engine.run();
//            System.out.println("PO: \n");
//            System.out.println(map);
//            System.out.println("Koniec.");
//        }
//        catch (IllegalArgumentException e){
//            System.out.println(e);
//        }

        Application.launch(App.class, args);
    }
}


