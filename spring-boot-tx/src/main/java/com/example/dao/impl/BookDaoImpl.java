package com.example.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.BookDao;
import com.example.exception.BookStockException;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private EntityManager entityManager;
	@Override
	public int getBookPriceByIsbn(String isbn) {
		String str = "select price from book where isbn = :isbn";
		Query query = entityManager.createNativeQuery(str);
		query.setParameter("isbn", isbn);
		int firstResult = (int) query.getSingleResult();
		return firstResult;
	}
	@Transactional
	@Override
	public void updateBookStock(String isbn) {
		
		String sql = "select stock from book_stock where isbn = :isbn";
		Query query2 = entityManager.createNativeQuery(sql);
		query2.setParameter("isbn", isbn);
		int singleResult = (int) query2.getSingleResult();
		
		if(singleResult<=0) {
			throw new BookStockException("库存不足！");
		}
		
		String str = "update book_stock set stock = stock-1 where isbn = :isbn  ";
		
		Query query = entityManager.createNativeQuery(str);
		query.setParameter("isbn", isbn);
		int executeUpdate = query.executeUpdate();
	}
	@Transactional
	@Override
	public void updateUserAccount(String userName, int price) {
		String sql = "select balance from account where user_name = :userName";
		Query query2 = entityManager.createNativeQuery(sql);
		query2.setParameter("userName", userName);
		int firstResult = (int) query2.getSingleResult();
		
		if(firstResult<price) {
			throw new BookStockException("余额不足！");
		}
		
		String str = "update account set balance = balance-:price where user_name = :userName  ";
		
		Query query = entityManager.createNativeQuery(str);
		query.setParameter("userName", userName);
		query.setParameter("price", price);
		int executeUpdate = query.executeUpdate();
		
	}

}
