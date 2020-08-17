package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerMapper;
import com.briup.estore.utils.MybatisSqlSessionFactoryUtil;

public class CustomerServiceImpl implements ICustomerService {

	// 用户名不能重复
	@Override
	public void register(Customer customer) throws Exception {

		// 根据用户名查询es_customer,如果查询到一个用户,说明该用户已被占用
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		List<Customer> list = mapper.selectCustomerByName(customer.getName());
		if (list.size() > 0) {
			throw new Exception("该用户名存在,请重新输入");
		} else if (customer.getName().length() == 0 || customer.getPassword().length() == 0) {
			throw new Exception("用户名和密码不能为空,请重新输入");
		} else {
			mapper.insertCustomer(customer);
			session.commit();
			session.close();
		}
	}

	@Override
	public Customer login(String name, String password) throws Exception {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		List<Customer> list = mapper.selectCustomerByName(name);
		if (list.size() == 0) {
			throw new Exception("用户名或密码错误,请重新输入");
		} else {
			for (Customer customer : list) {
				if (!(name.equals(customer.getName()) && password.equals(customer.getPassword()))) {
					throw new Exception("用户名或密码错误,请重新输入");
				}
			}
		}
		session.close();
		return list.get(0);
	}

}
