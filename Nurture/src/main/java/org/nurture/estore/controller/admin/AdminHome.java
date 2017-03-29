package org.nurture.estore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	

	@Autowired
	AppManager manager;
	
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String adminPage(Model model, HttpServletRequest paramRequest) {
    	ctrLog(this.getClass(), "adminPage", "START");
    	 String rootDirectory = manager.getContextPath(paramRequest);
    	 System.out.println("\n ****************** the Root Context Path = "+rootDirectory);
       	String state = "admin";
    	model.addAttribute("model", manager.getUserModel(paramRequest));
        
        ctrLog(this.getClass(), "adminPage", "END-->"+state);
        return state;
    }
    

    @GetMapping(path="/productInventory")
    public String productInventory(Model model, HttpServletRequest paramRequest) {
    	ctrLog(this.getClass(), "productInventory", "START");
    	 String state = "productInventory";
    	
        model.addAttribute("products", manager.getAllProduts(0, 15));
        model.addAttribute("model", manager.getUserModel(paramRequest));
        
        ctrLog(this.getClass(), "productInventory", "END-->"+state);
        return state;
    }

    @GetMapping(path="/customers")
    public String customerManagement(Model model, HttpServletRequest paramRequest) {
    	
    	ctrLog(this.getClass(), "customerManagement", "START");
    	
    	String state = "customerManagement";
    	
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customers", customerList);
        model.addAttribute("model", manager.getUserModel(paramRequest));
        ctrLog(this.getClass(), "customerManagement", "END-->"+state);
        return state;

    }
    
    @GetMapping(path="/order")
	 public String getOrderReport (Model model, HttpServletRequest paramRequest) {
    	ctrLog(this.getClass(), "getOrderReport", "START");
    	   model.addAttribute("model", manager.getUserModel(paramRequest));  	
    	   model.addAttribute("model", manager.getModel(paramRequest));
    	ctrLog(this.getClass(), "getOrderReport", "End");
	    return "/admin/ordersReport";
	} 
	
    
    //Generic Logger for this class
    private void ctrLog(Class<? extends AdminHome> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
