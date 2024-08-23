package com.dao;

import com.pojo.Book;

import java.util.List;

public interface BookMapper {
    //查一本
    Book getBookById(int id);

    //查全部
    List<Book> getBookList();

    //增加
    int addBook(Book book);

    //删除
    int deleteBook(int id);

    //更新
    int updateBook(Book book);

}
