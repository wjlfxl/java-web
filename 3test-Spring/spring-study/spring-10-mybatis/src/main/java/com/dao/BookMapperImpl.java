package com.dao;

import com.bean.Book;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMapperImpl implements BookMapper{
    ////我们的所有操作，都使用sqLSession来执行，在原来，现在都使川sqLSessionTemplate;
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<Book> getBookList() {
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        return mapper.getBookList();
    }

    @Override
    public List<Book> getBookIf(Map map) {
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        return mapper.getBookIf(map);
    }

    @Override
    public List<Book> getBookWhere(Map map) {
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        return mapper.getBookWhere(map);
    }

    @Override
    public List<Book> getBookChoose(Map map) {
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        return mapper.getBookChoose(map);
    }

    @Override
    public int upDateBook(Map map) {
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        return mapper.upDateBook(map);
    }

    @Override
    public List<Book> getBookIn(HashMap map) {
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        return mapper.getBookIn(map);
    }

    @Override
    public List<Book> getBookForeach(Map map) {
        BookMapper mapper=sqlSession.getMapper(BookMapper.class);
        return mapper.getBookForeach(map);
    }
}
