package io.jagdesh.learn.b_oops;

public class FB_Final_as_method extends Bike2 {
//    void run() {
//        System.out.println("running safely with 100kmph");
//    }

    public static void main(String args[]){
        FB_Final_as_method bike = new FB_Final_as_method();
        bike.run(); // Compile time error
    }
}

class Bike2 {
    final void run() {
        System.out.println("running");
    }
}
