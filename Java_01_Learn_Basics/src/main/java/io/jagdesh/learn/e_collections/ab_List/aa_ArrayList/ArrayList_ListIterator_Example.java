package io.jagdesh.learn.e_collections.ab_List.aa_ArrayList;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayList_ListIterator_Example {

    public static void main(String[] args) {

        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("d");
        arrList.add("dd");
        arrList.add("ddd");
        arrList.add("dddd");
        arrList.add("ddddd");
        System.out.println("\n" + arrList + "\n");

        ListIterator<String> iterator = arrList.listIterator(2);
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }

    }

}
