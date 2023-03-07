package io.jagdesh.learn.d_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class dk_map {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("9", "1", "1");
        System.out.println();

        List<Integer> intList1 = stringList.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(intList1);

        List<Integer> intList2 = intList1.stream()
                .map(value -> value * 3)
                .collect(Collectors.toList());
        System.out.println(intList2);

        System.out.println();
        stringList.stream()
                .map(str -> str.length())
                .forEach(System.out::println);

    }
}
