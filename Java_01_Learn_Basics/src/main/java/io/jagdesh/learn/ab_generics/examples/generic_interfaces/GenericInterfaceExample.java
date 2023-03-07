package io.jagdesh.learn.ab_generics.examples.generic_interfaces;

public class GenericInterfaceExample {

    public static void main(String[] args) {
        Integer intOfArray[] = { 4, 2, 0, 6, 9 };
        Character charOfArray[] = { 'L', 'I', 'G', 'M', 'A' };
        String strOfArray[] = {"eat", "code", "sleep"};

        MinMaxImpl<Integer> intMinMax = new MinMaxImpl<Integer>(intOfArray);
        MinMaxImpl<Character> charMinMax = new MinMaxImpl<Character>(charOfArray);
        MinMaxImpl<String> strMinMax = new MinMaxImpl<String>(strOfArray);

        System.out.println("\n" + "Max value in intOfArray: " + intMinMax.max());
        System.out.println("Min value in intOfArray: " + intMinMax.min());

        System.out.println("Max value in charOfArray: " + charMinMax.max());
        System.out.println("Min value in charOfArray: " + charMinMax.min());

        System.out.println("Max value in strOfArray: " + strMinMax.max());
        System.out.println("Min value in strOfArray: " + strMinMax.min());
    }

}

interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}

class MinMaxImpl<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    MinMaxImpl(T[] o) {
        vals = o;
    }

    public T min() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) < 0) {
                v = vals[i];
            }
        }
        return v;
    }

    public T max() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}
