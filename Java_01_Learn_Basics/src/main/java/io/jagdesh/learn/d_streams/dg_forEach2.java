package io.jagdesh.learn.d_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class dg_forEach2 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Take");
        stringList.add("some");
        stringList.add("Copium");
        stringList.add("(;_;)");
        System.out.println();

        Stream<String> streamValue = stringList.stream();
        streamValue.forEach(element -> {
            System.out.println(element);
        });
    }
}
