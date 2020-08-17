package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.OrderForm;

public interface OrderFormMapper {

	public void insertOrder(OrderForm orderForm);

	public List<OrderForm> selectOrderFormByCustId(int custId);

	public void deleteOrderFormById(int id);
}
