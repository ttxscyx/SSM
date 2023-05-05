package com.cyx.spring.service;
/*
* 结账
* */
public interface CheckoutService {
    void checkout(Integer userId, Integer[] bookIds);
}
