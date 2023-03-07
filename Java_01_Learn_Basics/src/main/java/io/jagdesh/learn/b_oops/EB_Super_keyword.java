package io.jagdesh.learn.b_oops;

public class EB_Super_keyword {
    public static void main(String[] args) {
        Dog5 d = new Dog5();
        d.work();
    }
}

class Animal5 {
    void eat() {
        System.out.println("eating...");
    }
}
class Dog5 extends Animal5{
    void eat() {
        System.out.println("eating bread...");
    }
    void bark() {
        System.out.println("barking...");
    }
    void work() {
        super.eat();
        bark();
    }
}
