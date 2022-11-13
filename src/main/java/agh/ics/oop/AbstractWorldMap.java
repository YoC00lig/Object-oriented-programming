package agh.ics.oop;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, Animal> animals;
    protected abstract Vector2d[] findLimits();


    public AbstractWorldMap() {
        this.animals = new HashMap<>();
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.get(oldPosition);
        animals.put(newPosition, animal);
        animals.remove(oldPosition, animal);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.animals.get(position);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d pos = animal.getPosition();
        if (canMoveTo(pos)) {
            this.animals.put(pos, animal);
            animal.addObserver(this);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.findLimits()[0], this.findLimits()[1]);
    }
}