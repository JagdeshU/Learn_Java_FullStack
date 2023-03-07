package io.jagdesh.learn.c_string;

public class cl_indexOf {
    public static void main(String[] args) {
        String str = "Rubondese";
        System.out.println();
        // method 1
        int index = str.indexOf("dese");
        System.out.println(index);
        // Remember index starts with 0 so count from 0
        System.out.println("index of on :: " + str.indexOf("on"));
        System.out.println("index of Rub :: " + str.indexOf("Rub"));
        // method 2
        System.out.println(str.indexOf('s'));
        // method 3
        System.out.println(str.indexOf('o', 0));
        // method 4
        System.out.println(str.indexOf("nde", 3));
    }
}
