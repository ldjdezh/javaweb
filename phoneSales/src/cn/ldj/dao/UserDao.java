package cn.ldj.dao;

import cn.ldj.domain.User;

public interface UserDao {
	void addUser(User user) throws Exception;
	
	User getUser(String logname) throws Exception;
	
	void updateUser(User user) throws Exception;

	User getUid(int uid) throws Exception;
}
