package io.jagdesh.learn.a_learn;

public class bc_Multiple_Inheritance implements Printable, Showable {
    @Override
    public void print() {
        System.out.println("Print 1...");
    }
    @Override
    public void show() {
        System.out.println("Print 2...");
    }

    public static void main(String[] args) {
        bc_Multiple_Inheritance mh = new bc_Multiple_Inheritance();
        mh.print();
        mh.show();
    }

}

interface Printable {
    void print();
}

interface Showable {
    void show();
}
