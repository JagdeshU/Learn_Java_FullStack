package io.jagdesh.learn.d_streams;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class dp_sorted {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 5, 0, 55, 11, 7, -11, -1, -50, 2);
        List<String> strList = Arrays.asList("Tom", "Clancy's", "Rainbow", "Six", "Siege");

        Stream<Integer> intStream = intList.stream();
        Stream<String> strStream = strList.stream();

        System.out.println();
        System.out.print("The sorted Integer stream : ");
        List<Integer> sortedInt = intStream.sorted()
                        .collect(Collectors.toList());
        System.out.println(sortedInt);

        System.out.println();
        System.out.print("The sorted String stream : ");
        List<String> sortedStr = strStream.sorted()
                .collect(Collectors.toList());
        System.out.println(sortedStr);
    }
}
