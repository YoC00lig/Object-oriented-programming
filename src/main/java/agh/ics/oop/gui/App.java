package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.HPos;
import java.util.Map;

public class App extends Application {
    private GridPane gridPane;
    private AbstractWorldMap awMap;
    final int size = 30;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        // Label label = new Label("Zwierzak");
        // Scene scene = new Scene(label, 400, 400);
        // primaryStage.setScene(scene);
        // primaryStage.show();

        gridPane = new GridPane();
        MoveDirection[] directions = OptionsParser.parse(getParameters().getRaw().toArray(new String[0]));
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        awMap = map;
        drawMap();
        Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawMap(){
        Label label = new Label("y/x");
        Map<Vector2d, IMapElement> elements = awMap.getElements();
        Vector2d low =  awMap.getMapBoundary().findLimits()[0];
        Vector2d high =  awMap.getMapBoundary().findLimits()[1];

        gridPane.add(label, 0, 0);
        gridPane.getRowConstraints().add(new RowConstraints(size));
        gridPane.getColumnConstraints().add(new ColumnConstraints(size));
        GridPane.setHalignment(label, HPos.CENTER);
        gridPane.setGridLinesVisible(true);

        for (int i = low.x; i <= high.x; i++){
            Label numberX = new Label("" + i );
            gridPane.add(numberX,  i - low.x + 1, 0);
            gridPane.getColumnConstraints().add(new ColumnConstraints(size));
            GridPane.setHalignment(numberX, HPos.CENTER);
        }

        for (int i = low.y; i <= high.y; i++){
            Label numberY = new Label("" + i);
            gridPane.add(numberY, 0,high.y - i + 1);
            gridPane.getRowConstraints().add(new RowConstraints(size));
            GridPane.setHalignment(numberY, HPos.CENTER);
        }

        for (IMapElement element: elements.values()) {
            Label elem = new Label(element.toString());
            Vector2d pos = element.getPosition();
            gridPane.add(elem,  pos.x - low.x + 1, high.y - pos.y + 1);
            GridPane.setHalignment(elem, HPos.CENTER);
        }
    }

}
