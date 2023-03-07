package io.jagdesh.learn.aa_basics;

public class ac_DoWhile_Loop_1 {
    public static void main(String[] args) {
        int iVal = 5;

        do {
            System.out.print(iVal + " * 2 = ");
            iVal *= 2;
            System.out.println(iVal);
        } while (iVal < 25);
    }
}
