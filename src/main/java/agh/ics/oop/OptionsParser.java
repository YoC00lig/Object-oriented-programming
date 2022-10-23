package agh.ics.oop;

public class OptionsParser {

    public static MoveDirection[] parse(String[] args) {

        int size = 0;
        for (String move : args) {
            int element = switch (move) {
                case "forward", "f", "backward", "b", "left", "l", "right", "r" -> 1;
                default -> 0;
            };
            size += element;
        }

        int idx = 0;
        MoveDirection[] directions = new MoveDirection[size];

        for (String move : args){
            MoveDirection ans = switch (move){
                case "forward", "f" -> MoveDirection.FORWARD;
                case "backward", "b" -> MoveDirection.BACKWARD;
                case "left", "l" -> MoveDirection.LEFT;
                case "right", "r" -> MoveDirection.RIGHT;
                default -> null;
            };

            if (ans != null) {
                directions[idx] = ans;
                idx++;
            }
        }

        return directions;
    }
}
