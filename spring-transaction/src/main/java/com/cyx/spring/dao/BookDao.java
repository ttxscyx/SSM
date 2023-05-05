package com.cyx.spring.dao;

public interface BookDao {
    /*根据图书的id查询图书的价格*/
    Integer getPriceByBookId(Integer bookId);
    /*更新图书的库存*/
    void updateStock(Integer bookId);
    /*更新用户的余额*/
    void updateBalance(Integer userId, Integer price);
}
