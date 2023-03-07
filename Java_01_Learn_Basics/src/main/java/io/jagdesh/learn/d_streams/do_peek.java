package io.jagdesh.learn.d_streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class do_peek {
    public static void main(String[] args) {

        System.out.println();

        Stream.of("One", "Two", "Three", "Four")
                .filter(e -> e.contains("e"))
                .peek(e -> System.out.println("Filtered value : " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped Value : " + e))
                .collect(Collectors.toList());
    }
}
