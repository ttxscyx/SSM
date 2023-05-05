package com.cyx.spring.controller;

import com.cyx.spring.service.BookService;
import com.cyx.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckoutController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CheckoutService checkoutService;
    public void buyBook(Integer userId,Integer bookId){
        bookService.buybook(userId,bookId);
    }
    public void checkout(Integer userId,Integer[] bookIds){
        checkoutService.checkout(userId,bookIds);
    }
}
