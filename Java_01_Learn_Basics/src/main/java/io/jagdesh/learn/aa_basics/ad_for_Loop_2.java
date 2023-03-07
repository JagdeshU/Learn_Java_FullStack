package io.jagdesh.learn.aa_basics;

public class ad_for_Loop_2 {
    public static void main(String[] args) {
        int factorial = 1;
        for (int n = 3; n > 1; n--) {
            factorial *= n;
            System.out.println(n + " | " + factorial);
        }
        System.out.println("Result : " + factorial);
    }
}
