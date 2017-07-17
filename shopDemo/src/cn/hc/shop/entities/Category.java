package cn.hc.shop.entities;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer cid;

    private String cname;
    
    private List<CategorySecond> categorySeconds;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

	public List<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}

	public void setCategorySeconds(List<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}

}