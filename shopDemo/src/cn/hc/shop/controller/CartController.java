package cn.hc.shop.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hc.shop.entities.Cart;
import cn.hc.shop.entities.CartItem;
import cn.hc.shop.entities.Product;
import cn.hc.shop.entities.User;
import cn.hc.shop.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private ProductService ps;
	
	@RequestMapping("cart_clearCart")
	public String clearCart(HttpSession session){
		Cart cart = getCart(session);
		cart.clearCart();
		return "redirect:/cart_myCart";
	}
	
	@RequestMapping("cart_removeCart")
	public String removeCart(HttpSession session,Integer pid){
		
		Cart cart = getCart(session);
		
		cart.removeCartItem(pid);
		
		return "redirect:/cart_myCart";
	}
	
	
	
	@RequestMapping("/cart_addCart")
	public String addCart(Integer pid, Integer count,HttpSession session,Map<String,Object> map){
		
		User user = (User) session.getAttribute("existUser");
		
		if(user == null){
			map.put("cartMsg","您还没有登录，无法进行购物，请先登录!!");
			return "login";
		}
		
		//创建一个购物项
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		
		Product product = ps.findProductByPid(pid);
		cartItem.setProduct(product);
		
		//从session中获取购物车
		Cart cart = getCart(session);
		
		//把购物项放入购物车
		cart.addCartItem(cartItem);
		
		cart.setTotal(cart.getTotal() + cartItem.getSubtotal() );
		
		return "cart";
	}
	
	
	@RequestMapping("/cart_myCart")
	public String myCart(HttpSession session,Map<String,Object> map){
		
		User user = (User) session.getAttribute("existUser");
		if(user == null){
			map.put("cartMsg","您还没有登录，没有属于您的购物车!!");
			return "cart";
		}
		
		//判断购物车是否存在
		Cart cart = getCart(session);
		
		if(cart.getCartItems() == null || cart.getCartItems().size() == 0){
			map.put("cartMsg","亲!您还没有购物!请先去购物!");
			return "cart";
		}
		
		map.put("cart", cart);
		
		return "cart";
	}
	
	
	
	/*
	@RequestMapping("/cart_myCart")
	public String myCart(HttpSession session,Map<String,Object> map){
		
		User user = (User) session.getAttribute("existUser");
		
		if(user == null){
			map.put("cartMsg","您还没有登录，没有属于您的购物车!!");
		}
		
		return "cart";
	}
	*/
	
	public Cart getCart(HttpSession session){
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		return cart;
	}
	
}
