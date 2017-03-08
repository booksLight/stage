package org.nurture.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.BillingAddress;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.ShippingAddress;
import org.nurture.estore.service.CustomerService;
import org.nurture.estore.service.UserService;
import org.nurture.estore.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	AppManager manager;
	Customer customerDet;
	
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    UserService userService;
 
   
    @RequestMapping("/details")
    public String viewCustomer(Model model, HttpServletRequest paramRequest) {
    	manager = new AppManager();
    	String state = "customerDetails";
    	ctrLog(this.getClass(), "viewCustomer", "START");
    	customerDet = new Customer();
    	UserVO curentUser = (UserVO) paramRequest.getSession().getAttribute("suser");
    	if(curentUser!=null){
    		
    		customerDet.setUserId(curentUser.getId());
    		customerDet.setCustomerEmail(curentUser.getEmail());
    		customerDet.setCustomerName(curentUser.getName());
    		customerDet.setCustomerPhone(curentUser.getMobile() != null ? curentUser.getMobile() : null);
    		
    	}else{
    		state = "redirect:/login";
    	}
    	
        model.addAttribute("customer",  customerDet);
        model.addAttribute("model", manager.getUserModel(paramRequest));

    	ctrLog(this.getClass(), "viewCustomer", "END-->"+state);
        return state;
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String getCustomerInfo(@Valid @ModelAttribute("customer") Customer customer,
                                       BindingResult result, Model model, HttpServletRequest paramRequest) {
    	
    	ctrLog(this.getClass(), "getCustomerInfo", "START");
    	String state = "customerDetails";
    	
    	if(customer.getCustomerName()!=null && customer.getCustomerName().length() >4){
    		customerDet.setCustomerName(customer.getCustomerName() );
    	}
    
    	if(customer.getCustomerPhone().length() == 10){
    		customerDet.setCustomerPhone(customer.getCustomerPhone() );
    	}
      
        model.addAttribute("customer",  customerDet);
        
        manager.updateUserName(customerDet,userService);
        
       
        ctrLog(this.getClass(), "getCustomerInfo", "END-->"+state);
        return state;
    }
    
   
    
    @RequestMapping(value = "/billing/address", method = RequestMethod.POST)
    public String getCustomerBillingAddress(@Valid @ModelAttribute("customer") Customer customer,
                                       BindingResult result, Model model, HttpServletRequest paramRequest) {
    	
    	ctrLog(this.getClass(), "getCustomerBillingAddress", "START");
    	String state = "customerDetails";
    	

    	logger.debug("\n*******\n\t CustomerService getCustomerBillingAddress CUSTOMER ");
    	
    	
    	BillingAddress billAddress = (customer != null ? customer.getBillingAddress() != null ? customer.getBillingAddress() :null:null);
    	logger.debug("\n*******\n\t CustomerService BillingAddress.");
      	
        customerDet.setBillingAddress(billAddress);
        model.addAttribute("customer",  customerDet);
      
        ctrLog(this.getClass(), "getCustomerBillingAddress", "END-->"+state);
        return state;
    }
    
    
    @RequestMapping(value = "/shipping/address", method = RequestMethod.POST)
    public String getCustomerShippingAddress(@Valid @ModelAttribute("customer") Customer customer,
                                       BindingResult result, Model model, HttpServletRequest paramRequest) {
    	
    	ctrLog(this.getClass(), "getCustomerShippingAddress", "START");
    	String state = "redirect:/";
    	
    	/*if (result.hasErrors()) {
    			state = "redirect:/customer/details";
            return state;
        }*/

    	
    	ShippingAddress shippingAddress = (customer != null ? customer.getShippingAddress() != null ? customer.getShippingAddress() :null:null);
    	
    	
    	customerDet.setShippingAddress(shippingAddress);
    	ctrLog(this.getClass(), "**** getCustomerShippingAddress", "Customer ID-->"+customerDet.getCustomerId());
        
    	model.addAttribute("customer",  customerDet);
    	customerDet.setEnabled(true);
    	customerService.addCustomer(customerDet);
//    	boolean response = customerService.updateShippingAddress(customerDet);
//    	if(!response){
//    		state = "redirect:/";
//    	}
        ctrLog(this.getClass(), "getCustomerShippingAddress", "END-->"+state);
        return state;
   
    }
    
    
    @RequestMapping("/profile")
    public String viewCustomerProfile(Model model, HttpServletRequest paramRequest) {
    	manager = new AppManager();
    	String state = "customerProfile";
    	ctrLog(this.getClass(), "viewCustomerProfile", "START");
    	customerDet = new Customer();
    	UserVO curentUser = (UserVO) paramRequest.getSession().getAttribute("suser");
    	if(curentUser!=null){
    		
    		customerDet.setUserId(curentUser.getId());
    		customerDet.setCustomerEmail(curentUser.getEmail());
    		customerDet.setCustomerName(curentUser.getName());
    		customerDet.setCustomerPhone(curentUser.getMobile() != null ? curentUser.getMobile() : null);
    		
    		
    	}else{
    		state = "redirect:/login";
    	}
    	
        model.addAttribute("customer",  customerDet);
        model.addAttribute("model", manager.getUserModel(paramRequest));

    	ctrLog(this.getClass(), "viewCustomerProfile", "END-->"+state);
        return state;
    }

    
    //During Checkout veify Customer details
    @RequestMapping("/details/verify")
    public String verifyCustomer(Model model, HttpServletRequest paramRequest) {
    	manager = new AppManager();
    	Customer temCustomer;
    	String state = "shippingDetails";
    	ctrLog(this.getClass(), "verifyCustomer", "START");
    	
    	UserVO curentUser = (UserVO) paramRequest.getSession().getAttribute("suser");
    	//Adding cartId to Model oblject
    	if(curentUser!=null){
    		 temCustomer = customerService.getCustomerByUserID(curentUser.getId());
    		 int cartId = temCustomer.getCart().getCartId();
    		 
    		 temCustomer.setEnabled(false);
    		 model.addAttribute("customer",  temCustomer);
        	model.addAttribute("cartId", cartId);
        	
        	
    	}else{
    		state = "redirect:/login";
    	}
    	
    	
      
        model.addAttribute("model", manager.getUserModel(paramRequest));

    	ctrLog(this.getClass(), "verifyCustomer", "END-->"+state);
        return state;
    }

    @RequestMapping(value = "/shipping/address/update", method = RequestMethod.POST)
    public String updateShippingAddress(@Valid @ModelAttribute("customer") Customer updateCustomer,
                                       BindingResult result, Model model, HttpServletRequest paramRequest) {
    	
    	ctrLog(this.getClass(), "getCustomerShippingAddress", "START");
    	ctrLog(this.getClass(), "getCustomerShippingAddress", "CUSTOMER Apartment No = "+updateCustomer.getShippingAddress().getApartmentNumber());
    	String state = "redirect:/customer/details/verify";
    	
    	/*if (result.hasErrors()) {
    		state = "redirect:/customer/details";
            return state;
        }*/
    		
    	Customer existCustomer = manager.getCustomerByUser(customerService,  paramRequest);
    	
    	if(existCustomer != null && updateCustomer != null){
    		ctrLog(this.getClass(), "**** updateShippingAddress", "Logged Customer ID-->"+existCustomer.getCustomerId());
    		
    		ShippingAddress updatedShipAdd = updateCustomer.getShippingAddress();
    		ShippingAddress currentShipAdd = existCustomer.getShippingAddress();
    		
    		currentShipAdd.setApartmentNumber(updatedShipAdd !=null ? updatedShipAdd.getApartmentNumber() : currentShipAdd.getApartmentNumber());
    		currentShipAdd.setStreetName(updatedShipAdd !=null  ? updatedShipAdd.getStreetName() : currentShipAdd.getApartmentNumber() );
    		currentShipAdd.setCity(updatedShipAdd !=null  ? updatedShipAdd.getCity() : currentShipAdd.getCity() );
    		currentShipAdd.setState(updatedShipAdd !=null  ? updatedShipAdd.getState() : currentShipAdd.getState() );
    		currentShipAdd.setZipCode(updatedShipAdd !=null  ? updatedShipAdd.getZipCode() : currentShipAdd.getZipCode() );
    		currentShipAdd.setCountry(updatedShipAdd !=null  ? updatedShipAdd.getCountry() : currentShipAdd.getCountry() );
    		
    		existCustomer.setShippingAddress(currentShipAdd);
    		
    		int cartId = existCustomer.getCart().getCartId();
        	model.addAttribute("cartId", cartId);
        
        	
        	boolean response = customerService.updateShippingAddress(existCustomer);
        	
        	model.addAttribute("customer",  existCustomer);
        	ctrLog(this.getClass(), "getCustomerShippingAddress", "updateShippingAddress ==-->"+response);
        	
    	}else{
    		state = "redirect:/login";
    	}
    	
        ctrLog(this.getClass(), "getCustomerShippingAddress", "END-->"+state);
        return state;
   
    }
    
    
    
  public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//Generic Logger for this class
    private void ctrLog(Class<? extends CustomerController> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
