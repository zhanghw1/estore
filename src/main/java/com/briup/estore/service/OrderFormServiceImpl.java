package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.dao.OrderFormMapper;
import com.briup.estore.utils.MybatisSqlSessionFactoryUtil;

public class OrderFormServiceImpl implements IOrderFormService {

	@Override
	public void insertOrder(OrderForm orderForm) {

		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		mapper.insertOrder(orderForm);
		session.commit();
	}

	@Override
	public List<OrderForm> findOrderFormByCustId(int custId) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		return mapper.selectOrderFormByCustId(custId);
	}

	@Override
	public void deleteOrderFormById(int id) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		OrderFormMapper mapper = session.getMapper(OrderFormMapper.class);
		mapper.deleteOrderFormById(id);
		session.commit();
	}

}
