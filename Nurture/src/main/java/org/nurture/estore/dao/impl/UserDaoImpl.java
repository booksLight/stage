package org.nurture.estore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nurture.estore.dao.UserDao;
import org.nurture.estore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	  @Autowired
	  private SessionFactory sessionFactory;
	  
	public void addUser(User user) {
		 Session session = sessionFactory.getCurrentSession();
		 session.saveOrUpdate(user);
	}

	public User getUserById(Integer id) {
		 Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}

	public List<User> getAllUsers() {
		 Session session = sessionFactory.getCurrentSession();
		 Query query = session.createQuery("from Users");
	        List<User> userList = query.list();
	        return userList;
	}

	public User getUserByName(String username) {
		Session session = sessionFactory.getCurrentSession();
		 Query query = session.createQuery("from Users where username = ?");
	        query.setString(0, username);
	        return (User) query.uniqueResult();
	}

}
