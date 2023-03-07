package io.jagdesh.learn.d_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class de_count {
    public static void main(String[] args) {
        List<String> stringValue = new ArrayList<>();
        stringValue.add("One");
        stringValue.add("One");
        stringValue.add("One");
        stringValue.add("Four");

        Stream<String> streamValue = stringValue.stream();
        Long countElements = streamValue.count();
        System.out.println("\n" + countElements);
    }
}
