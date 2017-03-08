package org.nurture.estore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nurture.estore.controller.RegisterController;
import org.nurture.estore.dao.UserDao;
import org.nurture.estore.model.ShippingAddress;
import org.nurture.estore.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	  @Autowired
	  private SessionFactory sessionFactory;
	  
	public void addUser(User user) {
		if(user != null){
		 Session session = sessionFactory.getCurrentSession();
		 session.saveOrUpdate(user);
		 udaoImplLog(this.getClass(), "addUser", "The "+user.getUserEmail() +"Successfully registered!");
		}else{
			udaoImplLog(this.getClass(), "addUser", "The user is null..");
		}
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
	        if(query.uniqueResult() != null){
	        return (User) query.uniqueResult() ;
	        }else{
	        	return null;
	        }
	}

	
	public User getUserByMobile(String mobile) {
		logger.debug("\n *************** getUserByMobile() :"+mobile);
		Session session = sessionFactory.getCurrentSession();
		 Query query = session.createQuery("from Users where mobile = ?");
	        query.setString(0, mobile);
	        if(query.uniqueResult() != null){
	        return (User) query.uniqueResult() ;
	        }else{
	        	return null;
	        }
	}
	
	
	
	
	

public void updateUserName(User userParam) {
	udaoImplLog(this.getClass(), "updateUserName", " START");
		if(userParam != null ){
			
			Session session = sessionFactory.getCurrentSession();
			String hqlUpdateQuery= "update users set username=:userNameParm, rolId=:rolIdParm where userId=:userIdParam";
			
			Query query1 = session.createSQLQuery(hqlUpdateQuery);
	 		query1.setParameter("userNameParm",userParam.getUsername().toString());
        	query1.setParameter("rolIdParm",userParam.getRolId());
        	query1.setParameter("userIdParam",userParam.getUserId());	
        	int rowCount = query1.executeUpdate();
       
        	logger.debug("**** User has been updated with Name and Roll; Rows affected: " + rowCount);
		}
		
		udaoImplLog(this.getClass(), "updateUserName", " END");
		
	}

	


//Generic Logger for this class
private void udaoImplLog(Class<? extends UserDaoImpl> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
	}
}
