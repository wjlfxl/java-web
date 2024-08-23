package com.bean;

import java.util.List;

public class BookCase {
    private int id;
    private String name;
    //一个种类有多本书
    private List<Book> books;

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public BookCase(){

    }

    public BookCase(int id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookCase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
