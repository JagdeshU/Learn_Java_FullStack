package io.jagdesh.learn.c_string;

public class cx_trim {
    public static void main(String[] args) {
        String str = "   Watchu lookin at? ";
        String subStr = str.trim();
        System.out.println("\ntrim the space from given string : " + subStr);
    }
}
