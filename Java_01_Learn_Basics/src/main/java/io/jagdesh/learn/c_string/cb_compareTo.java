package io.jagdesh.learn.c_string;

public class cb_compareTo {
    public static void main(String[] args) {
        String s1="hello";
        String s2="hello";
        String s3="world";
        String s4="hemlo";
        String s5="flag";

        System.out.println(s1.compareTo(s2)); // 0 because both are equal
        System.out.println(s1.compareTo(s3)); // -15 cuz 'h' 15 times lower than 'w'
        System.out.println(s1.compareTo(s4)); // -1 cuz 'h' is 1 time lower than 'm'
        System.out.println(s1.compareTo(s5)); // +2 cuz 'h' is two times greater than 'f'
    }
}
