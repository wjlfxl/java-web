package com.service;

import com.pojo.Book;
import com.pojo.BookCase;

import java.util.List;

public interface BookCaseService {

    //查全部
    List<BookCase> getBookCaseList();

    Book getBookCaseById(int id);

}
