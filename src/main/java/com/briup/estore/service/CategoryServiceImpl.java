package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Category;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.utils.MybatisSqlSessionFactoryUtil;

public class CategoryServiceImpl implements ICategoryService {

	@Override
	public List<Category> findFirstWithSecondCategory() {

		SqlSession session = MybatisSqlSessionFactoryUtil.openSession();
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		List<Category> catelist = mapper.selectFirstCategory();
		session.close();
		return catelist;
	}

}
