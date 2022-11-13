package agh.ics.oop;
import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap{
    private final int numberOfGrassFields;
    private final Map<Vector2d, Grass> grasses;


    public GrassField(int number){
        this.numberOfGrassFields = number;
        this.grasses = new HashMap<>();
        plantGrass();
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object element =  super.objectAt(position);
        if (element != null) {return element;}
        else{return grasses.get(position);}
    }

    public Vector2d generatePosition(int low, int high){
        return new Vector2d((int) ((Math.random() * (high - low))), (int) ((Math.random() * (high - low))));
    }

    public void plantGrass() {
        int high = (int) Math.floor(Math.sqrt(10 * numberOfGrassFields));
        int low = 0;
        Vector2d position = generatePosition(low, high);
        for (int i = 0; i < numberOfGrassFields; i++){
            while (isOccupied(position)) {position = generatePosition(low, high);}
            Grass grassElement = new Grass(position);
            this.grasses.put(position, grassElement);
        }
    }

    @Override
    public Vector2d[] findLimits() {
        if (animals.size() == 0 && grasses.size() == 0) return new Vector2d[]{new Vector2d(0,0),new Vector2d(0,0)};
        Vector2d low = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d high = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (IMapElement elem: animals.values()) {
            low = low.lowerLeft(elem.getPosition());
            high = high.upperRight(elem.getPosition());
        }

        for (IMapElement elem: grasses.values()) {
            low = low.lowerLeft(elem.getPosition());
            high = high.upperRight(elem.getPosition());
        }
        return new Vector2d[]{low, high};
    }
}