package org.nurture.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.nurture.estore.manager.AppManager;
import org.nurture.estore.model.Cart;
import org.nurture.estore.model.CartItem;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.Product;
import org.nurture.estore.service.CartItemService;
import org.nurture.estore.service.CartService;
import org.nurture.estore.service.CustomerService;
import org.nurture.estore.service.ProductService;
import org.nurture.estore.vo.ModelVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/rest/cart")
public class CartResources {

	private static final Logger logger = LoggerFactory.getLogger(CartResources.class);
	
	
    @Autowired
    CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    AppManager manager;
    
    @RequestMapping("/{cartId}")
    public @ResponseBody Cart getCartById(@PathVariable(value = "cartId") int cartId) {
    	resLog(this.getClass(), "getCartById", "START " + cartId);
        return cartService.getCartById(cartId);
    }

    //Request from OrderNow buton from product View
    @RequestMapping(value = "/add/{productId}", method = RequestMethod.GET) 
    public String addItem(@PathVariable(value = "productId") int productId, HttpServletRequest paramReq) throws IOException {
        
    	resLog(this.getClass(), "addItem", "START " + productId);
    	manager = new AppManager();
    
        ModelVo sessionUser = manager.getUserModel(paramReq);
        Integer lookupUserId = (sessionUser != null ? sessionUser.getUserVo() !=null ? sessionUser.getUserVo().getId():0:0);
        if(lookupUserId > 0){
        	
        
        Customer customer =
                customerService.getCustomerByUserID(lookupUserId);
       
       int ciid = 0;
      
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

      
        for (int i = 0; i < cartItems.size(); i++) {
            if (product.getProductId() == cartItems.get(i).getProduct().getProductId()) {
                CartItem cartItem = cartItems.get(i);
                cartItem.setCartItemId(cartItem.getCartItemId());
                cartItem.setQuantity(cartItem.getQuantity() );
                cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
                cartItem.setProduct(product);
                cartItemService.addCartItem(cartItem);
                ciid = cartItem.getCartItemId() ;

            }
        }
       
      CartItem cartItem = new CartItem();
      //cartItem.setCartItemId((ciid+1));
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
        resLog(this.getClass(), "addItem", "END ");
        }else{
    	resLog(this.getClass(), "addItem", "No any Customer/user login... ");
        }
    	 return "redirect:/customer/cart";
    }

 

    @RequestMapping(value = "/remove/{cartItemId}", method = RequestMethod.GET)
    public String removeItem (@PathVariable(value = "cartItemId") int cartItemId) {
    	resLog(this.getClass(), "removeItem", "START " + cartItemId);
        cartItemService.removeCartItemById(cartItemId);
        resLog(this.getClass(), "removeItem", "END="+cartItemId);
        return "redirect:/customer/cart";
    }
   
    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart (@PathVariable(value = "cartId") int cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors (Exception e) {}

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    public void handleServerErrors (Exception e) {}

    
    
    
    //Generic Logger for this class
    private void resLog(Class<? extends CartResources> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
	}
}
