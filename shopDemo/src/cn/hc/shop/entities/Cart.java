package cn.hc.shop.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * 购物车
 */

public class Cart {

	//购物车的购物项
	//key 为 pid, value 为 :购物项
	private Map<Integer,CartItem> carts = new LinkedHashMap<Integer,CartItem>();
	
	//总价钱
	private double total;
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	//一个购物车中有多个购物项
	public List<CartItem> getCartItems(){
		return new ArrayList<>(carts.values());
	}
	
	//把购物项增加到购物车
	public void addCartItem(CartItem cartItem){
		
		Integer pid = cartItem.getProduct().getPid();
		
		//购买的商品是否已在购物车中
		if(carts.containsKey(pid)){
			//存在 
			//获取当前购物车中的购物项
			CartItem ci = carts.get(pid);
			int count = ci.getCount();
			//设置购物项中的商品数量为 原来购物车购买对应商品中的数量 + 新增到购物车购买对应的数量
			ci.setCount(count + cartItem.getCount());
		}else{
			//不存在
			carts.put(pid, cartItem);
		}
	}
	
	
	
	
	public void removeCartItem(Integer pid) {
		//删除对应的购物项
		CartItem ci = carts.remove(pid);
		//把购物项对应的价钱从总价钱中减去
		total = total - ci.getSubtotal();
	}
	
	//清空购物车
	public void clearCart() {
		carts.clear();
		total = 0;
	}
	
	
	
	
}
