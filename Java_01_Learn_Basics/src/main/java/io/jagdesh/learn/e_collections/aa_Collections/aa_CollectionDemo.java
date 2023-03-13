package io.jagdesh.learn.e_collections.aa_Collections;

import java.util.ArrayList;
import java.util.Collection;

public class aa_CollectionDemo {
    public static void main(String[] args) {

        Collection<String> fruitsCollection = new ArrayList<>();
        fruitsCollection.add("Apple");
        fruitsCollection.add("Mango");
        fruitsCollection.add("Banana");
        System.out.println("\n" + fruitsCollection);

        fruitsCollection.remove("Apple");
        System.out.println("\n" + fruitsCollection);

        System.out.println("\n" + fruitsCollection.contains("Mango") + "\n");

        fruitsCollection.forEach(e -> {
            System.out.println(e);
        });

        fruitsCollection.clear();
        System.out.println("\n" + fruitsCollection);
    }
}
