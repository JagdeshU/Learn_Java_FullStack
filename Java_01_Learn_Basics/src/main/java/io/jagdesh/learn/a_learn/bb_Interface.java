package io.jagdesh.learn.a_learn;

public class bb_Interface {
    public static void main(String[] args) {
        Drawable drawable = new Circle();
        drawable.draw();
        Drawable drawable2 = new Rectangle();
        drawable2.draw();
    }
}

interface Drawable {
    void draw();
}

class Rectangle implements Drawable {

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle...");
    }
}

class Circle implements Drawable {

    @Override
    public void draw() {
        System.out.println("Drawing Circle...");
    }
}
