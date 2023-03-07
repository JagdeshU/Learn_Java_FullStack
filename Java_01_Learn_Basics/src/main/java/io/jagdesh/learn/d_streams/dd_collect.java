package io.jagdesh.learn.d_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class dd_collect {
    public static void main(String[] args) {
        List<String> stringValue = new ArrayList<>();
        stringValue.add("Why");
        stringValue.add("are");
        stringValue.add("you");
        stringValue.add("running?");

        Stream<String> streamValue = stringValue.stream();
        List<String> stringAsUpperCaseList = streamValue
                .map(value -> value.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("\n" + stringAsUpperCaseList);
    }
}
