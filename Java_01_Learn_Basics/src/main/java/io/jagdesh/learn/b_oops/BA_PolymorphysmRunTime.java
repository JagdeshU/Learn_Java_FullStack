package io.jagdesh.learn.b_oops;

public class BA_PolymorphysmRunTime {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape = new Rectangle();
        shape.draw();
        shape = new Circle();
        shape.draw();
        shape = new Triangle();
        shape.draw();
    }
}

class Shape {
    void draw() {
        System.out.println("Drawing...");
    }
}

class Rectangle extends Shape {
    void draw() {
        System.out.println("Drawing Rectangle...");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle...");
    }
}

class Triangle extends Shape {
    void draw() {
        System.out.println("Drawing Triangle...");
    }
}
