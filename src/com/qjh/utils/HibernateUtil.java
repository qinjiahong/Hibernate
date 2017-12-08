package com.qjh.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//线程锁，保证线程安全，在用的时候只有这一个session，别人无法处理
    private static final ThreadLocal<Session> threadLock = new ThreadLocal<Session>();
    //定义常量是为了实现单例，不允许更改赋值
    private static final SessionFactory factory = buildFactory();
    //写一个buildFactory方法
    private static SessionFactory buildFactory() {
        //读取hibernate.cfg.xml配置，加载数据库和实体类
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        return  cfg.buildSessionFactory();
    }
 //获取session
    public static Session getSession(){
        //获取上面thredlock中的session
        Session session = threadLock.get();
        //如果thredlock中是空的就新建一个session
        if(session ==null){
            session = factory.openSession();
            //将新建的session放入thredlock中
            threadLock.set(session);
            session.beginTransaction();
        }
        return session;
    }
    //close的方法
    public static void closeSession(){
        //先获取thredlock中的session
        Session session = threadLock.get();
        //如果不是空，就把session关闭，并且把thredlocal清空
        if(session !=null){
            session.close();
            threadLock.set(null);
        }
    }}
