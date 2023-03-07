package io.jagdesh.learn.c_string;

public class cj_getChars {
    public static void main(String[] args) {
        String s = "Do u have idea how fast I really am ?";
        int start = 10;
        int end = 14;
        char buf[] = new char[end - start];
        s.getChars(start, end, buf, 0);
        System.out.println();
        System.out.println(buf);
    }
}
