package com.example.demo.model;

public class Items {
	private Integer itemId;
	private String name;
	private Integer price;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Items(Integer itemId, String name, Integer price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
	}
	
}
