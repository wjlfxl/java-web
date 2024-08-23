package com.pojo;

import java.util.*;

public class Student {
    private String name;
    private Address address;
    private String[] book;
    private List<String> habit;
    private Map<String,String> cord;
    private Set<String> games;
    private String wife;
    private Properties info;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address.toString() +
                ", book=" + Arrays.toString(book) +
                ", habit=" + habit +
                ", cord=" + cord +
                ", games=" + games +
                ", wife='" + wife + '\'' +
                ", info=" + info +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getBook() {
        return book;
    }

    public void setBook(String[] book) {
        this.book = book;
    }

    public List<String> getHabit() {
        return habit;
    }

    public void setHabit(List<String> habit) {
        this.habit = habit;
    }

    public Map<String, String> getCord() {
        return cord;
    }

    public void setCord(Map<String, String> cord) {
        this.cord = cord;
    }

    public Set<String> getGames() {
        return games;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }
}