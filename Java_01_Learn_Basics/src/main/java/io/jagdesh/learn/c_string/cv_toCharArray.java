package io.jagdesh.learn.c_string;

public class cv_toCharArray {
    public static void main(String[] args) {
        String str = "Ginger";
        System.out.println();
        char[] characters = str.toCharArray();
        for (char c :  characters) {
            System.out.println(c);
        }
    }
}
