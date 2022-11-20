package agh.ics.oop;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, IMapElement> elements;
    protected abstract Vector2d[] findLimits();
    protected MapBoundary boundary = new MapBoundary();

    public AbstractWorldMap() {
        this.elements = new HashMap<>();
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        IMapElement animal = elements.get(oldPosition);
        elements.put(newPosition, animal);
        elements.remove(oldPosition, animal);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return this.elements.get(position);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d pos = animal.getPosition();
        if (canMoveTo(pos)) {
            this.elements.put(pos, animal);
            animal.addObserver(this);
            animal.addObserver(boundary);
            boundary.addCoords(animal);
            return true;
        }
        else {
            throw new IllegalArgumentException(animal.getPosition().toString() + ": It is outside map boundary or occupied.");
        }
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.findLimits()[0], this.findLimits()[1]);
    }

    public MapBoundary getMapBoundary() {
        return boundary;
    }

    public Map<Vector2d, IMapElement> getElements() {
        return elements;
    }
}