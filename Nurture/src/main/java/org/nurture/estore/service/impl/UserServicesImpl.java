package org.nurture.estore.service.impl;

import java.util.List;

import org.nurture.estore.dao.ProductDao;
import org.nurture.estore.dao.UserDao;
import org.nurture.estore.model.User;
import org.nurture.estore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserService {

	  @Autowired
	  private UserDao userDao;
	  
	public void addUser(User user) {
		userDao.addUser(user);
	}

	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUserByName(String username) {
		return userDao.getUserByName(username);
	}
	public User getUserByMobile(String mobile) {
		return userDao.getUserByMobile(mobile);
	}

}
