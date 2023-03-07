package io.jagdesh.learn.d_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class dc_noneMatch {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Rick");
        stringList.add("Morty");

        Stream<String> streamValue = stringList.stream();
        boolean noneMatch = streamValue.noneMatch((element) -> {
           return "Summer".equals(element);
        });
        System.out.println("\n" + noneMatch);
    }
}
