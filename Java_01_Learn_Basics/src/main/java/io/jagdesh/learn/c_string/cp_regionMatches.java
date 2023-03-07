package io.jagdesh.learn.c_string;

public class cp_regionMatches {
    public static void main(String[] args) {
        String str = "is that, is that a supraaaa ?";
        String subStr = "supra";
        boolean b = str.regionMatches(0, subStr, str.length(), str.length());
        boolean b1 = str.regionMatches(true, 0, str, 0, str.length());
        System.out.println("\n" + b);
        System.out.println(b1);
    }
}
