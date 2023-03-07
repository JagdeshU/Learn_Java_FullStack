package io.jagdesh.learn.c_string;

public class cq_replace {
    public static void main(String[] args) {
        String str = "WHO R U";
        System.out.println("\n--- String  ->  " + str);
        String subStr = str.replace("R", "AM");
        System.out.println("replace String 'R' with String 'AM' from given string : " + subStr);
        subStr = subStr.replace('U', 'I');
        System.out.println("replace char 'U' with char 'I' from given string : " + subStr);
        subStr = str.replaceAll("[A-Z]", "WHO");
        System.out.println(subStr);
        subStr = str.replaceFirst("[A-Z]", "WHO");
        System.out.println(subStr);
        subStr = str.replaceFirst("[a-z]", "WHO");
        System.out.println(subStr);
    }
}
