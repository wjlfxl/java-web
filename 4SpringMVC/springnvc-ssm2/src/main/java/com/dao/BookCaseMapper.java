package com.dao;

import com.pojo.Book;
import com.pojo.BookCase;

import java.util.List;

public interface BookCaseMapper {

    //查全部
    List<BookCase> getBookCaseList();

    //查一本
    Book getBookCaseById(int id);

}
