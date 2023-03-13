package io.jagdesh.learn.e_collections.ab_List.aa_ArrayList.ah_Arraylist_ofUserDefined_Objects;

import java.util.ArrayList;
import java.util.List;

public class ArrayListUserDefinedObjectExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ramesh", "ABC"));
        students.add(new Student("Prakash", "ABC"));
        students.add(new Student("Tony", "ABC"));
        System.out.println();

        students.forEach(user -> {
            System.out.println("Name : " + user.getName() + ", College : " + user.getCollege());
        });
    }
}
