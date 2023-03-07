package io.jagdesh.learn.d_streams;

public class dg_forEach3 {
    public static void main(String[] args) {
        Integer[] arr = { 4, 2, 0, 6, 9 };
        int key = 2;
        Boolean found = false;

        //  Check whether the given key value is present inside my array
        for (int num : arr) {
            if (num == key) {
                found = true;
                break;
            }
        }

        //  Check whether the number is found or not
        if (found) {
            System.out.println("\nFound");
        }   else {
            System.out.println("\nNot Found");
        }

    }
}
