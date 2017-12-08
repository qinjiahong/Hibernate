package com.qjh.bean;

public class ShopBean {
	private int shop_id;
	private int user_id;
	private String shop_name;
	private String shop_addr;
	private String shop_phone;
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_addr() {
		return shop_addr;
	}
	public void setShop_addr(String shop_addr) {
		this.shop_addr = shop_addr;
	}
	public String getShop_phone() {
		return shop_phone;
	}
	public void setShop_phone(String shop_phone) {
		this.shop_phone = shop_phone;
	}
	@Override
	public String toString() {
		return "ShopBean [shop_id=" + shop_id + ", user_id=" + user_id + ", shop_name=" + shop_name + ", shop_addr="
				+ shop_addr + ", shop_phone=" + shop_phone + "]";
	}
	
	
}
