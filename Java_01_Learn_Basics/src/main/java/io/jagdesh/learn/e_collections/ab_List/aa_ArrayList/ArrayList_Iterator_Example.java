package io.jagdesh.learn.e_collections.ab_List.aa_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_Iterator_Example {
    public static void main(String[] args) {

        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("d");
        arrList.add("dd");
        arrList.add("ddd");
        arrList.add("dddd");
        arrList.add("ddddd");
        System.out.println("\n" + arrList + "\n");

        Iterator<String> it = arrList.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }

    }

}
