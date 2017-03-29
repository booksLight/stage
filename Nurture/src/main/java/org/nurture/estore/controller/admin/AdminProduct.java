package org.nurture.estore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Product;
import org.nurture.estore.service.ProductService;
import org.nurture.estore.util.FileUpload;
import org.nurture.estore.vo.ProductImg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

	private static final Logger logger = LoggerFactory.getLogger(AdminProduct.class);
	
    private Path path;
    
    @Autowired
    FileUpload fileUpload;

    @Autowired
    private ProductService productService;

	@Autowired
	AppManager manager;
	 
	 
   @GetMapping(path="/product/addProduct")
    public String addProduct(Model model, HttpServletRequest paramRequest) {
    	ctrLog(this.getClass(), "addProduct", "START");
    	 String rootDirectory = manager.getContextPath(paramRequest);
    	 System.out.println("\n ****************** the Root Context Path = "+rootDirectory);
    	String state = "addProduct";
    	model.addAttribute("model", manager.getUserModel(paramRequest));
    	
        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product", product);
        model.addAttribute("productImg", new ProductImg());

        ctrLog(this.getClass(), "addProduct", "END-->"+state);
        return state;
       
    }

   
    @PostMapping(value = "/product/addProduct")
    public String addProductPost(@Valid @ModelAttribute("product") Product product,  BindingResult result, Model model, @RequestParam("file") MultipartFile file,  HttpServletRequest request) {
   
    	 String rootDirectory = manager.getContextPath(request);
    	 System.out.println("\n ****************** the Root Context Path = "+rootDirectory);
        if (result.hasErrors()) {
        	 ctrLog(this.getClass(), "addProductPost", "ERROR ="+result.toString());
            return "addProduct";
        }
        
        ctrLog(this.getClass(), "addProductPost", "START");
    	
    	String state = "redirect:/admin/productInventory/";
    	
    	
    	model.addAttribute("model", manager.getUserModel(request));
    	
       Integer prodductId = productService.addProduct(product);

       logger.debug("\n\t ************ Successfully product saved with "+prodductId);
       
       if(file != null){
    	   String prodFileName =  String.valueOf(prodductId)+ ".png";
    	  logger.debug("\n\t ************ Product Image = "+file.toString());
           fileUpload.process(file,prodFileName);
    	   
       }
      
        ctrLog(this.getClass(), "addProductPost", "END-->"+state);
        return state;
    }

   
    
    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model, HttpServletRequest paramRequest) {
    	 ctrLog(this.getClass(), "editProduct", "START");
     	
     	String state = "editProduct";
     	
     	model.addAttribute("model", manager.getUserModel(paramRequest));
    	
        Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        ctrLog(this.getClass(), "editProduct", "END-->"+state);
        return state;
    }

    @RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result
            ,Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "editProduct";
        }

        ctrLog(this.getClass(), "editProductPost", "START");
     	
     	String state = "redirect:/admin/productInventory/";
     	
     	model.addAttribute("model", manager.getUserModel(request));
     	
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = manager.getContextPath(request);
        path = Paths.get(rootDirectory + "/images/" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }

        productService.editProduct(product);

        ctrLog(this.getClass(), "editProductPost", "END-->"+state);
        return state;
    }

    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
    	
    	ctrLog(this.getClass(), "deleteProduct", "START");
     	
     	String state = "redirect:/admin/productInventory";
     	
     	model.addAttribute("model", manager.getUserModel(request));
     	
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/images/" + id + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Product product = productService.getProductById(id);
        productService.deleteProduct(product);

        ctrLog(this.getClass(), "deleteProduct", "END-->"+state);
        return state;
    }
    
    
    
  //Generic Logger for this class
    private void ctrLog(Class<? extends AdminProduct> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
