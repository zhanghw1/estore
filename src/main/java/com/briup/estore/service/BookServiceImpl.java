package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.utils.MybatisSqlSessionFactoryUtil;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> findBookClick() {

		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> booklist = mapper.selectBookClick();
		session.close();
		return booklist;
	}

	@Override
	public List<Book> findBooks() {

		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> booklist = mapper.selectBooks();
		session.close();
		return booklist;
	}

	@Override
	public Book findBookByid(int id) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		Book book = mapper.selectBookById(id);
		// 将书籍点击量加1
		book.setClick(book.getClick() + 1);
		mapper.updateBook(book);
		session.commit();
		session.close();
		return book;
	}

	@Override
	public List<Book> findBookByCateId(int cateId) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> booklist = mapper.selectBookByCateId(cateId);
		session.close();
		return booklist;
	}

	@Override
	public List<Book> findBookByCateIdAndClick(int cateId) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> booklist = mapper.selectBookByCateIdAndClick(cateId);
		session.close();
		return booklist;
	}
}
