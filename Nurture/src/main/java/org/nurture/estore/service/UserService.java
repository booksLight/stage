package org.nurture.estore.service;

import java.util.List;
import org.nurture.estore.model.User;

public interface UserService {

	void addUser(User user);

	User getUserById(Integer id);

	List<User> getAllUsers();

	User getUserByName(String username);
	
	User getUserByMobile(String mobile);
}
