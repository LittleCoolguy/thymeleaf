package com.gao.thymeleaf.service;

import com.gao.thymeleaf.domain.book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: XiaoGao
 * @time: 2021/10/23 12:24
 */
@Service
public class BookServiceImpl implements BookService{
    private static Map<Long,book> mp=new HashMap<>();
    @Override
    public List<book> getAll() {
        return new ArrayList(mp.values());
    }

    @Override
    public void insertBook(book book) {
        book.setId(mp.size()+1L);
        mp.put(book.getId(),book);
    }

    @Override
    public void delete(Long id) {
        mp.remove(id);
    }

    @Override
    public book getBookById(Long bid) {
        return mp.get(bid);
    }

    @Override
    public void updateBook(book book) {
        mp.put(book.getId(),book);
    }
}
