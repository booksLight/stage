package org.nurture.estore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.nurture.estore.dao.CustomerOrderDao;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Cart;
import org.nurture.estore.model.CartItem;
import org.nurture.estore.model.CustomerOrder;
import org.nurture.estore.model.OrderBook;
import org.nurture.estore.service.CartService;
import org.nurture.estore.service.CustomerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	private static final Logger logger = LoggerFactory.getLogger(AppManager.class);
	
    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }

	public void saveOrUpdateOrderBook(OrderBook orderBookParam) {
		customerOrderDao.saveOrUpdateOrderBook(orderBookParam);		
	}

	public CustomerOrder getCustomerOrderById(Integer customerOrderId) {
		return customerOrderId > 0 ?  customerOrderDao.getCustomerOrderById(customerOrderId):null;
	}

	public List<OrderBook> getOrderedBooksByOrderId(Integer customerOrderId) {
		return customerOrderId > 0 ?  customerOrderDao.getOrderedBooksByOrderId(customerOrderId):null;
	}

	public List<CustomerOrder> getCustomerOrdersByCartId(Integer cartId) {
		logger.info("\n\t CustomerOrderServiceImpl : Fetching Customer Order by cartid="+cartId);
		return cartId > 0 ?  customerOrderDao.getCustomerOrdersByCartId(cartId):null;
	}
}
