package cn.ldj.service.impl;

import cn.ldj.dao.UserDao;
import cn.ldj.dao.impl.UserDaoImpl;
import cn.ldj.domain.User;
import cn.ldj.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User getUser(String logname) throws Exception {
		return userDao.getUser(logname);
	}

	@Override
	public void register(User user) throws Exception {
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}
	
	
}
