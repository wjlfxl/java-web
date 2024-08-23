package com.controller;

import com.pojo.Book;
import com.pojo.BookCase;
import com.service.BookCaseService;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @Autowired
    @Qualifier("BookCaseServiceImpl")
    private BookCaseService bookCaseService;

    //查询全部的书籍，并且返回到一一个书籍展示页面
//    List<Book> getBookList();
    @RequestMapping("/allBook")
    public String BookList(Model model){
        List<Book> bookList= bookService.getBookList();
        model.addAttribute("list",bookList);

        return "show";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addBook";
    }

    //增加
//    int addBook(Book book);
    @RequestMapping("/addBook")
    public String addBook(Book book) {
        bookService.addBook(book);
        //重定向
        return "redirect:/book/allBook";
    }

    //删除
//    int deleteBook(int id);
    @RequestMapping("/del/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        //重定向
        return "redirect:/book/allBook";
    }


    //查一本
//    Book getBookById(int id);
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model,int id){
        Book books= bookService.getBookById(id);
        //将查到的数据传到前端页面
        model.addAttribute("book",books);
        return "updateBook";
    }

    //修改
//    int updateBook(Book book);
    @RequestMapping("/updateBook")
    public String updateBook(Book book) {
        bookService.updateBook(book);
        //重定向
        return "redirect:/book/allBook";
    }

    //模糊查书籍名或作者名
//    List<Book> getBookNameAuthor(String nameAuthor);
    @RequestMapping("/getBookNameAuthor")
    public String getBookNameAuthor(String nameAuthor,Model model) {
        List<Book> bookList= bookService.getBookNameAuthor(nameAuthor);
        //如果没查到就查询全部书籍
        //属性是List<>所以是判断长度
        if (bookList.size()==0){
            bookList= bookService.getBookList();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",bookList);

        //转发
        return "show";
    }




}
