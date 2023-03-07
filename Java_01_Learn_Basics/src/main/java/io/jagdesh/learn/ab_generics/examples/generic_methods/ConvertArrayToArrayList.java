package io.jagdesh.learn.ab_generics.examples.generic_methods;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertArrayToArrayList {
    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }
    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a).map(mapperFunction).collect(Collectors.toList());
    }
    public static <T extends Number> List<T> fromArrayToListWithUpperBound(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // testing the generic method with Integer
        Integer[] intArray = { 4, 2, 0, 6, 9 };
        List<Integer> list = fromArrayToList(intArray);
        System.out.println("\n" + list.stream().collect(Collectors.toList()));

        // testing the generic method with String
        String[] stringArray = { "BAM", "BAM", "FBI", "Open", "UP" };
        List<String> strList = fromArrayToList(stringArray);
        System.out.println(strList.stream().collect(Collectors.toList()));

        // testing the generic method with Integer and String type
        Integer[] intArr = { 6, 9, 4, 2, 0 };
        List<String> stringList = fromArrayToList(intArr, Object::toString);
        System.out.println(stringList.stream().collect(Collectors.toList()));
    }
}
