package io.jagdesh.learn.aa_basics;

public class ab_While_Loop_1 {
    public static void main(String[] args) {
        int n = 4,
                factorial = 1;

        while (n > 1) {
            factorial *= n;
            n--;
        }
        System.out.println(factorial);
    }
}
