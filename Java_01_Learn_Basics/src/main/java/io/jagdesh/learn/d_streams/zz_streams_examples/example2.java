package io.jagdesh.learn.d_streams.zz_streams_examples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class example2 {
    public static void main(String[] args) {

        Stream<String> streamBuilder = Stream.<String>builder()
                .add("a")
                .add("b")
                .add("c")
                .build();
        List<String> strList1 = streamBuilder.collect(Collectors.toList());
        System.out.println();
        System.out.println(strList1);

        Stream<String> streamGenerate = Stream.generate(() -> "element").limit(10);
        List<String> strList2 = streamGenerate.collect(Collectors.toList());
        System.out.println();
        System.out.println(strList2);

        Stream<Integer> streamIterated = Stream.iterate(1, n -> n + 2).limit(5);
        List<Integer> intList1 = streamIterated.collect(Collectors.toList());
        System.out.println();
        System.out.println(intList1);


    }
}
