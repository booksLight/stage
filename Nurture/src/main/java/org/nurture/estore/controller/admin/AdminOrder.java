package org.nurture.estore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Product;
import org.nurture.estore.service.AdminSvc;
import org.nurture.estore.service.ProductService;
import org.nurture.estore.util.FileUpload;
import org.nurture.estore.vo.OrderMapper;
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
import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class AdminOrder {

	private static final Logger logger = LoggerFactory.getLogger(AdminOrder.class);
	
    @Autowired
    private AdminSvc adminSvc;

	@Autowired
	AppManager manager;
	 
	 
   @RequestMapping("/repo")
    public String getTotalOrdersReport(Model model, HttpServletRequest paramRequest) {
    	ctrAdminLog(this.getClass(), "getTotalOrdersReport", "START");
    	
    	String state ="about";
    	List<OrderMapper> trakOrders =  adminSvc.getOrdersRowMapper();
    	if(trakOrders != null){
    		for(OrderMapper ord : trakOrders){
    			 System.out.println("\n *** \t AdminOrder (Controller) =  :"+ord.toString());
    		}
    	}
    	
    	ctrAdminLog(this.getClass(), "getTotalOrdersReport", "END-->");
        return state;
       
    }

   
    
  //Generic Logger for this class
    private void ctrAdminLog(Class<? extends AdminOrder> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
