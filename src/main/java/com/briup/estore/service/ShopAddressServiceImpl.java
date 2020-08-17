package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ShopAddress;
import com.briup.estore.dao.ShopAddressMapper;
import com.briup.estore.utils.MybatisSqlSessionFactoryUtil;

public class ShopAddressServiceImpl implements IShopAddressService {

	@Override
	public List<ShopAddress> findAddressByCustId(int custId) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		return mapper.selectAddressByCustId(custId);
	}

	@Override
	public ShopAddress findAddressById(int id) {
		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		ShopAddressMapper mapper = session.getMapper(ShopAddressMapper.class);
		return mapper.selectAddressById(id);
	}

}
