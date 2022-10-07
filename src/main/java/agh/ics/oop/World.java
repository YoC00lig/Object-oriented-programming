package agh.ics.oop;

public class World {
    public static void main(String[] args){
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


