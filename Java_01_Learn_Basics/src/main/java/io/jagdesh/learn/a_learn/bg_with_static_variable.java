package io.jagdesh.learn.a_learn;

public class bg_with_static_variable {

    //will get memory only once and retain its value
    static int count = 0;

    bg_with_static_variable() {
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        bg_with_static_variable count1 = new bg_with_static_variable();
        bg_with_static_variable count2 = new bg_with_static_variable();
        bg_with_static_variable count3 = new bg_with_static_variable();
    }
}
