package io.jagdesh.learn.c_string;

public class cn_lastIndexOf {
    public static void main(String[] args) {

        String str = "SideKicks";

        //  method 1
        int lastIndexOf = str.lastIndexOf('s');
        System.out.println("\n last index of given character 's' in '" + str + "' :: " + lastIndexOf);

        // method 2
        lastIndexOf = str.lastIndexOf("Kicks");
        System.out.println(" last index of given string 'Kicks' in '" + str + "' :: " + lastIndexOf);

        // method 3
        lastIndexOf = str.lastIndexOf("Kicks", 4);
        System.out.println(" last index of Kicks in given string '" + str + "' and from index :: " + lastIndexOf);

        // method 4
        lastIndexOf = str.lastIndexOf('K', str.length());
        System.out.println(" last index of given char :: " + lastIndexOf);

    }
}
