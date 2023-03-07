package io.jagdesh.learn.d_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class da_anyMatch {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("You have no idea");
        stringList.add("How fast I really am");
        stringList.add("Am Fast af boi");

        Stream<String> streamValue = stringList.stream();
        boolean anyMatch = streamValue.anyMatch((value) -> {
            return value.startsWith("Am");
        });
        System.out.println("\n" + anyMatch);
    }
}
