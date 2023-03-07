package io.jagdesh.learn.a_learn.c_this_keyword;

//  Using this() to invoke current class constructor
public class cb {
    int a, b;

    //Default constructor
    cb() {
        this(10, 20);
        System.out.println("Inside default constructor \n");
    }

    //Parameterized constructor
    cb(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("Inside parameterized constructor");
    }

    public static void main(String[] args) {
        cb obj = new cb();
    }
}
