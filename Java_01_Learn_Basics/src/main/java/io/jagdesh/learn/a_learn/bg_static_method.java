package io.jagdesh.learn.a_learn;

public class bg_static_method {
    public static void main(String[] args) {

        Student.change();

        Student s1 = new Student(123,"Jake");
        Student s2 = new Student(456,"Jacque");
        Student s3 = new Student(789,"JGun");

        s1.display();
        s2.display();
        s3.display();
    }
}

class Student {

    int rollNo;
    String name;
    static String college = "ABC";

    //static method to change the value of static variable
    static void change(){
        college = "ABCIST";
    }

    //constructor to initialize the variable
    Student(int r, String n){
        rollNo = r;
        name = n;
    }

    //method to display values
    void display() {
        System.out.println(rollNo + " " + name + " " + college);
    }
}
