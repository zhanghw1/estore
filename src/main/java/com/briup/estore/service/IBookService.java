package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;

public interface IBookService {

	public List<Book> findBookClick();

	public List<Book> findBooks();

	public Book findBookByid(int id);

	public List<Book> findBookByCateId(int cateId);

	public List<Book> findBookByCateIdAndClick(int cateId);
}
