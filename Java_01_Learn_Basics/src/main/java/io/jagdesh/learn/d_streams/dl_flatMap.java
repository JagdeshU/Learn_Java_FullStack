package io.jagdesh.learn.d_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class dl_flatMap {
    public static void main(String[] args) {
        List<Integer> evens = Arrays.asList(2, 4, 6);
        List<Integer> odds = Arrays.asList(3, 5, 7);
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11);
        System.out.println();

        Stream represent = Stream.of(evens, odds, primes);
        System.out.println("Exact input array values containing the array structure");
        represent.forEach(System.out::println);

        List<Integer> numbers = Stream.of(evens, odds, primes)
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println("\nFlattened List : " + numbers);
    }
}
