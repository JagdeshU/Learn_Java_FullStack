package io.jagdesh.learn.b_oops;

public class CB_AbstractMethod_in_AbstractClass extends Sum {
    // If I don't provide the implementation of these two methods, the program will throw compilation error.
    public int sumOfTwo(int num1, int num2){
        return num1+num2;
    }
    public int sumOfThree(int num1, int num2, int num3){
        return num1+num2+num3;
    }

    public static void main(String[] args) {
        Sum obj = new CB_AbstractMethod_in_AbstractClass();
        System.out.println(obj.sumOfTwo(3, 7));
        System.out.println(obj.sumOfThree(4, 3, 19));
        obj.display();
    }
}

abstract class Sum {
    // These two are abstract methods, the child class must implement these methods.
    public abstract int sumOfTwo(int n1, int n2);
    public abstract int sumOfThree(int n1, int n2, int n3);

    public void display(){
        System.out.println("Method of class Sum");
    }
}
