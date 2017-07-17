package cn.hc.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hc.shop.dao.UserMapper;
import cn.hc.shop.entities.User;
import cn.hc.shop.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public String checkUsername(String username) {
		User user = userMapper.findUserByUserName(username);
		if(user != null){
			System.out.println("===========> " + user.getUsername());
			//找到
			return "yes";
		}
		return "no";
	}

	@Override
	public void save(User user) {
		userMapper.insertSelective(user);
	}

	@Override
	public User queryUserByCode(String code) {
		
		return userMapper.selectUserByCode(code);
	}

	@Override
	public void modify(User user) {
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User login(String username, String password) {
		return userMapper.selectUserByLogin(username,password);
	}

}
