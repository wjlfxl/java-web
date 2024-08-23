package com.dao;

import com.bean.BookCase;

public interface BookCaseMapper {

    //查询，按id查询，
    BookCase getBookCaseById(int id);
}
