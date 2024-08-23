package com.service;

import com.dao.BookCaseMapper;
import com.dao.BookMapper;
import com.pojo.Book;
import com.pojo.BookCase;

import java.util.List;

public class BookCaseServiceImpl implements BookCaseService{
    private BookCaseMapper bookCaseMapper;

    public void setBookCaseMapper(BookCaseMapper bookCaseMapper) {
        this.bookCaseMapper = bookCaseMapper;
    }

    @Override
    public List<BookCase> getBookCaseList() {
        return bookCaseMapper.getBookCaseList();
    }

    @Override
    public Book getBookCaseById(int id) {
        return bookCaseMapper.getBookCaseById(id);
    }
}
