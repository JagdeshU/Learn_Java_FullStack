package io.jagdesh.learn.d_streams;

import java.util.ArrayList;
import java.util.List;

public class df_findAny_findFirst {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Allo");
        stringList.add("");
        stringList.add(null);

        System.out.println("\n" + stringList.stream().findAny());
        System.out.println(stringList.stream().findFirst());
    }
}
