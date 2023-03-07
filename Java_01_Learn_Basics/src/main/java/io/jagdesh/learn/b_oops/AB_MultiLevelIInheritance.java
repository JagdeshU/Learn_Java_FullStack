package io.jagdesh.learn.b_oops;

public class AB_MultiLevelIInheritance {
    public static void main(String[] args) {
        BabyDog bd = new BabyDog();
        bd.weep();
        bd.bark();
        bd.eat();
    }
}

class Animal2 {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog2 extends Animal2 {
    void bark() {
        System.out.println("Barking...");
    }
}

class BabyDog extends Dog2 {
    void weep() {
        System.out.println("Weeping...");
    }
}
