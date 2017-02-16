package org.nurture.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Product;
import org.nurture.estore.service.ProductService;
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
    AppManager manager;
    
    @RequestMapping("/productList")
    public String getProducts (Model model, HttpServletRequest paramRequest) {
    	manager = new AppManager();
    	String state = "productList";
    	ctrLog(this.getClass(), "getProducts", "START");
    	 model.addAttribute("model", manager.getUserModel(paramRequest));
        List<Product> products = productService.getProductList();
        System.out.println("\n\t PRODUCTS SIZE = "+ products.size());
        model.addAttribute("products", products);
        ctrLog(this.getClass(), "getProducts", "END-->"+state);
        return state;
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model, HttpServletRequest paramRequest) {
    	manager = new AppManager();
    	String state = "viewProduct";
    	ctrLog(this.getClass(), "viewProduct", "START");
    	Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        model.addAttribute("model", manager.getUserModel(paramRequest));
        ctrLog(this.getClass(), "viewProduct", "END-->"+state);
        return state;
    }
    
    //Generic Logger for this class
    private void ctrLog(Class<? extends ProductController> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
