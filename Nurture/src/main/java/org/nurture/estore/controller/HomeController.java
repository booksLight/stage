package org.nurture.estore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.nurture.estore.service.UserService;
import org.nurture.estore.vo.ModelVo;
import org.nurture.estore.vo.ModuleUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.nurture.estore.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Andrew on 03.04.2016.
 */
@Controller
public class HomeController {
 
	 @Autowired
	 private UserService userService;
	 
    @RequestMapping("/")
    public String home(Model model) {
    	model.addAttribute("model", getHomeModule());
        return "home";
    }

  
	@RequestMapping("/login")
    public String login(@RequestParam(value = "error", required=false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }
        if (logout != null) {
            model.addAttribute("msg", "You have been logged out successfully");
        }
  
        return "login";
    }
    
  
    @RequestMapping(value = "/security_check", method = RequestMethod.POST)
    public String securityCheck(@Valid @ModelAttribute("user") User activeUser,
            BindingResult result, Model model, HttpServletRequest request) {
    	
    	System.out.println("\n ********* Login User = "+activeUser.toString()+ "\tLogin User Name = "+activeUser.getUsername()+ "\tLogin User Password = "+activeUser.getPassword());
    	User curentUser = getUser(activeUser); 
    	
    	 request.getSession().setAttribute("cuser",curentUser);
    	
    	
    	
    	 System.out.println("\n ********* DB User = "+curentUser.toString()+ "\tDB User Name = "+curentUser.getUsername()+ "\tDB User Password = "+curentUser.getPassword());
    	 model.addAttribute("user",curentUser);
    	 return "redirect:/customer/cart/";
    }
    


	private User getUser(User cuser) {
		if(cuser!=null){
			return userService.getUserByName(cuser.getUsername());
		}
		return new User();
	}

	  private ModelVo getHomeModule() {
			ModelVo homeModel = new ModelVo();
			homeModel.setTitle("Book Light");
			homeModel.setProduct("Products");
			homeModel.setContact("Contacts");
			homeModel.setHome("Home");
			homeModel.setRegister("Register");
			homeModel.setUserVo(loadUser(null,"visitor"));
			return homeModel;
		}


	private ModuleUserVo loadUser(User user,String type) {
		ModuleUserVo modelUser = new ModuleUserVo();
		modelUser.setType(type);
		
		if(user!=null){
			modelUser.setName(user.getUsername());
			
		}else{
		modelUser.setName("Admin");
		modelUser.setType("admin");
		}
		modelUser.setValid(true);
		return modelUser;
	}
   
}
