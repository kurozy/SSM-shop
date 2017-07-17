package cn.hc.shop.service;

import cn.hc.shop.entities.User;

public interface UserService {

	//校验用户名是否存在
	String checkUsername(String username);

	void save(User user);

	User queryUserByCode(String code);

	void modify(User user);

	User login(String username, String password);
	
}
