package io.jagdesh.learn.b_oops;

public class FC_Final_class
        //extends Bike3
        {

    void run() {
        System.out.println("running safely with 100kmph");
    }

    public static void main(String[] args) {
        FC_Final_class bike= new FC_Final_class();
        bike.run(); // Compile time error
    }
}

final class Bike3 {}
