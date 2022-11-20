package agh.ics.oop;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    private final SortedSet<Vector2d> xSet = new TreeSet<>((a, b) -> {
        if(a.x == b.x)
            return a.y - b.y;
        return a.x - b.x;
    });

    private final SortedSet<Vector2d> ySet = new TreeSet<>((a, b) -> {
        if(a.y == b.y)
            return a.x - b.x;
        return a.y - b.y;
    });

    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos){
        xSet.add(newPos);
        ySet.add(newPos);
        if (!xSet.isEmpty()) {
            xSet.remove(oldPos);
            ySet.remove(oldPos);
        }
    }

    public void addCoords(IMapElement element) {
        if (element != null) {
            this.xSet.add(element.getPosition());
            this.ySet.add(element.getPosition());
        }
    }

    public Vector2d[] findLimits() {
        if (xSet.isEmpty()) return new Vector2d[]{new Vector2d(0,0),new Vector2d(0,0)};
        Vector2d low = new Vector2d (xSet.first().x, ySet.first().y);
        Vector2d high =  new Vector2d(xSet.last().x, ySet.last().y);
        return new Vector2d[]{low, high};
    }

}


