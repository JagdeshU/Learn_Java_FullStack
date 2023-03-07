package io.jagdesh.learn.a_learn;

import java.util.function.Predicate;

public class be_Predicate_Interface_1 {
    public static void main(String[] args) {
        Predicate<Integer> pr = a -> (a > 18);
        System.out.println(pr.test(10));
    }
}
