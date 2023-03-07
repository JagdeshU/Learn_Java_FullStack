package io.jagdesh.learn.a_learn.c_this_keyword;

//  Using ‘this’ keyword as an argument in the constructor call
public class cf {
    int x = 5;

    // Default Constructor that create a object of A with passing this as an argument in the constructor
    cf() {
        A obj = new A(this);
    }

    void display() {
        System.out.println("Value of x in Class B : " + x);
    }

    public static void main(String[] args) {
        cf obj = new cf();
    }
}

class A {
    cf obj;

    // Parameterized constructor with object of B
    // as a parameter
    A(cf obj)
    {
        this.obj = obj;

        // calling display method of class B
        obj.display();
    }
}
