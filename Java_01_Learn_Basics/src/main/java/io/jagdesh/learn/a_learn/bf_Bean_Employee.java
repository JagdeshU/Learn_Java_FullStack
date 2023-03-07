package io.jagdesh.learn.a_learn;

import java.io.Serializable;

public class bf_Bean_Employee implements Serializable {
    private int id;
    private String name;

    public bf_Bean_Employee(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
