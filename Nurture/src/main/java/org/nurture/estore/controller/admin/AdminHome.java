package org.nurture.estore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.nurture.estore.controller.CartController;
import org.nurture.estore.controller.RegisterController;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.Product;
import org.nurture.estore.service.CustomerService;
import org.nurture.estore.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminHome {

	private static final Logger logger = LoggerFactory.getLogger(AdminHome.class);
	AppManager manager;
	
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String adminPage(Model model, HttpServletRequest paramRequest) {
    	ctrLog(this.getClass(), "adminPage", "START");
    	manager = new AppManager();
    	String state = "admin";
    	model.addAttribute("model", manager.getUserModel(paramRequest));
        
        ctrLog(this.getClass(), "adminPage", "END-->"+state);
        return state;
    }
    

    @RequestMapping("/productInventory")
    public String productInventory(Model model, HttpServletRequest paramRequest) {
    	ctrLog(this.getClass(), "productInventory", "START");
    	manager = new AppManager();
    	String state = "productInventory";
    	
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        model.addAttribute("model", manager.getUserModel(paramRequest));
        
        ctrLog(this.getClass(), "productInventory", "END-->"+state);
        return state;
    }

    @RequestMapping("/customers")
    public String customerManagement(Model model, HttpServletRequest paramRequest) {
    	
    	ctrLog(this.getClass(), "customerManagement", "START");
    	manager = new AppManager();
    	String state = "customerManagement";
    	
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customers", customerList);
        model.addAttribute("model", manager.getUserModel(paramRequest));
        ctrLog(this.getClass(), "customerManagement", "END-->"+state);
        return state;

    }
    
    
    
    //Generic Logger for this class
    private void ctrLog(Class<? extends AdminHome> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
