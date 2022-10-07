package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("System wystartował.");
        run(args);
        System.out.println("System zakończył działanie.");
    }

    public static void run(String[] array){
        System.out.println("Zwierzak idzie do przodu.");
        int cnt = 0;
        for(String argument:array){
            cnt++;
            if (cnt == array.length){
                System.out.print(argument);
            } else {
                System.out.print(argument + ", ");
            }
        }
        System.out.println();
    }

}

