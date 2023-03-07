package io.jagdesh.learn.e_collections.aa_List.aa_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class af_Iterating_overArrayList {
    public static void main(String[] args) {
        List<String> பழங்கள் = new ArrayList<>();
        பழங்கள்.add("Ananas");
        பழங்கள்.add("Bananas");
        பழங்கள்.add("Apple");
        பழங்கள்.add("Grapes");
        பழங்கள்.add("Orange");
        பழங்கள்.add("Mango");

        System.out.println("\n=== Iterate using Java 8 forEach and lambda ===");
        பழங்கள்.forEach(பழம் -> {
            System.out.println(பழம்);
        });

        System.out.println("\n=== Iterate using an iterator() ===");
        Iterator<String> fruitsIterator = பழங்கள்.iterator();
        while (fruitsIterator.hasNext()) {
            String tvShow = fruitsIterator.next();
            System.out.println(tvShow);
        }

        System.out.println("\n=== Iterate using an iterator() and Java 8 forEachRemaining() method ===");
        fruitsIterator = பழங்கள்.iterator();
        fruitsIterator.forEachRemaining(பழம் -> {
            System.out.println(பழம்);
        });

        System.out.println("\n=== Iterate using a listIterator() to traverse in both directions ===");
        ListIterator<String> listIterator = பழங்கள்.listIterator(பழங்கள்.size());
        while (listIterator.hasPrevious()) {
            String பழம் = listIterator.previous();
            System.out.println(பழம்);
        }

        System.out.println("\n=== Iterate using simple for-each loop ===");
        for (String பழம் : பழங்கள்) {
            System.out.println(பழம்);
        }

        System.out.println("\n=== Iterate using for loop with index ===");
        for (int i = 0; i < பழங்கள்.size(); i++) {
            System.out.println(பழங்கள்.get(i));
        }

    }
}
