package cn.hc.shop.service;

import cn.hc.shop.entities.Orders;
import cn.hc.shop.utils.PageBean;

public interface OrdersService {

	PageBean<Orders> findPageByUid(Integer uid, Integer page);

	int save(Orders order);

}
