package com.example.dao;

public interface BookDao {
	/**
	 * 
	 * @param isbn
	 * @return
	 */
	public int getBookPriceByIsbn(String isbn);
	/**
	 * 
	 * @param isbn
	 */
	public void updateBookStock(String isbn);
	/**
	 * 
	 * @param userName
	 * @param price
	 */
	public void updateUserAccount(String userName,int price);
}
