package org.nurture.estore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.nurture.estore.dao.ClientDao;
import org.nurture.estore.model.Client;
import org.nurture.estore.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {

	private static final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);
	
	 @Autowired
	 private SessionFactory sessionFactory;

	 
	public Iterable<Client> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Client> findAll(Pageable pageable) {
		daoImplLog(this.getClass(), "findAll", "START");
		final Integer PAGE_SIZE = 10;
		
		
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery("Product product");
		query.setFirstResult(0);
		query.setMaxResults(10);
		List<Product> productList = query.list();
		
		for(Product prod : productList){
			System.out.println("Products ="+prod.getProductId() + "\t"+prod.getProductName());
		}
		
		daoImplLog(this.getClass(), "findAll", "END");
		return null;
	}

	public <S extends Client> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Client> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Client findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Client> findAll(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public void delete(Client entity) {
		// TODO Auto-generated method stub

	}

	public void delete(Iterable<? extends Client> entities) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	

	//Generic Logger for this class
	private void daoImplLog(Class<? extends ClientDaoImpl> paramCclass, String paramMethod, String paramMsg) {
			logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
		}
}
