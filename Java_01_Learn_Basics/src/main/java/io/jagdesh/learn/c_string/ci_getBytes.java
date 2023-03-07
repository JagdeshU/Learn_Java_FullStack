package io.jagdesh.learn.c_string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class ci_getBytes {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "hehe";

        // Encodes this String into a sequence of bytes using the platform's
        // default charset, storing the result into a new byte array.
        byte[] bs = str.getBytes();
        System.out.println();
        for (Byte b : bs) {
            System.out.println(b);
        }

        // Encodes this String into a sequence of bytes using the given charset,
        // storing the result into a new byte array.
        byte[] bs1 = str.getBytes(Charset.forName("UTF-8"));
        System.out.println();
        for (byte b : bs1) {
            System.out.println(b);
        }

        // Encodes this String into a sequence of bytes using the given charset,
        // storing the result into a new byte array.
        byte[] bs2 = str.getBytes("UTF-8");
        System.out.println();
        for (byte b : bs2) {
            System.out.println(b);
        }

        byte[] dest = new byte[str.length()];
        str.getBytes(0, str.length(), dest, 0);
        System.out.println();
        for (byte b : dest) {
            System.out.println(b);
        }
    }
}
