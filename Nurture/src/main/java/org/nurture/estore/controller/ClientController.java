package org.nurture.estore.controller;

import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.nurture.estore.service.ClientService;
import org.nurture.estore.vo.CustomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.nurture.estore.Constants;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vender")
public class ClientController {
 
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	  @Autowired
	  AppManager manager;
	 
    @GetMapping("/brillient/{offSet}")
    public String getBrilientHome(@PathVariable(value = "offSet") int offSet, Model model, HttpServletRequest paramRequest) {
    	ctrLog(this.getClass(), "getBrilientHome", "START with Ofset ="+offSet);
    	 String state = "brillient";
    	
    	 model.addAttribute("model", manager.getUserModel(paramRequest));
    	 model.addAttribute(Constants.MODEL_USER, manager.getModel(paramRequest));
    	 model.addAttribute("pages", manager.getTotalPages("BPS"));
    	 
    	 model.addAttribute("products",manager.lookUptProducts("BPS", offSet, manager.initPaginition(offSet,"BPS")));
    	 ctrLog(this.getClass(), "getBrilientHome", "END ->"+state);
    	return state;
    }

   
	private void ctrLog(Class<? extends ClientController> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
		
	}
   
}
