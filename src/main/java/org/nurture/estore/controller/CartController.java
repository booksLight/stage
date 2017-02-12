package org.nurture.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import org.nurture.estore.model.User;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Customer;
import org.nurture.estore.service.CustomerService;
import org.nurture.estore.vo.ModelVo;
import org.nurture.estore.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
    @Autowired
    private CustomerService customerService;

    AppManager manager;
    
    @RequestMapping
    public String getCart(HttpServletRequest paramRequest ) {
    	
    	ctrLog(this.getClass(), "getCart", "START");
    	manager = new AppManager();
    	String state = "redirect:/customer/cart/";
    	 if(!manager.isUserLoggedOn(paramRequest)){
    		 state = "redirect:/login";
    	 }
    	UserVO curentUser = (UserVO) paramRequest.getSession().getAttribute("suser");
    	if(curentUser!=null){
    		Customer customer = customerService.getCustomerByUserID(curentUser.getId());
    		ctrLog(this.getClass(),"getCart", "Current User ="+curentUser.toString());
      
    		int cartId = customer.getCart().getCartId();
        	ctrLog(this.getClass(), "getCart", "END ->"+state+cartId);
        	state = state + cartId;
    	}else{
    		state = "redirect:/login";
    	}
    	return state;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable(value = "cartId") int cartId, Model model,HttpServletRequest paramRequest) {
    	ctrLog(this.getClass(), "getCartRedirect", "START");
    	manager = new AppManager();
    	String state = "cart";
    	 if(!manager.isUserLoggedOn(paramRequest)){
    		 state = "redirect:/login";
    	 }
        model.addAttribute("cartId", cartId);
        model.addAttribute("model", manager.getUserModel(paramRequest));
        ctrLog(this.getClass(), "getCartRedirect", "END");
        return state;
    }
    
    
    //Generic Logger for this class
    private void ctrLog(Class<? extends CartController> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
	}
}
