package io.jagdesh.learn.a_learn.bh_Generics;

public class GenericsExample {
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer(5);
        System.out.println();
        printer.print();

        Printer<Double> dbPrinter = new Printer<>(20.0);
        System.out.println();
        dbPrinter.print();
    }
}
