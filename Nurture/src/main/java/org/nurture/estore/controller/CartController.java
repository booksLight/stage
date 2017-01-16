package org.nurture.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import org.nurture.estore.model.User;
import org.nurture.estore.model.Customer;
import org.nurture.estore.service.CustomerService;

/**
 * Created by Andrew on 27.04.2016.
 */
@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;

  
    @RequestMapping
    public String getCart(HttpServletRequest request ) {
    	User curentUser = (User) request.getSession().getAttribute("cuser");
    	System.out.println("\n ********* CustomerService Login User Name = "+ curentUser.getUsername()+ "\t CustomerService Login User Password = "+curentUser.getPassword());
       Customer customer = customerService.getCustomerByUsername((curentUser.getUsername()));
       //Customer customer = customerService.getCustomerByUsername(("test"));
        int cartId = customer.getCart().getCartId();
        	System.out.println("\n ##### Cart ID ="+cartId);
        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable(value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }
}
