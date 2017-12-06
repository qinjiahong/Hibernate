package com.qjh.service;

import java.util.List;

import com.qjh.bean.UserBean;

public interface UserService {
	public List<UserBean> getAllUser();//查询所有

	public int insertUser(UserBean bean);//插入数据

	public int updateUser(UserBean bean);//更新

	public int deleteUser(UserBean bean);//删除
}
