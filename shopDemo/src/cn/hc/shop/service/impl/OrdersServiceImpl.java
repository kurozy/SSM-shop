package cn.hc.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hc.shop.dao.OrdersMapper;
import cn.hc.shop.entities.Orders;
import cn.hc.shop.service.OrdersService;
import cn.hc.shop.utils.PageBean;

@Transactional
@Service("OrdersService")
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper om;
	
	@Override
	public PageBean<Orders> findPageByUid(Integer uid, Integer page) {
		
		PageBean<Orders> pageBean = new PageBean<>();
		// 当前为第几页
		pageBean.setPage(page);
		int limit = 6;
		// 每页显示多少条
		pageBean.setLimit(limit);
		int begin = (pageBean.getPage() - 1) * limit;
		List<Orders> list = om.selectPageByUid(uid, begin, limit);
		int totalCount = om.countByUid(uid);
		
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
	public int save(Orders order) {
		return om.add(order);
	}

}
