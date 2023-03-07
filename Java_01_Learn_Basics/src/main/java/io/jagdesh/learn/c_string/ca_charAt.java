package io.jagdesh.learn.c_string;

public class ca_charAt {
    public static void main(String[] args) {

        String str = "Lets learn String Handling";
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(11);
        char ch3 = str.charAt(13);

        System.out.println();
        System.out.println("Character at 0th index = " + ch1);
        System.out.println("Character at 11th index = " + ch2);
        System.out.println("Character at 13th index = " + ch3);
    }
}
