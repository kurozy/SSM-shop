package cn.hc.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hc.shop.dao.CategoryMapper;
import cn.hc.shop.dao.CategorySecondMapper;
import cn.hc.shop.entities.Category;
import cn.hc.shop.entities.CategorySecond;
import cn.hc.shop.service.CategoryService;

@Transactional
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper cm;
	
	@Autowired
	private CategorySecondMapper csm;
	
	//查询一级菜单
	@Override
	public List<Category> findAll() {
		return cm.selectByExample(null);
	}

	
	//查询一级菜单关联二级菜单
	@Override
	public List<Category> findAllCandCs() {
		
		List<Category> list = findAll();
		
		for (Category c : list) {
			List<CategorySecond> cslist = csm.selectCsByCid(c.getCid());
			c.setCategorySeconds(cslist);
		}
		
		return list;
	}


	@Override
	public List<Category> findCAndCs() {
		
		List<Category> list = cm.selectByExample(null);
		
		for (Category c : list) {
			int cid = c.getCid();
			List<CategorySecond> cslist = csm.selectCsByCid(cid);
			c.setCategorySeconds(cslist);
		}
		
		return list;
	}
	
	
	
	

}
