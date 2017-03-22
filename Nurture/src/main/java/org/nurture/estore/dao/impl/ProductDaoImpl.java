package org.nurture.estore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.nurture.estore.dao.ProductDao;
import org.nurture.estore.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 08.04.2016.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Integer addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        Integer prodductId = (Integer) session.save(product);
        session.flush();
        return prodductId;
    }

    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }

  
    
    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();

        return product;
    }

	public List<Product> getProducts(Integer offset, Integer maxResults) {
		return sessionFactory.openSession()
				.createCriteria(Product.class)
				.add(Restrictions.ne("productManufacture","BPS"))
				.add(Restrictions.ne("productManufacture","DPS"))
				.setFirstResult(offset)
				.setMaxResults(maxResults)
				.list();
	}
	
	public List<Product> getProductsPage(Integer offset, Integer maxResults, String lookUp) {
		if(lookUp.equalsIgnoreCase("OTH")){
			return getProducts(offset,maxResults);
		}else{
		return sessionFactory.openSession()
				.createCriteria(Product.class)
				.add(Restrictions.eq("productManufacture",lookUp))
				.setFirstResult(offset)
				.setMaxResults(maxResults)
				.list();
		}
	}
	
	public Long countProducts(String lookUp){
		if(lookUp.equalsIgnoreCase("OTH")){
			return (Long)sessionFactory.openSession()
					.createCriteria(Product.class)
					.add(Restrictions.ne("productManufacture","BPS"))
					.add(Restrictions.ne("productManufacture","DPS"))
					.setProjection(Projections.rowCount())
					.uniqueResult();
		}else{
		return (Long)sessionFactory.openSession()
				.createCriteria(Product.class)
				.add(Restrictions.eq("productManufacture",lookUp))
				.setProjection(Projections.rowCount())
				.uniqueResult();
	}
	}
}
