package org.nurture.estore.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.nurture.estore.dao.ProductDao;
import org.nurture.estore.model.Product;

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

    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();
        session.flush();

        return productList;
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
				.setFirstResult(offset!=null?offset:0)
				.setMaxResults(maxResults!=null?maxResults:10)
				.list();
	}
	
	public Long countProducts(){
		return (Long)sessionFactory.openSession()
				.createCriteria(Product.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
	}
}
