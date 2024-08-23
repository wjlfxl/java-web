package com.dao;

import com.bean.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BookMapper {

//    //查询，
    List<Book> getBookList();

    //查询作者名或者书名
    //where连接问题很大
    List<Book> getBookIf(Map map);

    //查询作者名或者书名，用<where>标签处理
    List<Book> getBookWhere(Map map);

    //条件执行。类似switch语句
    List<Book> getBookChoose(Map map);

    //根据ID，修改作者和书名
    int upDateBook(Map map);

    //查询某几个Id的数据
    List<Book> getBookIn(HashMap map);

    //查询前N个Id
    List<Book> getBookForeach(Map map);
}
