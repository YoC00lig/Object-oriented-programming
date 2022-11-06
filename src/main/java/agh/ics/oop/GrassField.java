package agh.ics.oop;
import java.util.ArrayList;

public class GrassField extends AbstractWorldMap{
    private final int numberOfGrassFields;
    private final ArrayList<Grass> grasses;


    public GrassField(int number){
        this.numberOfGrassFields = number;
        this.grasses = new ArrayList<>();
        plantGrass();
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null) return super.objectAt(position);
        for (Grass grass: grasses) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
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
            grasses.add(new Grass(position));
        }
    }

    @Override
    public Vector2d[] findLimits() {
        if (animals.size() == 0 && grasses.size() == 0) return new Vector2d[]{new Vector2d(0,0),new Vector2d(0,0)};
        Vector2d low = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d high = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (Animal animal : animals) {
            low = low.lowerLeft(animal.getPosition());
            high = high.upperRight(animal.getPosition());
        }
        for (Grass grass : grasses) {
            low = low.lowerLeft(grass.getPosition());
            high = high.upperRight(grass.getPosition());
        }
        return new Vector2d[]{low, high};
    }
}
