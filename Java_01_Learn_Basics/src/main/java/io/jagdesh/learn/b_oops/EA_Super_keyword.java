package io.jagdesh.learn.b_oops;

public class EA_Super_keyword {
    public static void main(String[] args) {
        Dog4 d=new Dog4();
        d.printColor();
    }
}

class Animal4 {
    String color = "white";
}

class Dog4 extends Animal4 {
    String color = "black";

    void printColor() {
        System.out.println(color);  // prints color of Dog class
        System.out.println(super.color);    // prints color of Animal class
    }
}
