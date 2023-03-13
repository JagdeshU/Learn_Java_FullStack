package io.jagdesh.learn.e_collections.ab_List.aa_ArrayList.ah_Arraylist_ofUserDefined_Objects;

public class Student {

    private String name;
    private String college;

    public Student(String name, String college) {
        this.name = name;
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
