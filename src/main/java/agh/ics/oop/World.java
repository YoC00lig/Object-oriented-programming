package agh.ics.oop;

public class World {
    public static void main(String[] args){
        // podpunkt 3
        Animal cat = new Animal();
        System.out.println(cat.toString());
        // podpunkt 5
        cat.move(MoveDirection.RIGHT);
        cat.move(MoveDirection.FORWARD);
        cat.move(MoveDirection.FORWARD);
        cat.move(MoveDirection.FORWARD);
        System.out.println(cat.toString());

        MoveDirection[] directions = OptionsParser.parse(args);
        for (MoveDirection step: directions){
            cat.move(step);
        }

        // podpunkt 10
        // Można wykluczyć pojawienie się dwóch zwierząt w jednym miejscu poprzez stworzenie nowej klasy,
        // która dla każdych koordynatów x i y będzie posiadać wartość typu Boolean.
        // Wartośc True będzie oznaczać, że pole jest już zajęte, natomiast False, że jest puste.
    }
}


