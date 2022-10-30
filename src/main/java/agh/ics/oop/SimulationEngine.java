package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] moves;
    private final IWorldMap map;
    private final ArrayList<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] initialPositions) {
        this.moves = moves;
        this.map = map;
        this.animals = new ArrayList<>();
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
            Animal animal = this.animals.get(i % numberOfAnimals);
            animal.move(this.moves[i]);
        }
    }
}
