package com.service;

import com.dao.BookMapper;
import com.pojo.Book;

import java.util.List;

public class BookServiceImpl implements BookService{
   //service业务层调用dao层，组合dao
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Book getBookById(int id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public List<Book> getBookList() {
        return bookMapper.getBookList();
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }
}
