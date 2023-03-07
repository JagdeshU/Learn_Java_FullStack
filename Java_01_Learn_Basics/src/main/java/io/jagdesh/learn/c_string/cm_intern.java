package io.jagdesh.learn.c_string;

public class cm_intern {
    public static void main(String[] args) {
        String str1 = "Comic Con";
        String str2 = new String("Saw Con");
        String str3 = "Lee Con";
        String str4 = new String("Lee Con");
        System.out.println();
        System.out.println(str2.intern().equals(str1));
        System.out.println(str2.equals(str1));
        str2.intern();
        str1.intern();
        System.out.println();
        System.out.println(str4.intern().equals(str3));
        System.out.println(str4.equals(str3));
        str4.intern();
        str3.intern();
    }
}
