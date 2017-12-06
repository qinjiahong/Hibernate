package com.qjh.dao;

import java.util.List;

import org.hibernate.Session;

import com.qjh.bean.UserBean;
import com.qjh.service.UserService;
import com.qjh.utils.HibernateUtil;

public class UserDao implements UserService {
	Session session;
	@Override
	public List<UserBean> getAllUser() {
		session = HibernateUtil.getSession();// 从会话工厂获取一个session
		session.beginTransaction();
		List<UserBean> list = session.createQuery("from UserBean").list();
		session.getTransaction().commit();
		HibernateUtil.closeSession();
		return list;
	}

	@Override
	public int insertUser(UserBean bean) {
		session = HibernateUtil.getSession();// 从会话工厂获取一个session
		session.beginTransaction();
		int code = 0;
		try {
			session.save(bean);
			session.getTransaction().commit();
			code = 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("e="+e.getMessage());
			code = 0;
		}
		HibernateUtil.closeSession();
		return code;
	}

	@Override
	public int updateUser(UserBean bean) {
		session = HibernateUtil.getSession();// 从会话工厂获取一个session
		session.beginTransaction();
		int code = 0;
		try {
			code = 1;
			session.update(bean);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("up="+e.getMessage());
			code = 0;
		}
		HibernateUtil.closeSession();
		return code;
	}

	@Override
	public int deleteUser(UserBean bean) {
		session = HibernateUtil.getSession();// 从会话工厂获取一个session
		session.beginTransaction();
		int code=0;
		try {
			session.delete(bean);
			session.getTransaction().commit();
			code=1;
		} catch (Exception e) {
		
			code=0;
		}
		HibernateUtil.closeSession();
		return code;
	}
}
