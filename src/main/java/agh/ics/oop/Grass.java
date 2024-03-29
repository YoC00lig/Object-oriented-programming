package agh.ics.oop;

public class Grass implements IMapElement{
    private final Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    @Override
    public Vector2d getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return "*";
    }

    public String getPath(IMapElement object) {
        return "src/main/resources/grass.png";
    }
}