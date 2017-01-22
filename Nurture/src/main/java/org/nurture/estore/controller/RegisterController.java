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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	AppManager manager;
	
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String registerCustomer(Model model, HttpServletRequest paramRequest) {
    	manager = new AppManager();
    	String state = "registerCustomer";
    	ctrLog(this.getClass(), "registerCustomer", "START");
    	
        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer", customer);
        model.addAttribute("model", manager.getUserModel(paramRequest));

    	ctrLog(this.getClass(), "registerCustomer", "END-->"+state);
        return state;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer,
                                       BindingResult result, Model model, HttpServletRequest paramRequest) {
    	
    	ctrLog(this.getClass(), "registerCustomerPost", "START");
    	String state = "registerCustomerSuccess";
    	
    	if (result.hasErrors()) {
            return "registerCustomer";
        }

        List<Customer> customerList = customerService.getAllCustomers();

        for (Customer cust : customerList) {
            if (customer.getCustomerEmail().equals(cust.getCustomerEmail())) {
                model.addAttribute("emailMsg", "Email already exists");
                state = "registerCustomer";
            }

            if (customer.getUsername().equals(cust.getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");
                state = "registerCustomer";
            }
        }
        customer.setEnabled(true);
        customerService.addCustomer(customer);
        
        ctrLog(this.getClass(), "registerCustomerPost", "END-->"+state);
        return state;
    }
    
  //Generic Logger for this class
    private void ctrLog(Class<? extends RegisterController> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
