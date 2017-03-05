package org.nurture.estore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.nurture.estore.controller.OrderController;
import org.nurture.estore.dao.CartDao;
import org.nurture.estore.model.Cart;
import org.nurture.estore.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class CartServiceImpl implements CartService{
	
	private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	
    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public void update(Cart cart) {
        cartDao.update(cart);
    }

	public void updateGrandTotal(Cart cart) {
		svcLog(this.getClass(), "updateGrandTotal", "START");
		if(cart != null){
		cartDao.updateGrandTotal(cart);
		}else{
			svcLog(this.getClass(), "updateGrandTotal", " Cart is null.");
		}
		svcLog(this.getClass(), "updateGrandTotal", "END");
	}
	
	 
    private void svcLog(Class<? extends CartServiceImpl> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
	}
}
