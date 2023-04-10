package io.jagdesh.learn.e_collections.ac_Set.aa_HashSet;

import java.util.HashSet;

public class eg {

    public static void main(String[] args) {

        HashSet hs = new HashSet<>();
        hs.add(1);
        hs.add(3);
        hs.add("Jakki");
        hs.add(1);
        hs.add(2);
        hs.add("Jakki");
        System.out.println(hs);

        Object[] ob = hs.toArray();
        for (Object o : ob) {
            System.out.println(o);
        }

    }

}
