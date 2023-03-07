package io.jagdesh.learn.b_oops;

public class AC_HierarchicalInheritance {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.meow();
        cat.eat();
        // cat.bark();  // Error
    }
}

class Animal3 {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog3 extends Animal3 {
    void bark() {
        System.out.println("Barking...");
    }
}

class Cat extends Animal3 {
    void meow() {
        System.out.println("Meowing...");
    }
}
