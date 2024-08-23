package com.bean;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publish;
    private int pages;
    private int price;
    //多本书一个种类
    private BookCase bookcase;
    private int abled;

    public Book() { }

    public Book(int id, String name, String author, String publish, int pages, int price, BookCase bookcase, int abled) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.pages = pages;
        this.price = price;
        this.bookcase = bookcase;
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

    public BookCase getBookcase() {
        return bookcase;
    }

    public void setBookcase(BookCase bookcase) {
        this.bookcase = bookcase;
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
                ", bookcase=" + bookcase +
                ", abled=" + abled +
                '}';
    }
}