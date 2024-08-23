package com.dao;

import com.bean.Book;

import java.util.List;


public interface  BookMapper {

    //查询，
    List<Book> getBookList();

    //查询2
    List<Book> getBookList2();

}
