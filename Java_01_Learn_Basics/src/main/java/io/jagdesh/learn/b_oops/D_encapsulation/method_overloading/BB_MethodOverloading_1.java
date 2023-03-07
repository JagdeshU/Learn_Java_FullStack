package io.jagdesh.learn.b_oops.D_encapsulation.method_overloading;

public class BB_MethodOverloading_1 {
    public static void main(String[] args) {
        BB_MethodOverloading_1 me = new BB_MethodOverloading_1();
        System.out.println(me.sum(10, 20));
        System.out.println(me.sum(11, 12, 15));
        System.out.println(me.sum(11.5, 5.5));
    }

    // Overloaded Sums
    public int sum(int x, int y) {
        return (x + y);
    }
    public int sum(int x, int y, int z) {
        return (x + y + z);
    }
    public double sum(double x, double y) {
        return (x + y);
    }

}
