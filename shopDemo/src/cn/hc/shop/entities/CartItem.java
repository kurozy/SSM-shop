package cn.hc.shop.entities;

/*
 * 购物车中每一个购物项
 */

public class CartItem {
	
	private Product product;
	
	private int count;
	
	private double subtotal;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getSubtotal() {
		return count * product.getShopPrice();
	}

}
