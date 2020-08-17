package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.OrderLine;

public interface OrderLineMapper {

	public void insertLine(OrderLine orderLine);

	public void deleteOrderLineByOrderFormId(int orderFormId);

	public List<OrderLine> selectOrderLineByOrderFormId(int orderFromId);
}
