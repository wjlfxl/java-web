package com.dao;

import com.bean.BookCase;

import java.util.List;

public interface BookCaseMapper {
    //查询，
    List<BookCase> getBookCaseById(int id);

    List<BookCase> getBookCaseById2(int id);
}
