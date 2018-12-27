package com.boot.item.pojo;

public class Item {
	
	private Integer itemId;
	private String itemTitle;
	private String itemPic;
	private Double itemPrice;
	
	public Item() { super(); }
	
	public Item(Integer itemId, String itemTitle, String itemPic, Double itemPrice) {
		super();
		this.itemId = itemId;
		this.itemTitle = itemTitle;
		this.itemPic = itemPic;
		this.itemPrice = itemPrice;
	}

	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemPic() {
		return itemPic;
	}
	public void setItemPic(String itemPic) {
		this.itemPic = itemPic;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemTitle=" + itemTitle + ", itemPic=" + itemPic + ", itemPrice="
				+ itemPrice + "]";
	}
}
