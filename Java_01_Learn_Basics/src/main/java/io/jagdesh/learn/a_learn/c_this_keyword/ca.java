package io.jagdesh.learn.a_learn.c_this_keyword;

//  Using ‘this’ keyword to refer current class instance variables
public class ca {
    int a, b;

    // Parameterized constructor
    ca(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void display() {
        //Displaying value of variables a and b
        System.out.println("a = " + a + "  b = " + b);
    }

    public static void main(String[] args) {
        ca object = new ca(10, 20);
        object.display();
    }
}
