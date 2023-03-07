package io.jagdesh.learn.c_string;

public class cu_startsWith {
    public static void main(String[] args) {
        String str = "DragonDee..";
        boolean startWith = str.startsWith("D");
        System.out.println("\nstartWith :: " + startWith);
        // Remember index starts from 0
        boolean startWithOffset = str.startsWith("De", 6);
        System.out.println("startWithOffset :: " + startWithOffset);
    }
}
