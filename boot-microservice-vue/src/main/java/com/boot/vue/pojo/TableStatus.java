package com.boot.vue.pojo;

public class TableStatus {
	private Integer total;
	private Object rows;
	
	public TableStatus(Integer total, Object rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
}
