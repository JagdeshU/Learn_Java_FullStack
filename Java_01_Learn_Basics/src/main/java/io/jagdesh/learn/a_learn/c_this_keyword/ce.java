package io.jagdesh.learn.a_learn.c_this_keyword;

//  Using ‘this’ keyword to invoke current class method
public class ce {
    void display() {
        // calling function show()
        this.show();
        System.out.println("Inside display function");
    }

    void show() {
        System.out.println("Inside show function");
    }

    public static void main(String[] args) {
        ce obj = new ce();
        obj.display();
    }
}
