package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.OrderLine;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.service.OrderLineServiceImpl;

public class ToOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderFormId = request.getParameter("orderFormId");
		IOrderLineService orderLineService = new OrderLineServiceImpl();
		List<OrderLine> orderline = orderLineService.selectOrderLineByOrderFormId(Integer.parseInt(orderFormId));
		request.getSession().setAttribute("orderline", orderline);
		request.getRequestDispatcher("/WEB-INF/user/orderdetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
