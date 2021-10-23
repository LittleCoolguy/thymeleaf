package com.gao.thymeleaf.controller;

import com.gao.thymeleaf.domain.book;
import com.gao.thymeleaf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

/**
 * @description:
 * @author: XiaoGao
 * @time: 2021/10/23 12:17
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {
    private static final  String BOOK_FORM_PATH_NAME="bookForm";
    private static final  String BOOK_LIST_PATH_NAME="bookList";
    private static final  String REDIRECT_TO_BOOK_URL="redirect:/book";
    @Autowired
    BookService bookService;


    @RequestMapping(method = RequestMethod.GET)
    public String getBookList(ModelMap map){
        map.addAttribute("bookList",bookService.getAll());
        return BOOK_LIST_PATH_NAME;
    }

    /**
     * 获取BookForm表单
     * @param map
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createBookForm(ModelMap map){
        map.addAttribute("book",new book());
        map.addAttribute("action","create");
        //这里的action是用来确定Form中提交的路径是/book/create还是/book/update
        return BOOK_FORM_PATH_NAME;
    }
    /**
     * 创建Book
     * 处理/book/create的post请求
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postBook(@ModelAttribute book book){
        bookService.insertBook(book);
        return REDIRECT_TO_BOOK_URL;
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return REDIRECT_TO_BOOK_URL;
    }
    @RequestMapping(value = "/update/{bid}", method = RequestMethod.GET)
    public String updateBook(@PathVariable Long bid,ModelMap map){
        map.addAttribute("book",bookService.getBookById(bid));
        map.addAttribute("action","update");
        return BOOK_FORM_PATH_NAME;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBook(book book){
        bookService.updateBook(book);
        return REDIRECT_TO_BOOK_URL;
    }
}
