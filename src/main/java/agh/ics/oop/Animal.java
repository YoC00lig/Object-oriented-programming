package agh.ics.oop;

public class Animal implements IMapElement{
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
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
        switch (direction) {
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case FORWARD -> {
                Vector2d newPos = this.position.add(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newPos)) {
                    this.position = newPos;
                }
            }
            case BACKWARD -> {
                Vector2d newPos = this.position.subtract(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newPos)) {
                    this.position = newPos;
                }
            }
    }
}
}
