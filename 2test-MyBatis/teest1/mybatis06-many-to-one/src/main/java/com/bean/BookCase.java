package com.bean;

public class BookCase {
    private int id;
    private String name;

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

    public BookCase(){

    }

    public BookCase(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookCase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
