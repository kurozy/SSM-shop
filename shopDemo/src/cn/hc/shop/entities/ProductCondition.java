package cn.hc.shop.entities;

public class ProductCondition {
	
	private String type;
	private Double minPrice;
	private Double maxPrice;
	private String pname;
	private Integer page;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public ProductCondition() {
		super();
	}
	public ProductCondition(String type, Double minPrice, Double maxPrice, String pname) {
		super();
		this.type = type;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "ProductCondition [type=" + type + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", pname="
				+ pname + "]";
	}
}
