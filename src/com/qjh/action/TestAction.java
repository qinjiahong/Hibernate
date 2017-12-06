package com.qjh.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.qjh.bean.UserBean;
import com.qjh.dao.UserDao;
import com.qjh.service.UserService;
import com.qjh.utils.HibernateUtil;

public class TestAction {
	static UserService userService;
	public static void main(String[] args) {
		userService=new UserDao();
		test();
	}

	public static void test() {
		/*
		 * //相对于3.x.x版本hibernate，我们在4.x.x采用如下方式获取我们的会话工厂： //1.
		 * 解析我们在hibernate.cfg.xml中的配置 // Configuration configuration = new
		 * Configuration().configure(); //2. 创建服务注册类,进一步注册初始化我们配置文件中的属性 //
		 * ServiceRegistry serviceRegistry = new
		 * ServiceRegistryBuilder().applySettings(configuration.getProperties()).
		 * buildServiceRegistry(); //3. 创建我们的数据库访问会话工厂 // SessionFactory sessionFactory
		 * = configuration.buildSessionFactory(serviceRegistry);
		 * 
		 * //但在5.1.0版本汇总，hibernate则采用如下新方式获取： //1.
		 * 配置类型安全的准服务注册类，这是当前应用的单例对象，不作修改，所以声明为final
		 * //在configure("cfg/hibernate.cfg.xml")方法中，如果不指定资源路径，默认在类路径下寻找名为hibernate.cfg.
		 * xml的文件 final StandardServiceRegistry registry = new
		 * StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build(); //2.
		 * 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂 SessionFactory sessionFactory =
		 * new MetadataSources(registry).buildMetadata().buildSessionFactory();
		 * 
		 *//**** 上面是配置准备，下面开始我们的数据库操作 ******/
		/*Session session = HibernateUtil.getSession();// 从会话工厂获取一个session
		session.beginTransaction();
		UserBean user = new UserBean();
		user.setUser_name("王五aa");
		user.setUser_age(10);
		user.setUser_addr("广西来宾武宣");
		user.setUser_sex("男");
		session.save(user);
		session.getTransaction().commit();// 提交事务
		HibernateUtil.closeSession();*/
		
		List<UserBean> list=userService.getAllUser();
//		System.out.println("list="+list.size());
		
		UserBean user = new UserBean();
		user.setUser_name("王五aYY");
		user.setUser_age(10);
		user.setUser_addr("广西来宾武宣");
		user.setUser_sex("男");
		int code=userService.insertUser(user);
		System.out.println("code="+code);
		
		UserBean user1 = new UserBean();
		user1.setUser_id(8);
		int code1=userService.deleteUser(user1);
		System.out.println("code1="+code1);
		
		UserBean user2 = new UserBean();
		user2.setUser_id(6);
		user2.setUser_name("李大脚");
		user2.setUser_age(58);
		user2.setUser_sex("女");
		user2.setUser_addr("广西来宾市南泗乡");
		int code2=userService.updateUser(user2);
		System.out.println("code2="+code2);
	}
}
