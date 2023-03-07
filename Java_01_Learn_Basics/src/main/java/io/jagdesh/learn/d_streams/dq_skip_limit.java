package io.jagdesh.learn.d_streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class dq_skip_limit {
    public static void main(String[] args) {
        Stream<Integer> evenNumInfiniteStream = Stream.iterate(0, n -> n + 2);
        System.out.println();
        List<Integer> intList = evenNumInfiniteStream
                .skip(5)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(intList);
    }
}
