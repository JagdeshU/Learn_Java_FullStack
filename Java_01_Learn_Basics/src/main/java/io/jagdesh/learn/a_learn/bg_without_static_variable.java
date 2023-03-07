package io.jagdesh.learn.a_learn;

public class bg_without_static_variable {
    int count = 0;
    bg_without_static_variable(){
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        bg_without_static_variable count1 = new bg_without_static_variable();
        bg_without_static_variable count2 = new bg_without_static_variable();
        bg_without_static_variable count3 = new bg_without_static_variable();
    }

}
