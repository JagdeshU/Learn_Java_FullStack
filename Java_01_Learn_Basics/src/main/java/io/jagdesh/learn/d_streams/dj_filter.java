package io.jagdesh.learn.d_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class dj_filter {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("His", "name", "is", "John", "Xyna", "XD");
        System.out.println();
        List<String> result = stringList.stream()
                .filter(line -> !line.contains("X"))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
