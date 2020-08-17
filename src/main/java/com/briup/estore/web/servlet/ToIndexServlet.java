package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.service.BookServiceImpl;
import com.briup.estore.service.CategoryServiceImpl;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.ICategoryService;

public class ToIndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ICategoryService cateService = new CategoryServiceImpl();
		List<Category> categorylist = cateService.findFirstWithSecondCategory();
		request.setAttribute("categorylist", categorylist);

		// 查询点击量最高的三本书
		IBookService bookService = new BookServiceImpl();
		List<Book> booklist = bookService.findBookClick();
		request.setAttribute("booklist", booklist);

		// 查询所有书籍
		List<Book> books = bookService.findBooks();
		request.setAttribute("books", books);

		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
