package io.jagdesh.learn.d_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class dm_distinct {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        System.out.println();
        stringList.add("Its");
        stringList.add("Morbin");
        stringList.add("Morbin");
        stringList.add("Time ('-')");

        Stream<String> streamValue = stringList.stream();
        List<String> distinctString = streamValue
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctString);
    }
}
