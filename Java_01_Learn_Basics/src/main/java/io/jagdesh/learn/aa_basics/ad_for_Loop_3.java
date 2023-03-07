package io.jagdesh.learn.aa_basics;

public class ad_for_Loop_3 {
    public static void main(String[] args) {
        float[] value = { 10.0f, 20.0f, 15.0f };
        float sum = 0.0f;
        for (int i = 0; i < value.length; i++) {
            float curr = value[i];
            sum += curr;
        }
        System.out.println(sum);
    }
}
