package io.jagdesh.learn.d_streams.zz_streams_examples;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class example3 {
    public static void main(String[] args) throws IOException {

        Collection<String> collection = Arrays.asList("Java", "Spring", "React", "Angular");
        List<String> strList = collection.stream()
                .collect(Collectors.toList());
        System.out.println("\n" + strList + "\n");

        List<String> list = Arrays.asList("Java", "Spring", "Spring", "React", "Angular");
        List<String> strList2 = list.stream()
                .collect(Collectors.toList());
        System.out.println(strList2 + "\n");

        Set<String> set = new HashSet<>(list);
        List<String> strList3 = set.stream()
                .collect(Collectors.toList());
        System.out.println(strList3);

    }
}
