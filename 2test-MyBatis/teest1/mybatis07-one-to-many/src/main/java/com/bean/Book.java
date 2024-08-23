package com.bean;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publish;
    private int pages;
    private int price;
    private int bookcaseid;
    private int abled;

    public Book() { }

    public Book(int id, String name, String author, String publish, int pages, int price, int bookcaseid, int abled) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.pages = pages;
        this.price = price;
        this.bookcaseid = bookcaseid;
        this.abled = abled;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBookcaseid() {
        return bookcaseid;
    }

    public void setBookcaseid(int bookcaseid) {
        this.bookcaseid = bookcaseid;
    }

    public int getAbled() {
        return abled;
    }

    public void setAbled(int abled) {
        this.abled = abled;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", bookcaseid=" + bookcaseid +
                ", abled=" + abled +
                '}';
    }
}