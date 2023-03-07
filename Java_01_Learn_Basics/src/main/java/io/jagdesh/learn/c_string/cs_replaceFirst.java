package io.jagdesh.learn.c_string;

public class cs_replaceFirst {
    public static void main(String[] args) {
        String str = "Cold";
        String subStr = str.replaceFirst("[a-z]", "java");
        System.out.println('\n' + subStr);
    }
}
