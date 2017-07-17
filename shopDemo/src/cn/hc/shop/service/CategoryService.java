package cn.hc.shop.service;

import java.util.List;

import cn.hc.shop.entities.Category;
import cn.hc.shop.entities.CategorySecond;

public interface CategoryService {

	
	
	//查询一级菜单关联二级菜单
	List<Category> findAllCandCs();
	
	//查询一级菜单
	List<Category> findAll();

	List<Category> findCAndCs();
	
}
