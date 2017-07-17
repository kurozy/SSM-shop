package cn.hc.shop.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.hc.shop.entities.Cart;
import cn.hc.shop.entities.CartItem;
import cn.hc.shop.entities.OrderItem;
import cn.hc.shop.entities.Orders;
import cn.hc.shop.entities.Product;
import cn.hc.shop.entities.User;
import cn.hc.shop.service.OrderItemService;
import cn.hc.shop.service.OrdersService;
import cn.hc.shop.utils.PageBean;

@Controller
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired 
	private OrderItemService orderItemService;
	
	@RequestMapping("/order_findByUid")
	public String findByUid(Map<String,Object> map,HttpSession session,@RequestParam(value="page",required=false,defaultValue="1") Integer page){
		
		User user = (User) session.getAttribute("existUser");
		
		if(user != null){
			PageBean<Orders> pageBean = ordersService.findPageByUid(user.getUid(),page);
			map.put("pageBean", pageBean);
		}else{
			map.put("ordersFailedMsg", "你还未登录，无法查看自己的订单，请先登录！！");
			return "msg";
		}
		
		return "orderList";
	}
	
	@RequestMapping("/order_saveOrder")
	public String saveOrder(HttpSession session,Map<String,Object> map){
		
		Orders order = new Orders();
		
		User user = (User) session.getAttribute("existUser");
		//未登录
		if(user == null){
			map.put("ordersMsg", "你还没登录,无法提交订单");
			return null;
		}
		
		Cart cart = (Cart) session.getAttribute("cart");
		//购物车不存在
		if(cart == null){
			return "cart";
		}
		
		order.setOrdertime(new Date());//下单时间
		order.setState(1);//待付款
		order.setTotal(cart.getTotal());//订单总额
		order.setUid(user.getUid());//用户id
		
		//其他资料
		order.setAddr(user.getAddr());
		order.setName(user.getName());
		order.setPhone(user.getPhone());
		
		order.setUser(user);
		
		//保存成功后需要返回订单编号(即订单id)
		int len = ordersService.save(order);
		
		if(len <= 0){
			map.put("orderMsg", "订单超时了");
			return "";
		}
		
		List<CartItem> cartItems = cart.getCartItems();
		
		for (CartItem cartItem : cartItems) {
			Product p = cartItem.getProduct();
			int count = cartItem.getCount();
			double subtotal = cartItem.getSubtotal();
			
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(count);
			orderItem.setPid(p.getPid());
			orderItem.setProduct(p);
			orderItem.setSubtotal(subtotal);
			//orderItem.setOrder(order);
			System.out.println(" ----- " + order.getOid());
			orderItem.setOid(order.getOid());
			order.getOrderItems().add(orderItem);
			
			orderItemService.saveOrderItem(orderItem);
		}
		
		map.put("order", order);
		
		return "order";
	}
	
}
