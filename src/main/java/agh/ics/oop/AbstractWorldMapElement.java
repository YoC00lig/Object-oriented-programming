package agh.ics.oop;

public abstract class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;

    abstract public String getPath();

    public AbstractWorldMapElement(Vector2d initialPosition){
        this.position = initialPosition;
    }

    public boolean isAt(Vector2d pos) {
        return this.position.equals(pos);
    }

    @Override
    public Vector2d getPosition() {
        return this.position;
    }
}