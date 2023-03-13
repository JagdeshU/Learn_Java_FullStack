package io.jagdesh.learn.e_collections.ab_List.aa_ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ag_Searching_Elements_inArrayList {
    public static void main(String[] args) {
        List<String> பழங்கள் = new ArrayList<>();
        பழங்கள்.add("Ananas");
        பழங்கள்.add("Bananas");
        பழங்கள்.add("Apple");
        பழங்கள்.add("Grapes");
        பழங்கள்.add("Orange");
        பழங்கள்.add("Mango");

        System.out.println("\nDoes names array contain \"mango\" ? : " + பழங்கள்.contains("mango"));
        System.out.println("Does names array contain \"Mango\" ? : " + பழங்கள்.contains("Mango"));

        System.out.println("\nindexOf (firstOccurrence) \"Banana\": " + பழங்கள்.indexOf("Banana"));
        System.out.println("indexOf (firstOccurrence) \"Apple\": " + பழங்கள்.indexOf("Apple"));

        System.out.println("\nlastIndexOf (lastOccurrence) \"Watermelon\" : " + பழங்கள்.lastIndexOf("Watermelon"));
        System.out.println("lastIndexOf (lastOccurrence) \"Strawberry\" : " + பழங்கள்.lastIndexOf("Strawberry"));
    }
}
