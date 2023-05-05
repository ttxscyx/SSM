package com.cyx.spring.service.impl;

import com.cyx.spring.service.BookService;
import com.cyx.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private BookService bookService;

    @Override
    @Transactional
    public void checkout(Integer userId, Integer[] bookIds) {
                for (Integer bookId:bookIds){
                    bookService.buybook(userId,bookId);
                }
    }
}
