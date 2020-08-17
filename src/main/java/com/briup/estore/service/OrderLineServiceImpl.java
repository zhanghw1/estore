package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderLine;
import com.briup.estore.dao.OrderLineMapper;
import com.briup.estore.utils.MybatisSqlSessionFactoryUtil;

public class OrderLineServiceImpl implements IOrderLineService {

	@Override
	public void insertLine(OrderLine orderLine) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
		mapper.insertLine(orderLine);
		session.commit();
	}

	@Override
	public void deleteOrderLineByOrderFormId(int orderFormId) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
		mapper.deleteOrderLineByOrderFormId(orderFormId);
		session.commit();
	}

	@Override
	public List<OrderLine> selectOrderLineByOrderFormId(int orderFormId) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		OrderLineMapper mapper = session.getMapper(OrderLineMapper.class);
		return mapper.selectOrderLineByOrderFormId(orderFormId);
	}
}
