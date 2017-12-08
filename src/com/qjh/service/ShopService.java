package com.qjh.service;

import java.util.List;

import com.qjh.bean.ShopBean;

public interface ShopService {
	public List<ShopBean> getAllList();// 获取所有

	public int insertIntoShop(ShopBean bean);// 插入

	public int updateShop(ShopBean bean);// 修改

	public ShopBean getSigleShop(int shop_id, int user_id);// 查询单个多条件

	public ShopBean getSigleShop(int shop_id);// 查询单个
	
	public int deleteShop(int shop_id);//删除
}
