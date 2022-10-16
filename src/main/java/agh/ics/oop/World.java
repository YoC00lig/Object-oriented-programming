package agh.ics.oop;

public class World {
    public static void main(String[] args){
        //lab2
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection west = MapDirection.WEST;
        System.out.println(west.toUnitVector());
        System.out.println(west.previous());
        System.out.println(west.next());

        //lab1
        System.out.println("Start.");
        Direction[] dirs = new Direction[args.length];
        for (int i = 0; i < args.length; i++){
            String move = args[i];
            dirs[i] = switch (move){
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "l" -> Direction.LEFT;
                case "r" -> Direction.RIGHT;
                default -> Direction.UNDEFINED;
            };
        }
        run(dirs);
        System.out.println("Stop.");
    }

    public static void run(Direction[] directions){
        for(Direction move: directions){
            String answer = switch (move){
                case FORWARD -> "Zwierzak idzie do przodu.";
                case BACKWARD -> "Zwierzak idzie do tyłu.";
                case LEFT -> "Zwierzak skręca w lewo.";
                case RIGHT -> "Zwierzak skręca w prawo.";
                case UNDEFINED -> null;
            };
            if (answer != null) {System.out.println(answer);}
            }
    }
}


