package com.dao;

import com.bean.Book;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMapperImpl extends SqlSessionDaoSupport implements BookMapper{

    @Override
    public List<Book> getBookList() {
        return getSqlSession().getMapper(BookMapper.class).getBookList();
    }

    @Override
    public List<Book> getBookIf(Map map) {
        return getSqlSession().getMapper(BookMapper.class).getBookIf(map);
    }

    @Override
    public List<Book> getBookWhere(Map map) {
        return getSqlSession().getMapper(BookMapper.class).getBookWhere(map);
    }

    @Override
    public List<Book> getBookChoose(Map map) {
        return getSqlSession().getMapper(BookMapper.class).getBookChoose(map);
    }

    @Override
    public int upDateBook(Map map) {
        return getSqlSession().getMapper(BookMapper.class).upDateBook(map);
    }

    @Override
    public List<Book> getBookIn(HashMap map) {
        return getSqlSession().getMapper(BookMapper.class).getBookIn(map);
    }

    @Override
    public List<Book> getBookForeach(Map map) {
        return getSqlSession().getMapper(BookMapper.class).getBookForeach(map);
    }
}
