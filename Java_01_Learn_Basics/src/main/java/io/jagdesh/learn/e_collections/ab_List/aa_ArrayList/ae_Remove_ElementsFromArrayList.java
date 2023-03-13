package io.jagdesh.learn.e_collections.ab_List.aa_ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ae_Remove_ElementsFromArrayList {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Ananas");
        fruits.add("Bananas");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Litchi");
        System.out.println("\n" + "List of Fruits : " + fruits);

        fruits.remove(4);
        System.out.println("\n" + "After removing 5th index : " + fruits);

        boolean isRemoveed = fruits.remove("Mango");
        System.out.println("\n" + "After Remove (\"Mango\") : " + fruits);

        List<String> subfruitsList = new ArrayList<>();
        subfruitsList.add("Ananas");

        fruits.removeAll(subfruitsList);
        System.out.println("After removeAll (subfruitsList) : " + fruits);

        fruits.clear();
        System.out.println("\n" + "After clear() : " + fruits);

    }
}
