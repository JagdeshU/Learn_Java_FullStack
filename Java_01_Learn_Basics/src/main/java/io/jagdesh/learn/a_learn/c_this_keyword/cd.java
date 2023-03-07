package io.jagdesh.learn.a_learn.c_this_keyword;

//  Using ‘this’ keyword as method parameter
public class cd {
    int a, b;

    // Default constructor
    cd() {
        a = 10;
        b = 20;
    }

    // Method that receives 'this' keyword as parameter
    void display(cd obj) {
        System.out.println("a = " +obj.a + "  b = " + obj.b);
    }

    // Method that returns current class instance
    void get() {
        display(this);
    }

    public static void main(String[] args) {
        cd object = new cd();
        object.get();
    }
}
