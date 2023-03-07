package io.jagdesh.learn.d_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class db_allMatch {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Thomas Shelby");
        stringList.add("Arthur Shelby");
        stringList.add("John Shelby");

        Stream<String> streamValue = stringList.stream();
        boolean allMatch = streamValue.allMatch((value) -> {
           return value.contains("Shelby");
        });
        System.out.println("\n" + allMatch);
    }
}
