package agh.ics.oop;

public class GrassField extends AbstractWorldMap{
    private final int numberOfGrassFields;


    public GrassField(int number){
        this.numberOfGrassFields = number;
        plantGrass();
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object element =  super.objectAt(position);
        if (element != null) {return element;}
        else{return elements.get(position);}
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
            this.elements.put(position, grassElement);
            boundary.addCoords(grassElement);
        }
    }

    @Override
    public Vector2d[] findLimits() {
        return boundary.findLimits();
    }
}