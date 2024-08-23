package com.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.lang.annotation.Retention;

public class People {
    private String name;
    @Autowired
    @Qualifier(value = "cat11")
    private Cat cat;
    @Autowired
    private Dog dog;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                ", dog=" + dog +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
