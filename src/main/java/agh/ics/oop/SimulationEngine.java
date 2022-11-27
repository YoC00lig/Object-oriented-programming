package agh.ics.oop;
import java.util.ArrayList;
import agh.ics.oop.gui.App;

public class SimulationEngine implements IEngine, Runnable {
    private  MoveDirection[] moves;
    private final IWorldMap map;
    private final ArrayList<Animal> animals;
    private final int moveDelay;
    private final App application;

    public SimulationEngine(IWorldMap map, Vector2d[] initialPositions, App application, int moveDelay) {
        this.map = map;
        this.animals = new ArrayList<>();
        this.moveDelay = moveDelay;
        this.application = application;

        for (Vector2d position : initialPositions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {this.animals.add(animal);}
        }
    }

    @Override
    public void run() {
        if (animals.size() == 0) {
            return;
        }
        int size = this.moves.length;
        int numberOfAnimals = this.animals.size();

        for (int i = 0; i < size; i++) {
            try {
                Thread.sleep(this.moveDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Animal animal = this.animals.get(i % numberOfAnimals);
            animal.move(this.moves[i]);
            application.draw();

        }
    }

    public void setMoves(MoveDirection[] moves) {
        this.moves = moves;
    }

}
