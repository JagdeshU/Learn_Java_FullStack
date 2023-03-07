package io.jagdesh.learn.b_oops;

public class CC_AbstractMethod_in_Interface implements Multiply {

    @Override
    public int multiplyTwo(int n1, int n2) {
        return n1 * n2;
    }

    @Override
    public int multiplyThree(int n1, int n2, int n3) {
        return n1 * n2 * n3;
    }

    public static void main(String[] args) {
        Multiply obj = new CC_AbstractMethod_in_Interface();
        System.out.println(obj.multiplyTwo(3, 7));
        System.out.println(obj.multiplyThree(1, 9, 0));
    }
}

interface Multiply {
    // abstract methods
    public abstract int multiplyTwo(int n1, int n2);
    int multiplyThree(int n1, int n2, int n3);
}
