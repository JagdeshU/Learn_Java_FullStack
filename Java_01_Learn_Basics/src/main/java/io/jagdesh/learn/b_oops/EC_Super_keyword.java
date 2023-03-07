package io.jagdesh.learn.b_oops;

public class EC_Super_keyword {
    public static void main(String[] args) {
        Dog6 d = new Dog6();
    }
}

class Animal6 {
    Animal6() {
        System.out.println("animal is created");
    }
}
class Dog6 extends Animal6 {
    Dog6() {
        super();
        System.out.println("dog is created");
    }
}
