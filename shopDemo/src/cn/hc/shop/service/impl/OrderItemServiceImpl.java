package cn.hc.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hc.shop.dao.OrderItemMapper;
import cn.hc.shop.entities.OrderItem;
import cn.hc.shop.service.OrderItemService;

@Transactional
@Service("OrderItemService")
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemMapper oim;
	
	@Override
	public void saveOrderItem(OrderItem orderItem) {
		oim.insertSelective(orderItem);
	}

}
