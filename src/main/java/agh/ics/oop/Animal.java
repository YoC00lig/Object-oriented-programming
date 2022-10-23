package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString() {
        return "(" + this.orientation + ", " + this.position + ")";
    }

    public boolean isAt(Vector2d Position){
        return this.position.equals(Position);
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public void move(MoveDirection direction) {
        Vector2d newPos;
        int maxSize = 5;

        switch (direction) {
            case LEFT -> {
                this.orientation = this.orientation.previous();
                return;
            }
            case RIGHT -> {
                this.orientation = this.orientation.next();
                return;
            }
            case FORWARD -> newPos = this.position.add(this.orientation.toUnitVector());
            case BACKWARD -> newPos = this.position.subtract(this.orientation.toUnitVector());
            default -> {
                return;
            }
        }

        if (newPos.x < maxSize && newPos.y < maxSize && newPos.x >= 0 && newPos.y >= 0) {
            this.position = newPos;
        }
    }
}
