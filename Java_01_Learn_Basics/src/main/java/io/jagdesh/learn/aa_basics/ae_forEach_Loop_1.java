package io.jagdesh.learn.aa_basics;

public class ae_forEach_Loop_1 {
    public static void main(String[] args) {
        float[] value = { 10.0f, 20.0f, 15.0f };
        float sum = 0.0f;
        for (float curr : value) {
            sum += curr;
        }
        System.out.println(sum);
    }
}
