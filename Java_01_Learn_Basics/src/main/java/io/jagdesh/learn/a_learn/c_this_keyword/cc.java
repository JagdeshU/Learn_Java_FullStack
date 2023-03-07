package io.jagdesh.learn.a_learn.c_this_keyword;

//  Using ‘this’ keyword to return the current class instance
public class cc {
    int a, b;

    //Default constructor
    cc() {
        a = 10;
        b = 20;
    }

    //Method that returns current class instance
    cc get() {
        return this;
    }

    //Displaying value of variables a and b
    void display() {
        System.out.println("a = " + a + "  b = " + b);
    }

    public static void main(String[] args) {
        cc object = new cc();
        object.get().display();
    }
}
