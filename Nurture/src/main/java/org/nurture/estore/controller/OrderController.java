package org.nurture.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Cart;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.CustomerOrder;
import org.nurture.estore.service.CartService;
import org.nurture.estore.service.CustomerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;
    
    AppManager manager;
    
    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId,Model model, HttpServletRequest paramRequest) {
    	
    	System.out.println("\n ***** CustomerOrderService -->createOrder() = "+cartId);
    	 manager = new AppManager();
    	 String state = "checkout?cartId=";
    	 
    	if(!manager.isUserLoggedOn(paramRequest)){
    		 state = "redirect:/login";
    	 }
    	getCustomerByCartId(cartId);
        
        System.out.println("\n ***** Returning to CustomerOrderService --> = "+state + cartId);
       // return state + cart;
        model.addAttribute("model", manager.getModel(paramRequest));
        model.addAttribute("order",getCustomerByCartId(cartId));
        return "redirect:/customer/details";
        //return "redirect:/checkout/"+cartId;
        //return "collectCustomerInfo";
    }
    
   
    
   


	@RequestMapping("/checkout/{cartId}")
    public String checkoutOrder(@PathVariable("cartId") int cartId, Model model, HttpServletRequest paramRequest) {
		 manager = new AppManager();
    	 cosLog(this.getClass(), "checkoutOrder", "START");
    	 cosLog(this.getClass(), "checkoutOrder", "Parameters = "+cartId);
    	 cosLog(this.getClass(), "checkoutOrder", "END");
    	 model.addAttribute("model", manager.getModel(paramRequest));
    	 model.addAttribute("order",getCustomerByCartId(cartId));
    	//return "customerDetails";
    	 return "redirect:/customer/details";
    }
    	
    @RequestMapping("/order/shipping/{cartId}")
    public String shippingOrder(@PathVariable("cartId") int cartId, Model model, HttpServletRequest paramRequest) {
    	 manager = new AppManager();
    	 cosLog(this.getClass(), "shippingOrder", "START");
    	 cosLog(this.getClass(), "shippingOrder", "Parameters = "+cartId);
    	 cosLog(this.getClass(), "shippingOrder", "END");
    	 model.addAttribute("order",getCustomerByCartId(cartId));
    	 model.addAttribute("model", manager.getModel(paramRequest));
    	return "collectShippingDetail";
    }
   
    
    @RequestMapping("/order/confirmation/{cartId}")
    public String confirmationOrder(@PathVariable("cartId") int cartId, Model model, HttpServletRequest paramRequest) {
    	 manager = new AppManager();
    	cosLog(this.getClass(), "confirmationOrder", "START");
    	 cosLog(this.getClass(), "confirmationOrder", "Parameters = "+cartId);
    	 cosLog(this.getClass(), "confirmationOrder", "END");
    	 model.addAttribute("order",getCustomerByCartId(cartId));
    	 model.addAttribute("model", manager.getModel(paramRequest));
    	return "orderConfirmation";
    }
    
    
    @RequestMapping("/order/receipt/{cartId}")
    public String receiptOrder(@PathVariable("cartId") int cartId, Model model, HttpServletRequest paramRequest) {
    	
    	 manager = new AppManager();
    	 cosLog(this.getClass(), "receiptOrder", "START");
    	 cosLog(this.getClass(), "receiptOrder", "Parameters = "+cartId);
    	 cosLog(this.getClass(), "receiptOrder", "END");
    	// model.addAttribute("order",getCustomerByCartId(cartId));
    	 model.addAttribute("model", manager.getModel(paramRequest));
    	return "thankCustomer";
    }
    
    private CustomerOrder getCustomerByCartId(int cartId) {
    	CustomerOrder customerOrder = new CustomerOrder();
    	System.out.println("\n ***** CustomerOrderService -->getCartById() = "+cartId);
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);
      

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());
      
        customerOrderService.addCustomerOrder(customerOrder);
       
        
        return customerOrder;
		
	}

    
    
    private void cosLog(Class<? extends OrderController> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
	}
}
