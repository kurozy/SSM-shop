package cn.hc.shop.entities;

import java.io.Serializable;

public class CategorySecond implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer csid;

    private String csname;

    private Integer cid;

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname == null ? null : csname.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}