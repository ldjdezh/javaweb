package cn.ldj.service;

import cn.ldj.domain.User;

public interface UserService {
	User getUser(String logname) throws Exception;
	
	void register(User user) throws Exception;
	
	void updateUser(User user) throws Exception;
}
