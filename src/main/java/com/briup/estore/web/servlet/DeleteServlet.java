package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.service.OrderFormServiceImpl;
import com.briup.estore.service.OrderLineServiceImpl;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		String id = request.getParameter("id");
		IOrderLineService orderLineService = new OrderLineServiceImpl();
		orderLineService.deleteOrderLineByOrderFormId(Integer.parseInt(orderId));
		IOrderFormService orderFormService = new OrderFormServiceImpl();
		orderFormService.deleteOrderFormById(Integer.parseInt(orderId));
		@SuppressWarnings("all")
		List<OrderForm> orderlist = (List<OrderForm>) request.getSession().getAttribute("orderlist");
		orderlist.remove(Integer.parseInt(id) - 1);
		request.getRequestDispatcher("/WEB-INF/user/orderlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
