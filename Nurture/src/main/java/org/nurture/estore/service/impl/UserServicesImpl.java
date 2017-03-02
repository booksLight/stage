package org.nurture.estore.service.impl;

import java.util.List;

import org.nurture.estore.dao.ProductDao;
import org.nurture.estore.dao.UserDao;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.User;
import org.nurture.estore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);
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

	public void saveOrUpdateUserName(User userParam) {
		if(userParam != null){
			 userDao.updateUserName(userParam);
		}else{
			logger.debug("\n *** UserServicesImpl || Customer Name is Null.");
		}
		
	}

}
