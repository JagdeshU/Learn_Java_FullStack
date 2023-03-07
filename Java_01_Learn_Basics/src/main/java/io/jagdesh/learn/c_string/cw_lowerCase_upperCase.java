package io.jagdesh.learn.c_string;

import java.util.Locale;

public class cw_lowerCase_upperCase {
    public static void main(String[] args) {
        String str = "SEnSeI";
        String lowStr = str.toLowerCase();
        System.out.println("\n" + lowStr);
        lowStr = str.toLowerCase(Locale.ENGLISH);
        System.out.println(lowStr);
        String upStr = str.toUpperCase();
        System.out.println(upStr);
        upStr = str.toUpperCase(Locale.ENGLISH);
        System.out.println(upStr);
    }
}
