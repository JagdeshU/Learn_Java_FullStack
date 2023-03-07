package io.jagdesh.learn.c_string;

public class cg_endsWith {
    public static void main(String[] args) {
        String str = "You're 20?";
        String checkStr1 = "re 20";
        String checkStr2 = "'re 20";
        String checkStr3 = "'re 20?";
        String checkStr4 = "re20?";
        System.out.println();
        System.out.println(str.endsWith(checkStr1));
        System.out.println(str.endsWith(checkStr2));
        System.out.println(str.endsWith(checkStr3));
        System.out.println(str.endsWith(checkStr4));
    }
}
