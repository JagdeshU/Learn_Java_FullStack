package io.jagdesh.learn.e_collections.aa_List.aa_ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ac_Create_ArrayList_fromAnotherCollection {
    public static void main(String[] args) {

        //  Create an ArrayList
        List<Integer> first5PrimeNumbers = new ArrayList<>();
        first5PrimeNumbers.add(2);
        first5PrimeNumbers.add(3);
        first5PrimeNumbers.add(5);
        first5PrimeNumbers.add(7);
        first5PrimeNumbers.add(11);

        //  Creating an ArrayList from another Collection
        List<Integer> first10PrimeNumbers = new ArrayList<>(first5PrimeNumbers);
        System.out.println("\n" + first10PrimeNumbers);

        List<Integer> next5PrimeNumbers = new ArrayList<>();
        next5PrimeNumbers.add(13);
        next5PrimeNumbers.add(17);
        next5PrimeNumbers.add(19);
        next5PrimeNumbers.add(23);
        next5PrimeNumbers.add(29);

        first10PrimeNumbers.addAll(next5PrimeNumbers);
        System.out.println("\n" + first10PrimeNumbers);

    }
}
