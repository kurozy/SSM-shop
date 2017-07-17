package cn.hc.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hc.shop.dao.ProductMapper;
import cn.hc.shop.entities.Product;
import cn.hc.shop.entities.ProductCondition;
import cn.hc.shop.service.ProductService;
import cn.hc.shop.utils.PageBean;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> findProductsByHot() {
		return productMapper.selectProductsByHot();
	}

	@Override
	public List<Product> findProductsByPdate() {
		return productMapper.selectProductsByPdate();
	}

	@Override
	public PageBean<Product> findPageByCid(Integer cid, int page) {

		PageBean<Product> pageBean = new PageBean<>();

		// 当前为第几页
		pageBean.setPage(page);

		int limit = 12;
		// 每页显示多少条
		pageBean.setLimit(limit);

		// select * FROM product p,categorysecond cs where p.csid = cs.csid and
		// cs.cid = 1 LIMIT 0,10
		int begin = (page - 1) * limit;

		List<Product> list = productMapper.selectPageByCid(cid, begin, limit);
		// 每页显示的集合
		pageBean.setList(list);
		// select count(*) FROM product p,categorysecond cs where p.csid =
		// cs.csid and cs.cid = 1
		int totalCount = productMapper.countByCid(cid);
		// 总记录数
		pageBean.setTotalCount(totalCount);
		int totalPage = (totalCount % limit == 0) ? (totalCount / limit) : (totalCount / limit + 1);
		// 总页数
		pageBean.setTotalPage(totalPage);
		
		return pageBean;
	}

	@Override
	public PageBean<Product> findPageByCsid(Integer csid, int page) {
		PageBean<Product> pageBean = new PageBean<>();
		// 当前为第几页
		pageBean.setPage(page);
		int limit = 12;
		// 每页显示多少条
		pageBean.setLimit(limit);
		int begin = (page - 1) * limit;
		List<Product> list = productMapper.selectPageByCsid(csid, begin, limit);
		// 每页显示的集合
		pageBean.setList(list);
		int totalCount = productMapper.countByCsid(csid);
		// 总记录数
		pageBean.setTotalCount(totalCount);
		int totalPage = (totalCount % limit == 0) ? (totalCount / limit) : (totalCount / limit + 1);
		// 总页数
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}

	@Override
	public PageBean<Product> findPageByCondition(ProductCondition pc) {
		PageBean<Product> pageBean = new PageBean<>();
		// 当前为第几页
		pageBean.setPage(pc.getPage());
		int limit = 12;
		// 每页显示多少条
		pageBean.setLimit(limit);
		int begin = (pageBean.getPage() - 1) * limit;
		List<Product> list = productMapper.selectPageByCondition(pc, begin, limit);
		int totalCount = productMapper.countByCondition(pc);
		
		// 每页显示的集合
		pageBean.setList(list);
		// 总记录数
		pageBean.setTotalCount(totalCount);
		int totalPage = (totalCount % limit == 0) ? (totalCount / limit) : (totalCount / limit + 1);
		// 总页数
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}

	@Override
	public Product findProductByPid(Integer pid) {
		return productMapper.selectByPrimaryKey(pid);
	}
	

}
