package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.service.IShopAddressService;
import com.briup.estore.service.ShopAddressServiceImpl;

public class ToConfirmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从session中获取xcustomer
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		// 根据用户的id查询所有的地址信息
		IShopAddressService shopAddressService = new ShopAddressServiceImpl();
		List<ShopAddress> addresslist = shopAddressService.findAddressByCustId(customer.getId());
		request.setAttribute("addresslist", addresslist);
		// 跳转
		request.getRequestDispatcher("/WEB-INF/user/confirm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
