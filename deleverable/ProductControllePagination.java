package org.nurture.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.Product;
import org.nurture.estore.service.CustomerService;
import org.nurture.estore.service.ProductService;
import org.nurture.estore.vo.ModelVo;
import org.nurture.estore.vo.ProductJsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductControlleToDor {

	private static final Logger logger = LoggerFactory.getLogger(ProductControlleToDor.class);
	
    @Autowired
    private ProductService productService;
    
    @Autowired
	private CustomerService customerService;
    
    AppManager manager;
    
    
    // PAGINATION :http://stackoverflow.com/questions/31883643/how-do-i-add-simple-pagination-for-spring-mvc
    @RequestMapping(value="/productList", method = RequestMethod.GET, produces =  "application/json")
    public String getProducts (@RequestParam(required = false) Integer page, Model model , Integer offset, Integer maxResults, HttpServletRequest paramRequest)throws IOException {
    	manager = new AppManager();
    	String state = "productList";
    	
    	 List<Product> products = productService.getProducts(offset, maxResults);
		  
		  
    	 model.addAttribute("count", productService.countProducts());  
    	 model.addAttribute("offset", offset);
    	model.addAttribute("products",products != null ? products: new ArrayList<Product>());
    	  model.addAttribute("model", manager.getUserModel(paramRequest));
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
        ModelVo mv = manager.getUserModel(paramRequest);
        model.addAttribute("model", mv);
    	
        ctrLog(this.getClass(), "viewProduct", "END-->"+state);
        return state;
    }
    
	
	
	  private List<Product> createPaginationData(Integer pageDisplayLength) {
		  List<Product> products = productService.getProductList();
		  return products != null ? products: new ArrayList<Product>();
		}
	  
	  
	 
	  
	
    //Generic Logger for this class
    private void ctrLog(Class<? extends ProductControlleToDor> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
