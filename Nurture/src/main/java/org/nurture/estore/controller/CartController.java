package org.nurture.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.nurture.estore.model.User;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Cart;
import org.nurture.estore.model.CartItem;
import org.nurture.estore.model.Customer;
import org.nurture.estore.service.CartService;
import org.nurture.estore.service.CustomerService;
import org.nurture.estore.vo.CartItemsVO;
import org.nurture.estore.vo.ModelVo;
import org.nurture.estore.vo.ProductVO;
import org.nurture.estore.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private CartService cartService;

    AppManager manager;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getCart(HttpServletRequest paramRequest ) {
    	
    	ctrLog(this.getClass(), "getCart", "START");
    	manager = new AppManager();
    	String state = "redirect:/customer/cart/";
    	 if(!manager.isUserLoggedOn(paramRequest)){
    		 state = "redirect:/login";
    	 }
    	UserVO curentUser = (UserVO) paramRequest.getSession().getAttribute("suser");
    	if(curentUser!=null){
    		Customer customer = customerService.getCustomerByUserID(curentUser.getId());
    		ctrLog(this.getClass(),"getCart", "Current User ="+curentUser.toString());
      
    		int cartId = customer.getCart().getCartId();
        	ctrLog(this.getClass(), "getCart", "END ");
        	state = state + cartId;
    	}else{
    		state = "redirect:/login";
    	}
    	return state;
    }

    @RequestMapping(value ="/{cartId}", method = RequestMethod.GET)
    public String getCartRedirect(@PathVariable(value = "cartId") int cartId, Model model,HttpServletRequest paramRequest) {
    	ctrLog(this.getClass(), "getCartRedirect", "START");
    	manager = new AppManager();
    	String state = "cart";
    	CartItemsVO civ;
    	ProductVO pvo = null;
    	Double cartGrandTotal = 0.0;
    	List<CartItemsVO> civs = null;
    	
    	 if(!manager.isUserLoggedOn(paramRequest)){
    		 state = "redirect:/login";
    	 }
    	Cart cart= cartService.getCartById(cartId);
    	if(cart != null){
    		 civs = new ArrayList<CartItemsVO>();
    		 logger.info("\n ***** CartItem SIZE ="+cart.getCartItems().size());
    		for(CartItem item : cart.getCartItems()){
    			civ = new CartItemsVO();
    			civ.setCartId(cartId);
    			civ.setCartItemId(item.getCartItemId());
    			civ.setQuantity(item.getQuantity());
    			civ.setTotalPrice(item.getTotalPrice());
    			if(item.getProduct() != null){
    				 pvo = new ProductVO();
    				 pvo.setProductId(item.getProduct().getProductId());
    				 pvo.setProductName(item.getProduct().getProductName());
    				 pvo.setProductPrice(item.getProduct().getProductPrice());
    				 pvo.setProductStatus(item.getProduct().getProductStatus());
    				 pvo.setProductCategory(item.getProduct().getProductCategory());
    				 pvo.setProductCondition(item.getProduct().getProductCondition());
    				 pvo.setProductDescription(item.getProduct().getProductDescription());
    				 pvo.setProductManufacture(item.getProduct().getProductManufacture());
    				 cartGrandTotal += pvo.getProductPrice();
    				 civ.setProductVo(pvo);
    			}
    			civs.add(civ);
    		}
    		cart.setGrandTotal(cartGrandTotal);
    			cartService.updateGrandTotal(cart);
    	}
    	model.addAttribute("calGrandTotal", cartGrandTotal);
    	model.addAttribute("cartItems",civs);
        model.addAttribute("cartId", cartId);
        model.addAttribute("model", manager.getUserModel(paramRequest));
        ctrLog(this.getClass(), "getCartRedirect", "END");
        return state;
    }
    
    
    //Generic Logger for this class
    private void ctrLog(Class<? extends CartController> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
	}
}
