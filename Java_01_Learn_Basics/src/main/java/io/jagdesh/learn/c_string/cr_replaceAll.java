package io.jagdesh.learn.c_string;

public class cr_replaceAll {
    public static void main(String[] args) {
        String str = "gg";
        String subStr = str.replaceAll("[a-z]", "java");
        System.out.println("\n" + subStr);
    }
}
