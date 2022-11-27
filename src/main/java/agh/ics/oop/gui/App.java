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
import java.io.FileNotFoundException;
import java.util.Map;
import javafx.scene.layout.VBox;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.Pos;

public class App extends Application {
    private GridPane gridPane;
    final int size = 40;
    private Stage stage;
    private SimulationEngine engine;
    private Button button;
    private TextField textField;
    private AbstractWorldMap map;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IllegalArgumentException {
        init();
        this.stage = primaryStage;

        button.setOnAction(event -> {
            MoveDirection[] directions = OptionsParser.parse(textField.getText().split(" "));
            engine.setMoves(directions);
            Thread thread = new Thread(engine);
            thread.start();
        });

        HBox input = new HBox(button, textField);
        VBox mainBox = new VBox(gridPane, input);
        mainBox.setAlignment(Pos.CENTER);
        input.setAlignment(Pos.CENTER);
        Vector2d[] limits = map.findLimits();
        Vector2d high = limits[0];
        Vector2d low = limits[0];

        drawMap();

        int width = high.x * size - low.x * size;
        int height = high.y * size - low.y * size;

        Scene scene = new Scene(mainBox, width, height);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws IllegalArgumentException {
        button = new Button("Start");
        textField = new TextField();
        gridPane = new GridPane();
        map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        int moveDelay = 300;
        engine = new SimulationEngine(map, positions, this, moveDelay);
    }

    public void drawMap() throws FileNotFoundException {
        gridPane.getChildren().clear();
        gridPane = new GridPane();

        Label label = new Label("y/x");
        Map<Vector2d, IMapElement> elements = map.getElements();
        Vector2d low = map.getMapBoundary().findLimits()[0];
        Vector2d high = map.getMapBoundary().findLimits()[1];

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
            VBox elem = new GuiElementBox(element).getvBox();
            Vector2d pos = element.getPosition();
            gridPane.add(elem,  pos.x - low.x + 1, high.y - pos.y + 1);
            GridPane.setHalignment(elem, HPos.CENTER);
        }

        stage.setScene(new Scene(gridPane,800,800));
        stage.show();
    }

    public void draw() {
        Platform.runLater(() -> {
            try {
                drawMap();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
