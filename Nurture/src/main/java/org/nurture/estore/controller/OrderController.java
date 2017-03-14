package org.nurture.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nurture.estore.Constants;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Cart;
import org.nurture.estore.model.CartItem;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.CustomerOrder;
import org.nurture.estore.model.OrderBook;
import org.nurture.estore.service.CartService;
import org.nurture.estore.service.CustomerOrderService;
import org.nurture.estore.util.CallenderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;
    
    @Autowired
	AppManager manager;
    
    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId,Model model, HttpServletRequest paramRequest) {
    	
    	logger.debug("\n ***** CustomerOrderService -->createOrder() = "+cartId);
    	 
    	 String state = "checkout?cartId=";
    	 
    	if(!manager.isUserLoggedOn(paramRequest)){
    		 state = "redirect:/login";
    	 }
    	getCustomerByCartId(cartId);
        
        logger.debug("\n ***** Returning to CustomerOrderService --> = "+state + cartId);
       // return state + cart;
        model.addAttribute("model", manager.getModel(paramRequest));
        model.addAttribute("order",getCustomerByCartId(cartId));
        return "redirect:/customer/details/verify";
        //return "redirect:/checkout/"+cartId;
        //return "collectCustomerInfo";
    }
    
   
    
   


	@RequestMapping("/checkout/{cartId}")
    public String checkoutOrder(@PathVariable("cartId") int cartId, Model model, HttpServletRequest paramRequest) {
		 
    	 cosLog(this.getClass(), "checkoutOrder", "START");
    	 cosLog(this.getClass(), "checkoutOrder", "Parameters = "+cartId);
    	 cosLog(this.getClass(), "checkoutOrder", "END");
    	 model.addAttribute("model", manager.getModel(paramRequest));
    	 model.addAttribute("order",getCustomerByCartId(cartId));
    	//return "customerDetails";
    	 return "redirect:/customer/details/verify";
    }
    	
    @RequestMapping("/order/shipping/{cartId}")
    public String shippingOrder(@PathVariable("cartId") int cartId, Model model, HttpServletRequest paramRequest) {
    	 
    	 cosLog(this.getClass(), "shippingOrder", "START");
    	 cosLog(this.getClass(), "shippingOrder", "Parameters = "+cartId);
    	 cosLog(this.getClass(), "shippingOrder", "END");
    	 model.addAttribute("order",getCustomerByCartId(cartId));
    	 model.addAttribute("model", manager.getModel(paramRequest));
    	return "collectShippingDetail";
    }
   
    
    @RequestMapping("/order/confirmation/{cartId}")
    public String confirmationOrder(@PathVariable("cartId") int cartId, Model model, HttpServletRequest paramRequest) {
    	 
    	cosLog(this.getClass(), "confirmationOrder", "START");
    	 cosLog(this.getClass(), "confirmationOrder", "Parameters = "+cartId);
    	 cosLog(this.getClass(), "confirmationOrder", "END");
    	 model.addAttribute("order",getCustomerByCartId(cartId));
    	 model.addAttribute("model", manager.getModel(paramRequest));
    	 model.addAttribute("cartId", cartId);
    	return "orderConfirmation";
    }
    
    
    @RequestMapping("/order/receipt/{cartId}")
    public String receiptOrder(@PathVariable("cartId") int cartId, Model model, HttpServletRequest paramRequest) {
    	
    	 
    	 cosLog(this.getClass(), "receiptOrder", "START");
    	 cosLog(this.getClass(), "receiptOrder", "Parameters = "+cartId);
    	 cosLog(this.getClass(), "receiptOrder", "END");
    	 
    	 CustomerOrder customerNewOrder =  getCustomerByCartId(cartId);
    	 customerNewOrder.setConfirmed(Constants.TRUE);
    	 customerNewOrder.setStatus("Received");
    	 customerNewOrder.setStamped(CallenderUtil.convertDateJavaToSqlTimestamp(new Date()));
    	 customerOrderService.addCustomerOrder(customerNewOrder);
    	 
    	 String ordDT = new SimpleDateFormat("yyMMdd").format(new Date());
    	    
    	    String orderNo = "BL-" + ordDT + String.valueOf(customerNewOrder.getCustomerOrderId());
    	    logger.debug("   \n\t *********\n ORDER NO TO CUSTOMER =" + orderNo);
    	    
 //Saving CartItems to OrderBook
    	 List<OrderBook> orderedItems = manager.mapOrderBookOnCustomerOrder(customerNewOrder);
    	 manager.saveOrUpdateOrderedItems(orderedItems);
    	 manager.deleteOrderedItemsFromCart(customerNewOrder);
    	 
    	
    	  try{
         	manager.mailOrderAcknowledgment(customerNewOrder.getCustomer().getCustomerEmail(), customerNewOrder.getCustomer().getCustomerName(), orderNo);
          }catch(Exception e){
        	  cosLog(this.getClass(), "receiptOrder", "ERROR -->"+e);
          	
          } 
    	 model.addAttribute("order",customerNewOrder);
    	 model.addAttribute("model", manager.getModel(paramRequest));
    	 model.addAttribute("cartId", cartId);
    	 model.addAttribute("ordReceiptNo", orderNo);
    	return "thankCustomer";
    }
    
    @RequestMapping({"/order/book/{customerOrderId}"})
    public String getOrderBook(@PathVariable("customerOrderId") Integer customerOrderId, Model model, HttpServletRequest paramRequest)
    {
      
      cosLog(getClass(), "getOrderBook", "START");
      cosLog(getClass(), "getOrderBook", "Parameters = " + customerOrderId);
      
      CustomerOrder orderBook = manager.getCustomerOrderById(customerOrderId);
      
      Integer cartId = Integer.valueOf(orderBook != null ?  orderBook.getCart() != null ? orderBook.getCart().getCartId() : 0:0);
      
      logger.debug("\n\n **************** CartId for customer is ="+cartId);
      
      logger.debug("\n\n **************** orderBook.getCart().getCartId() for customer is ="+ orderBook.getCart().getCartId());
      
      for(CartItem ordItem : orderBook.getCart().getCartItems() ){
    	  
    	  logger.debug("\n Cart Item are ="+ordItem.toString());
    	  logger.debug("\n");
    	  
      }
      
      if (cartId.intValue() < 1) {
        return "redirect:/customer/cart";
      }
      model.addAttribute("order", orderBook);
      model.addAttribute("customer", getCustomerByCartId(cartId.intValue()));
      model.addAttribute("model", manager.getUserModel(paramRequest));
      model.addAttribute("cartId", cartId);
      
      cosLog(getClass(), "getOrderBook", "END");
      return "orderReceipt";
    }
    
    
    private CustomerOrder getCustomerByCartId(int cartId) {
    	CustomerOrder customerOrder = new CustomerOrder();
    	logger.debug("\n ***** CustomerOrderService -->getCartById() = "+cartId);
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);
      

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());
        return customerOrder;
		
	}

    
    
    private void cosLog(Class<? extends OrderController> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
	}
}
