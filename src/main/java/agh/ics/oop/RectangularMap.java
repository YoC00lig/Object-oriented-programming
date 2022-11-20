package agh.ics.oop;
public class RectangularMap extends AbstractWorldMap {
    private final Vector2d upperRight;
    private final Vector2d lowerLeft;

    public RectangularMap(int width, int height) {
        this.upperRight = new Vector2d(width-1 , height-1);
        this.lowerLeft = new Vector2d(0,0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(this.lowerLeft) && position.precedes(this.upperRight);
    }
    @Override
    public Vector2d[] findLimits() {
        return new Vector2d[]{this.lowerLeft, this.upperRight};
    }

}