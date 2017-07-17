package cn.hc.shop.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.hc.shop.dao.ProductMapper;
import cn.hc.shop.entities.Product;
import cn.hc.shop.entities.ProductCondition;
import cn.hc.shop.service.ProductService;
import cn.hc.shop.utils.PageBean;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product_findByPid")
	public String findByPid(Integer pid,Model model){
		
		Product product = productService.findProductByPid(pid);
		model.addAttribute("model",product);
		
		return "product";
	}
	
	
	@RequestMapping("/product_findByCid")
	public String findPageByCid(Integer cid,
			@RequestParam(value="page",required=false,defaultValue="1") int page,Map<String,Object> map){
		
		PageBean<Product> pageBean = productService.findPageByCid(cid,page);
		
		map.put("pageBean", pageBean);
		map.put("cid",cid);
		
		return "productList";
	}
	
	@RequestMapping("/product_findByCsid")
	public String findPageByCsid(Integer csid,
			@RequestParam(value="page",required=false,defaultValue="1") int page,Map<String,Object> map){
		
		PageBean<Product> pageBean = productService.findPageByCsid(csid,page);
		
		map.put("pageBean", pageBean);
		map.put("csid",csid);
		
		return "productList";
	}
	
	
	@RequestMapping("/product_findByCondition")
	public String findByCondition(ProductCondition pc,
			Map<String, Object> map,
			HttpSession session){
		
		PageBean<Product> pageBean = productService.findPageByCondition(pc);
		
		map.put("pageBean", pageBean);
		//session.setAttribute("sessionPc", pc);
		map.put("pc",pc);
		
		return "productList";
		
	}
	
	
}
