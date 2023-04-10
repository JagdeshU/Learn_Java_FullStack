package io.jagdesh.learn.e_collections.ad_Map.aa_HashMap;

import java.time.LocalDateTime;
import java.util.HashMap;

public class eg {

    public static void main(String[] args) {

        HashMap hm = new HashMap<>();
        hm.put("Idli", 20);
        hm.put("Dosai", 30);
        hm.put("Poori", 30);

        HashMap hm2 = new HashMap<>();
        hm2.putAll(hm);
        System.out.println(hm2.get("Dosai"));
        System.out.println(hm2.containsKey("Poori"));
        System.out.println(hm2.containsValue(25));
        System.out.println(hm2.remove("Poori"));
        System.out.println(hm2);
        System.out.println(hm2.remove("Idli", 20));
        System.out.println(hm2);

    }

}
