package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Customer;

public interface CustomerMapper {

	public void insertCustomer(Customer customer);

	public List<Customer> selectCustomerByName(String name);
}
