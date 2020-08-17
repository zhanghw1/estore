package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Book;
import com.briup.estore.service.BookServiceImpl;
import com.briup.estore.service.IBookService;

public class ToListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.获取前端传递的二级栏目的id
		String id = request.getParameter("id");
		IBookService bookService = new BookServiceImpl();
		// 2.servlet中根据栏目的id查询所有的书籍信息
		List<Book> booklist = bookService.findBookByCateId(Integer.parseInt(id));
		// 3.servlet中根据栏目的id查询点击量最高的三本书
		List<Book> topBooklist = bookService.findBookByCateIdAndClick(Integer.parseInt(id));
		// 4.将查询到的书籍放到request或session中
		request.setAttribute("booklist", booklist);
		request.setAttribute("topBooklist", topBooklist);
		// 5.跳转
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
