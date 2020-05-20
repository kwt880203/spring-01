package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.BookDao;
import com.example.service.BookService;

@SpringBootTest
class SpringBootTxApplicationTests {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookDao bookDao;
	
	@Test
	void contextLoads() {
		
	}
	@Test
	public void testPurchase() {
		bookService.purchase("AA", "1001");
	}
	@Test
	public void testBookService() {
		bookService.purchase("AA", "1001");
	}
	
	@Test
	public void updateBookStock() {
		bookDao.updateBookStock("1001");
	}
}
