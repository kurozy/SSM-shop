package cn.hc.shop.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hc.shop.entities.Category;
import cn.hc.shop.entities.CategorySecond;
import cn.hc.shop.entities.Product;
import cn.hc.shop.service.CategoryService;
import cn.hc.shop.service.ProductService;

@Controller
public class IndexController {
	
	@Autowired
	private CategoryService categoryService;
	
	//@Autowired
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("/test")
	public String test(){
		return "success";
	}
	/*
	
	@RequestMapping("/index")
	public String index(HttpSession session,Map<String,Object> map) {
		
		List<Category> list = categoryService.findAllCandCs();
		
		List<Product> hList = productService.findProductsByHot();
		
		session.setAttribute("cList", list);
		
		map.put("hList", hList);
		
		return "index";
	}
	*/
	
	
	
	@RequestMapping("/index")
	public String index(HttpSession session,Map<String,Object> map) {
		
		List<Category> list = categoryService.findCAndCs();
		session.setAttribute("cList", list);
		
		
		List<Product> hList = productService.findProductsByHot();
		map.put("hList", hList);
		
		List<Product> nList = productService.findProductsByPdate();
		map.put("nList", nList);
		
		return "index";
	}
	
	
}
