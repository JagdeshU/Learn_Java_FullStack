package io.jagdesh.learn.b_oops.D_encapsulation.method_overriding;

//  Driver Class
public class BC_MethodOverriding_2 {
    public static void main(String[] args) {
        // If a Parent type reference refers to a Parent object, then Parent's show is called
        Parent2 obj1 = new Parent2();
        obj1.show();

        // If a Parent type reference refers to a Child object Child's show()is called.
        // This is called RUN TIME POLYMORPHISM.
        Parent2 obj2 = new Child2();
        obj2.show();
    }
}

// Base Class
class Parent2 {
    void show() {
        System.out.println("Parent's show()");
    }
}

// Inherited class
class Child2 extends Parent2 {
    // This method overrides show() of Parent2
    @Override
    void show() {
        System.out.println("Child's show()");
    }
}
