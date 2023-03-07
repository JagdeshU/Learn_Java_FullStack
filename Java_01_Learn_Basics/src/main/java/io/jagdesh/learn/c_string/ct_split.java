package io.jagdesh.learn.c_string;

public class ct_split {
    public static void main(String[] args) {
        String text = "Java is fun ?";
        // split string from space
        String[] result = text.split(" ");

        System.out.print("\nresult = ");
        for (String str : result) {
            System.out.print(str + ", ");
        }
        System.out.println();
    }
}
