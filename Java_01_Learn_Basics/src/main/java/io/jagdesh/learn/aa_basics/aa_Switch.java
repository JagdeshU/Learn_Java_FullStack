package io.jagdesh.learn.aa_basics;

public class aa_Switch {
    public static void main(String[] args) {
        Character sign = 'j';
        Integer n = Character.getNumericValue(sign);
        switch (sign) {
            case '+':
                System.out.println("Positive");
                System.out.println(n);
                n++;
                System.out.println(n);
                break;
            case '-':
                System.out.println("Negative");
                System.out.println(n);
                break;
            default:
                System.out.println(n);
                n++;
                System.out.println(n);
        }
    }
}
