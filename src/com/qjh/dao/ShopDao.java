package com.qjh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.qjh.bean.ShopBean;
import com.qjh.service.ShopService;
import com.qjh.utils.HibernateUtil;

public class ShopDao implements ShopService {
	Session session;

	@Override
	public List<ShopBean> getAllList() {
		session = HibernateUtil.getSession();
		Query query = session.createQuery("from ShopBean");
		// 分页查询
		query.setFirstResult(0);
		query.setMaxResults(6);

		List<ShopBean> list = query.list();
		session.getTransaction().commit();
		HibernateUtil.closeSession();
		return list;
	}

	@Override
	public int insertIntoShop(ShopBean bean) {
		session = HibernateUtil.getSession();
		int code = 0;

		try {
			session.save(bean);
			session.getTransaction().commit();
			code = 1;
		} catch (Exception e) {
			// TODO: handle exception
			code = 0;
		}
		HibernateUtil.closeSession();
		return code;
	}

	@Override
	public int updateShop(ShopBean bean) {
		ShopBean shopBean = getSigleShop(bean.getShop_id());
		if (shopBean == null) {
			return 0;
		}
		int code = 0;
		session = HibernateUtil.getSession();

		try {
			session.update(bean);
			session.beginTransaction().commit();
			code = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			code = 0;
		}
		HibernateUtil.closeSession();

		return code;
	}

	@Override
	public ShopBean getSigleShop(int shop_id, int user_id) {

		ShopBean bean = new ShopBean();
		int code = 0;
		session = HibernateUtil.getSession();

		try {
			// bean = session.get(ShopBean.class, shop_id);
			bean = (ShopBean) session.createQuery("from ShopBean s where s.shop_id=:shop_id and s.user_id=:user_id")
					.setParameter("shop_id", shop_id).setParameter("user_id", user_id).uniqueResult();
			session.beginTransaction().commit();
			code = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HibernateUtil.closeSession();
		System.out.println("sigle----->" + code);
		return bean;
	}

	@Override
	public ShopBean getSigleShop(int shop_id) {
		ShopBean bean = new ShopBean();
		session = HibernateUtil.getSession();
		String sql = "from ShopBean s where s.shop_id=:shop_id";
		bean = (ShopBean) session.createQuery(sql).setParameter("shop_id", shop_id).uniqueResult();
		session.beginTransaction().commit();
		HibernateUtil.closeSession();
		return bean;
	}

	@Override
	public int deleteShop(int shop_id) {
		int code = 0;
		session = HibernateUtil.getSession();

		try {
			String sql = "delete ShopBean s where s.shop_id=:shop_id";
			Query query = session.createQuery(sql).setParameter("shop_id", shop_id);
			code = query.executeUpdate();
			session.beginTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return code;
	}

}
