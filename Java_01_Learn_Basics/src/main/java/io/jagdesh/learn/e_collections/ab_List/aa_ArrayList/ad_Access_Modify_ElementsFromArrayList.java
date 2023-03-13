package io.jagdesh.learn.e_collections.ab_List.aa_ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ad_Access_Modify_ElementsFromArrayList {
    public static void main(String[] args) {

        //  Check if Arraylist is Empty
        List<String> topProgLang = new ArrayList<>();
        System.out.println("\n" + "Is the topProgLang list empty ? : " + topProgLang.isEmpty());

        topProgLang.add("C");
        topProgLang.add("C++");
        topProgLang.add(".Net");
        topProgLang.add("Java");
        topProgLang.add("Python");
        topProgLang.add("Go-Lang");

        //  Find the size of an ArrayList
        System.out.println("\n" + "here are the top " + topProgLang.size() + " Programming Languages in the world");
        System.out.println(topProgLang);

        //  Retrieve the element at a given index
        String bestProgLang = topProgLang.get(3);
        String secondBestProgLang = topProgLang.get(4);
        String dotNetProgLang = topProgLang.get(topProgLang.size() - 3);

        System.out.println("\n" + "Best Programming Language : " + bestProgLang);
        System.out.println("Second Best Programming Language : " + secondBestProgLang);
        System.out.println("Dot Net Programming Language : " + dotNetProgLang);

        //  Modify the element at a given index
        topProgLang.set(2, "C#");
        System.out.println("\n" + "Modified Top Programming Language List : " + topProgLang);

    }
}
