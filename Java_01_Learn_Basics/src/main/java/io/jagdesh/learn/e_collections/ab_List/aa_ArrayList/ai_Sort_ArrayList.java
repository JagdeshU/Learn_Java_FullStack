package io.jagdesh.learn.e_collections.ab_List.aa_ArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ai_Sort_ArrayList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Tony");
        names.add("Tom");
        names.add("Johnson");
        names.add("John");
        names.add("Ramesh");
        names.add("Sanjay");

        System.out.println("\nNames : " + names);

        // Sort an ArrayList using its sort() method. You must pass a Comparator to the ArrayList.sort() method.
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String name1, String name2) {
                return name1.compareTo(name2);
            }
        });
        System.out.println("\nSorted Names 1 : " + names);

        // The above `sort()` method call can also be written simply using lambda expression
        names.sort((name1, name2) -> name1.compareTo(name2));
        System.out.println("Sorted Names 2 : " + names);

        // Following is an even more concise solution
        names.sort(Comparator.naturalOrder());
        System.out.println("Sorted Names 3 : " + names);
    }
}
