package io.jagdesh.learn.e_collections.aa_List.aa_ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ab_Null_Duplicate_Values {
    public static void main(String[] args) {
        nullValueDemo();
        duplicateValueDemo();
    }

    private static void nullValueDemo() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println("\n" + list.toString());
    }

    private static void duplicateValueDemo() {
        List<String> list = new ArrayList<>();
        list.add("duplicate");
        list.add("duplicate");
        System.out.println("\n" + list.toString());
    }
}
