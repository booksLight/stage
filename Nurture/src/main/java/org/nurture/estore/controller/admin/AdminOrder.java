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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Product;
import org.nurture.estore.service.AdminSvc;
import org.nurture.estore.service.ProductService;
import org.nurture.estore.util.FileUpload;
import org.nurture.estore.vo.OrderMapper;
import org.nurture.estore.vo.OrderReport;
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

@RestController
@RequestMapping("/admin")
public class AdminOrder {

	private static final Logger logger = LoggerFactory.getLogger(AdminOrder.class);
	
    @Autowired
    private AdminSvc adminSvc;

	@Autowired
	AppManager manager;
	
	 
		@RequestMapping(value = "/repo", method = RequestMethod.GET, produces = "application/json")
	    public List<OrderMapper> getTotalOrdersReport(Model model, HttpServletRequest paramRequest) {
	    	ctrAdminLog(this.getClass(), "getTotalOrdersReport", "START");
	    	
	    	
	    	
	    	List<OrderMapper> trakOrders =  adminSvc.getOrdersRowMapper();
	    	if(trakOrders != null){
	    		for(OrderMapper ord : trakOrders){
	    			 System.out.println("\n *** \t AdminOrder (Controller) =  :"+ord.toString());
	    		}
	    	}
	    	
	    	
	    	
	    	ctrAdminLog(this.getClass(), "getTotalOrdersReport", "END-->");
	        return trakOrders;
	       
	    }
	
	/* 
	@RequestMapping(value = "/repo", method = RequestMethod.GET, produces = "application/json")
    public OrderReport getTotalOrdersReport(Model model, HttpServletRequest paramRequest) {
    	ctrAdminLog(this.getClass(), "getTotalOrdersReport", "START");
    	
    	//String state ="/admin/ordersReport";
    	OrderReport report = new OrderReport();
    	
    	List<OrderMapper> trakOrders =  adminSvc.getOrdersRowMapper();
    	if(trakOrders != null){
    		report.setData(trakOrders);
    		for(OrderMapper ord : trakOrders){
    			 System.out.println("\n *** \t AdminOrder (Controller) =  :"+ord.toString());
    		}
    	}
    	
    	report.setDraw(1);
    	report.setRecordsFiltered(12);
    	report.setRecordsTotal(12);
    	
    	ctrAdminLog(this.getClass(), "getTotalOrdersReport", "END-->");
        return report;
       
    }*/

   
    
  //Generic Logger for this class
    private void ctrAdminLog(Class<? extends AdminOrder> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
