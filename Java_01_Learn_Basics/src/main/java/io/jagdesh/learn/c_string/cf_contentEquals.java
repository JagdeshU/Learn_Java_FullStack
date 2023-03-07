package io.jagdesh.learn.c_string;

public class cf_contentEquals {
    public static void main(String[] args) {
        String str = "Hehe Boi BADWOR7H";
        String check1 = "hehe boi badwor7H";
        String check2 = "HeheBoi BADWOR7H";
        String check3 = "Hehe Boi BADWOR7H";
        boolean isContentEquals1 = str.contentEquals(check1);
        boolean isContentEquals2 = str.contentEquals(check2);
        boolean isContentEquals3 = str.contentEquals(check3);
        System.out.println();
        System.out.println(isContentEquals1);
        System.out.println(isContentEquals2);
        System.out.println(isContentEquals3);
    }
}
