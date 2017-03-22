package org.nurture.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.Product;
import org.nurture.estore.service.CustomerService;
import org.nurture.estore.service.ProductService;
import org.nurture.estore.vo.ModelVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
    @Autowired
    private ProductService productService;
    
    @Autowired
	private CustomerService customerService;
    
    @Autowired
    AppManager manager;
    
    @RequestMapping("/productList/{offSet}")
    public String getProducts (@PathVariable(value = "offSet") int offSet, Model model, HttpServletRequest paramRequest) {
    	 
    	String state = "productList";
    	ctrLog(this.getClass(), "getProducts", "START");
    	 model.addAttribute("model", manager.getUserModel(paramRequest));  
    	 model.addAttribute("products",manager.lookUptProducts("OTH", offSet, manager.initPaginition(offSet,"OTH")));
    	 model.addAttribute("pages", manager.getTotalPages("OTH"));
        ctrLog(this.getClass(), "getProducts", "END-->"+state);
        return state;
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model, HttpServletRequest paramRequest) {
    	 
    	String state = "viewProduct";
    	ctrLog(this.getClass(), "viewProduct", "START");
    	Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        ModelVo mv = manager.getUserModel(paramRequest);
        model.addAttribute("model", mv);
    	
        ctrLog(this.getClass(), "viewProduct", "END-->"+state);
        return state;
    }
    
    //Generic Logger for this class
    private void ctrLog(Class<? extends ProductController> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
