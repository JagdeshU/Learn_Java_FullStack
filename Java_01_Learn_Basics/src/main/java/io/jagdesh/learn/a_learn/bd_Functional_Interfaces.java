package io.jagdesh.learn.a_learn;

public class bd_Functional_Interfaces implements sayable {
    @Override
    public void say(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        bd_Functional_Interfaces fi = new bd_Functional_Interfaces();
        fi.say("Allooo");
    }
}

@FunctionalInterface
interface sayable{
    void say(String msg);   // abstract method
}
