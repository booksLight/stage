package org.nurture.estore.dao;

import java.util.List;

import org.nurture.estore.model.User;

/**
 * Created by Rakesh on 14.01.2017.
 */
public interface UserDao {

	void addUser(User user);

	User getUserById(Integer id);

	List<User> getAllUsers();

	User getUserByName(String username);
	
	User getUserByMobile(String mobile);
}
