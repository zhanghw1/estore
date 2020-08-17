package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.OrderLine;

public interface IOrderLineService {

	public void insertLine(OrderLine orderLine);

	public void deleteOrderLineByOrderFormId(int orderFormId);

	public List<OrderLine> selectOrderLineByOrderFormId(int orderFormId);
}
