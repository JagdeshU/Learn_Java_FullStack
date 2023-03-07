package io.jagdesh.learn.a_learn;

import java.util.function.Predicate;

public class be_Predicate_Interface_2 {
    static Boolean checkAge(int age) {
        if (age > 17) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Using Predicate Interface
        Predicate<Integer> predicate = be_Predicate_Interface_2::checkAge;
        // Calling Predicate Method
        boolean result = predicate.test(25);
        System.out.println(result);
    }
}
