package org.brand.self.controller;

import org.brand.self.model.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class DefaultController {
	
	final static Logger logger = LoggerFactory.getLogger("DefaultController");
	
	
	@RequestMapping("/Test")
	public String loadLandingPortal(){
		
		logger.info( "\n Controller | DefaultController | loadLandingPortal : String");
		
		return "landing";
	}

	
	@RequestMapping("/showMessage")
	public ModelAndView showMessage(){
		logger.info( "\n Controller | DefaultController | showMessage");
		creatModel();
		return new ModelAndView("showMessage", "message", "Helloji");
	}


	private void creatModel() {
		Cart cart = new Cart();
		
		
	}
}
