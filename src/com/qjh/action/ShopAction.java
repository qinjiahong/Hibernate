package com.qjh.action;

import java.util.List;

import com.qjh.bean.ShopBean;
import com.qjh.bean.UserBean;
import com.qjh.dao.ShopDao;
import com.qjh.dao.UserDao;
import com.qjh.service.ShopService;
import com.qjh.service.UserService;

public class ShopAction {
	static ShopService shopService;
	static UserService userService;
	static List<UserBean> mData;

	public static void main(String[] args) {
		shopService = new ShopDao();
		userService = new UserDao();
		mData = userService.getAllUser();
		getList();
		// insertShop();
		 updateShop();
		getSigleShop();
		getSigleShop1();
		deleteShop();
	}

	/**
	 * 查询所有
	 */
	public static void getList() {
		List<ShopBean> mList = shopService.getAllList();
		System.out.println("list------> " + mList.size());
	}

	/**
	 * 插入数据
	 */
	public static void insertShop() {
		ShopBean bean = new ShopBean();
		bean.setUser_id(mData.get(8).getUser_id());
		bean.setShop_name("广东运命");
		bean.setShop_addr("广东广州市");
		bean.setShop_phone("1351123545455");
		int code = shopService.insertIntoShop(bean);
		System.out.println("code--------->" + code);
	}

	/**
	 * 更新数据
	 */
	public static void updateShop() {
		ShopBean bean = new ShopBean();
		List<ShopBean> list = shopService.getAllList();
		bean.setShop_id(list.get(1).getShop_id());
		bean.setUser_id(list.get(1).getUser_id());
		bean.setShop_addr("广西柳州市");
		bean.setShop_name("柳州螺蛳粉");
		bean.setShop_phone("13555555555");
		int code = shopService.updateShop(bean);
		System.out.println("update------>" + code);
	}

	/**
	 * 查询单个(多条件)
	 */
	public static void getSigleShop() {
		ShopBean shopBean = shopService.getSigleShop(5, 11);
		if (shopBean == null) {
			System.out.println("-------------->null");
			return;

		}
		System.out.println("bean------>" + shopBean.toString());
	}

	/**
	 * 查询单个
	 */
	public static void getSigleShop1() {
		ShopBean shopBean = shopService.getSigleShop(1);
		if (shopBean == null) {
			System.out.println("getSigleShop1-------------->null");
			return;

		}
		System.out.println("getSigleShop1-------bean------->" + shopBean.toString());
	}

	/**
	 * 删除某一个
	 */
	public static void deleteShop() {
		int code = shopService.deleteShop(5);
		System.out.println("delete-------------->" + code);

	}
}
