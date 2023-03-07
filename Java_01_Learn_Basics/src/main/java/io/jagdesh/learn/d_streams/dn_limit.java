package io.jagdesh.learn.d_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class dn_limit {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("FBI");
        stringList.add("Open");
        stringList.add("Up");
        System.out.println();

        Stream<String> streamValue = stringList.stream();
        streamValue
                .limit(2)
                .forEach(value -> {
                    System.out.println(value);
                });
    }
}
