package com.gao.thymeleaf.service;

import com.gao.thymeleaf.domain.book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: XiaoGao
 * @time: 2021/10/23 12:21
 */

public interface BookService {
    List<book> getAll();

    void insertBook(book book);

    void delete(Long id);

    book getBookById(Long bid);

    void updateBook(book book);
}
