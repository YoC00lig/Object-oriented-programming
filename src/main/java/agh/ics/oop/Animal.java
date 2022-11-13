package agh.ics.oop;
import java.util.List;
import java.util.ArrayList;

public class Animal implements IMapElement{
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private final List<IPositionChangeObserver> observers = new ArrayList<>();
    private final IWorldMap map;

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.position = initialPosition;
        this.map = map;
    }
    public String toString() {
        return switch (this.orientation) {
            case SOUTH -> "S";
            case WEST -> "W";
            case NORTH -> "N";
            case EAST -> "E";
        };
    }

    void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }
    void removeObserver (IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public boolean isAt(Vector2d Position){
        return this.position.equals(Position);
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public void move(MoveDirection direction) {
        Vector2d oldPosition = this.position;
        switch (direction) {
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                    positionChanged(oldPosition, newPosition);
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                    positionChanged(oldPosition, newPosition);
                }
            }
        }
    }
}
