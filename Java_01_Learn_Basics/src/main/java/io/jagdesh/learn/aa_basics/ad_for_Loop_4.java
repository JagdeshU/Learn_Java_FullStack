package io.jagdesh.learn.aa_basics;

public class ad_for_Loop_4 {
    public static void main(String[] args) {
        int[] left = {5, 3, 7};
        int[] right = {12, 9, 8};

        for (int i = 0; i < left.length; i++) {
            int result = left[i] + right[i];
            System.out.println("result = " + result);
        }
    }
}
