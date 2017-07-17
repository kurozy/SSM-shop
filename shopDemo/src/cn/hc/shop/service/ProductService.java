package cn.hc.shop.service;

import java.util.List;

import cn.hc.shop.entities.Product;
import cn.hc.shop.entities.ProductCondition;
import cn.hc.shop.utils.PageBean;

public interface ProductService {

	List<Product> findProductsByHot();
	
	List<Product> findProductsByPdate();
	
	PageBean<Product> findPageByCid(Integer cid, int page);

	PageBean<Product> findPageByCsid(Integer csid, int page);

	PageBean<Product> findPageByCondition(ProductCondition pc);

	Product findProductByPid(Integer pid);
	
}
