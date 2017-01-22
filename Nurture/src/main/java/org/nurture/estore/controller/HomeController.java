package org.nurture.estore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.nurture.estore.service.UserService;
import org.nurture.estore.vo.ModelVo;
import org.nurture.estore.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.nurture.estore.Constants;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class HomeController {
 
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	 @Autowired
	 private UserService userService;
	 AppManager manager;
	 
    @RequestMapping("/")
    public String getHome(Model model, HttpServletRequest paramRequest) {
    	ctrLog(this.getClass(), "getHome", "START");
    	 manager = new AppManager();
    	 String state = "home";
    	 
    	 model.addAttribute("model", manager.getUserModel(paramRequest));
    	
    	 if(!manager.isUserLoggedOn(paramRequest)){
    		 state = "redirect:/login";
    	 }
    	
    	 ctrLog(this.getClass(), "getHome", "END ->"+state);
    		
    	return state;
    }

  
	


	@RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required=false) String error,
                        @RequestParam(value = "logout", required = false) String paramLogout, Model paramModel, HttpServletRequest paramRequest) {
		
		ctrLog(this.getClass(), "getLogin", "START");
		manager = new AppManager();
    	String state = "login";
    	
		paramModel.addAttribute("model", manager.getModel(paramRequest));
    	 
        if (error != null) {
        	paramModel.addAttribute("error", "Invalid username or password");
        }
        if (paramLogout != null) {
        	paramModel.addAttribute("msg", "You have been logged out successfully");
        }
        ctrLog(this.getClass(), "getLogin", "END ->"+state);
        return state;
    }
    
  
    @RequestMapping(value = "/security_check", method = RequestMethod.POST)
    public String getSecurityCheck(@Valid @ModelAttribute("user") User activeUser,
            BindingResult result, Model model, HttpServletRequest paramRequest) {
    	
    	ctrLog(this.getClass(), "getSecurityCheck", "START");
    	String state = "redirect:/customer/cart/";
    	manager = new AppManager();
    	UserVO userVO;
    	
    	User curentUser = getUser(activeUser); 
    	ModelVo modelUser = manager.getModel(paramRequest);
    	userVO = manager.getMapUserVO(curentUser);
    	userVO = manager.updateSession(userVO,paramRequest);
    	modelUser.setUserVo(userVO);
    	model.addAttribute(Constants.MODEL_USER,modelUser);
    	
    	ctrLog(this.getClass(), "getSecurityCheck", "User Details ->"+modelUser.toString());
    	ctrLog(this.getClass(), "getSecurityCheck", "END ->"+state);
    	 
    	 return state;
    }
    


	private User getUser(User cuser) {
		if(cuser!=null){
			return userService.getUserByName(cuser.getUsername());
		}
		return new User();
	}

	@RequestMapping("/security_logout")
    public String getLogOut(String logout, Model model, HttpServletRequest paramRequest) {
		
		ctrLog(this.getClass(), "getLogOut", "START");
    	String state = "redirect:/";
    	
		manager = new AppManager();
    	 model.addAttribute("model", manager.getModel(paramRequest));
    	 manager.letMeLogOut(paramRequest);
    	 ctrLog(this.getClass(), "getLogOut", "END ->"+state);
    	 return state;    
    }
	
	
	private void ctrLog(Class<? extends HomeController> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
		
	}
   
}
