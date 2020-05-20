package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BookDao;
import com.example.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Transactional
	@Override
	public void purchase(String userName, String isbn) {
		//书本单价
		int price = bookDao.getBookPriceByIsbn(isbn);
		//更新库存
		bookDao.updateBookStock(isbn);
		//更新用户账户
		bookDao.updateUserAccount(userName, price);
		
	}

}
