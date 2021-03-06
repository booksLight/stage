package org.nurture.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.BillingAddress;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.ShippingAddress;
import org.nurture.estore.model.User;
import org.nurture.estore.service.CustomerService;
import org.nurture.estore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;
    
    @Autowired
	AppManager manager;

    @RequestMapping("/register")
    public String registerUser(Model model, HttpServletRequest paramRequest) {
    	 
    	String state = "login";
    	ctrLog(this.getClass(), "registerUser", "START");
      
        model.addAttribute("user",  new User());
        model.addAttribute("model", manager.getUserModel(paramRequest));

    	ctrLog(this.getClass(), "registerUser", "END-->"+state);
        return state;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserPost(@Valid @ModelAttribute("user") User user,
                                       BindingResult result, Model model, HttpServletRequest paramRequest) throws AddressException, MessagingException {
    	
    	ctrLog(this.getClass(), "registerUserPost", "START");
    	 
    	boolean error = false;
    	String state = "redirect:/login";
    	
    	if (result.hasErrors()) {
            return "login";
        }

        List<User> userList = userService.getAllUsers();

        for (User currentUser : userList) {
            if (currentUser.getUserEmail().equals(user.getUserEmail())) {
            	result.rejectValue("userEmail", "duplicate.user.userEmail");
            	error = true;
            }
            if (currentUser.getUserMobile().equals(user.getUserMobile())) {
            	result.rejectValue("userMobile", "duplicate.user.mobile");
            	error = true;
            }
     
        }
        
        if (error) {
            return "login";
        }
        user.setRolId(manager.getRol("USER"));
        user.setEnabled(true);
        user.setPassword(manager.getPassCode(user.getUserMobile()));
        userService.addUser(user);
        ctrLog(this.getClass(), "registerUserPost", "Successfully Added new User!");
        try{
        	manager.mailRegistrationAcknowledgment(user!= null ? user : null);
        }catch(Exception e){
        	 ctrLog(this.getClass(), "registerUserPost", "ERROR -->"+e);
        	
        }
        ctrLog(this.getClass(), "registerUserPost", "END -->"+state);
        return state;
    }
    
  //Generic Logger for this class
    private void ctrLog(Class<? extends RegisterController> paramCclass, String paramMethod, String paramMsg) {
  		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
  	}
}
