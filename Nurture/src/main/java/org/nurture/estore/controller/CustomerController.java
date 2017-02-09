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

    @RequestMapping("/details")
    public String viewCustomer(Model model, HttpServletRequest paramRequest) {
    	manager = new AppManager();
    	String state = "customerDetails";
    	ctrLog(this.getClass(), "viewCustomer", "START");
    	customerDet = new Customer();
    	UserVO curentUser = (UserVO) paramRequest.getSession().getAttribute("suser");
    	if(curentUser!=null){
    		System.out.println("\n*******\n\t CustomerService Current USER ="+curentUser);
    		customerDet.setUserId(curentUser.getId());
    		customerDet.setCustomerEmail(curentUser.getEmail());
    		customerDet.setCustomerName(curentUser.getName());
    		
    		
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
    	
    	System.out.println("\n*******\n\t CustomerService getCustomerInfo CUSTOMER ="+customer);
    	
    	if(customer.getCustomerName()!=null && customer.getCustomerName().length() >4){
    		customerDet.setCustomerName(customer.getCustomerName() );
    	}
    
    	if(customer.getCustomerPhone().length() == 10){
    		customerDet.setCustomerPhone(customer.getCustomerPhone() );
    	}
      
        model.addAttribute("customer",  customerDet);
       
        ctrLog(this.getClass(), "getCustomerInfo", "END-->"+state);
        return state;
    }
    
   
    
    @RequestMapping(value = "/billing/address", method = RequestMethod.POST)
    public String getCustomerBillingAddress(@Valid @ModelAttribute("customer") Customer customer,
                                       BindingResult result, Model model, HttpServletRequest paramRequest) {
    	
    	ctrLog(this.getClass(), "getCustomerBillingAddress", "START");
    	String state = "customerDetails";
    	

    	System.out.println("\n*******\n\t CustomerService getCustomerBillingAddress CUSTOMER ="+customer);
    	
    	
    	BillingAddress billAddress = (customer != null ? customer.getBillingAddress() != null ? customer.getBillingAddress() :null:null);
    	System.out.println("\n*******\n\t CustomerService BillingAddress ="+billAddress.toString());
      
    	
		
		//96310 26902 // 0271651H (Ramesh Kumar[Chuunu])
		
        customerDet.setBillingAddress(billAddress);
        model.addAttribute("customer",  customerDet);
      
        ctrLog(this.getClass(), "getCustomerBillingAddress", "END-->"+state);
        return state;
    }
    
    
    @RequestMapping(value = "/shipping/address", method = RequestMethod.POST)
    public String getCustomerShippingAddress(@Valid @ModelAttribute("customer") Customer customer,
                                       BindingResult result, Model model, HttpServletRequest paramRequest) {
    	
    	ctrLog(this.getClass(), "getCustomerShippingAddress", "START");
    	String state = "customerDetails";
    	
    	/*if (result.hasErrors()) {
    		System.out.println("\n\t RESULT ERRORS ="+result.hasErrors());
    		state = "redirect:/customer/details";
            return state;
        }*/

    	
    	ShippingAddress shippingAddress = (customer != null ? customer.getShippingAddress() != null ? customer.getShippingAddress() :null:null);
    	
    	
    	customerDet.setShippingAddress(shippingAddress);
          
        
    	model.addAttribute("customer",  customerDet);
       // customerService.addCustomer(customer);
    	System.out.println("\n*******\n CUSTOMER  ="+customer.toString());
    	System.out.println("\n*******\n  CUSTOMER DETAILS ="+customerDet.toString());
    	customerService.addCustomer(customerDet);
        ctrLog(this.getClass(), "getCustomerShippingAddress", "END-->"+state);
        return state;
   
    }
    
    
  //Generic Logger for this class
    private void ctrLog(Class<? extends CustomerController> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
