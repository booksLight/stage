package org.nurture.estore.manager;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import org.nurture.estore.Constants;
import org.nurture.estore.model.CartItem;
import org.nurture.estore.model.Customer;
import org.nurture.estore.model.CustomerOrder;
import org.nurture.estore.model.OrderBook;
import org.nurture.estore.model.Privileged;
import org.nurture.estore.model.Product;
import org.nurture.estore.model.User;
import org.nurture.estore.service.CartItemService;
import org.nurture.estore.service.CartService;
import org.nurture.estore.service.CustomerOrderService;
import org.nurture.estore.service.CustomerService;
import org.nurture.estore.service.IMail;
import org.nurture.estore.service.UserService;
import org.nurture.estore.service.impl.MailImpl;
import org.nurture.estore.vo.ModelVo;
import org.nurture.estore.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppManager {

	private static final Logger logger = LoggerFactory.getLogger(AppManager.class);

	
	   @Autowired
	    private CartService cartService;
	   
	   @Autowired
	   CartItemService cartItemService;
	   
	    @Autowired
	    private CustomerOrderService customerOrderService;
	    
	
		/*
	 * Model Info 
	 */
	public ModelVo getUserModel(HttpServletRequest paramReq){
		mgrLog(this.getClass(), "getUserModel", "START");
		ModelVo model = getModel(paramReq);
		 UserVO userVo = (UserVO) paramReq.getSession().getAttribute(Constants.SESSION_USER);
		 mgrLog(this.getClass(), "getUserModel", "USER ="+ (userVo!=null ? userVo.toString():null));
		model.setUserVo(userVo);
		mgrLog(this.getClass(), "getUserModel", "END");
		return model;
	}
	
	/*
	 * Initialize model object
	 */
	public ModelVo getModel(HttpServletRequest req) {
		mgrLog(this.getClass(), "getModel", "START");
		ModelVo homeModel = new ModelVo();
		homeModel.setTitle(Constants.MODEL_TITILE);
		homeModel.setProduct(Constants.MODEL_PRODUCTS);
		homeModel.setContact(Constants.MODEL_CONTACTS);
		homeModel.setHome(Constants.MODEL_HOME);
		homeModel.setCartEnable(true);
		mgrLog(this.getClass(), "getModel", "END");
		return homeModel;
	}
	
	/*
	 * Synched model object with Logged in User
	 */
	public ModelVo updateModel(UserVO paramUser, HttpServletRequest paramReq) {
		mgrLog(this.getClass(), "updateModel", "START");
		ModelVo model = getModel(paramReq);
		UserVO cuser = updateSession( paramUser, paramReq);
		model.setUserVo(cuser);
		mgrLog(this.getClass(), "updateModel", "END");
		return model;
	}

	
	/*
	 * Verify the user from the Session
	 */
	public boolean isUserLoggedOn(HttpServletRequest request) {
		mgrLog(this.getClass(), "isUserLoggedOn", "START");
		boolean state = Constants.FALSE;
		state = (request != null ? (request.getSession() != null
				? (request.getSession().getAttribute(Constants.SESSION_USER) != null ? Constants.TRUE : Constants.FALSE)
				: Constants.FALSE) : Constants.FALSE);
		mgrLog(this.getClass(), "isUserLoggedOn", "END->"+state);
		return state;
	}

	/*
	 * Adding user into the session scope if not else return from the session
	 * scope if exist
	 */
	public UserVO updateSession(UserVO user, HttpServletRequest request) {
		mgrLog(this.getClass(), "updateSession", "START");
		UserVO currentUser = null;
		if (request != null & request.getSession() != null) {
			if (request.getSession().getAttribute(Constants.SESSION_USER) != null) {
				currentUser = (UserVO) request.getSession().getAttribute(Constants.SESSION_USER);
				mgrLog(this.getClass(), "updateSession", "fetch the user object from the session");
			} else {
				request.getSession().setAttribute(Constants.SESSION_USER, user != null ? user : null);
				currentUser = user;
				mgrLog(this.getClass(), "updateSession", "add the user object into the session");
			}
		} else {
			mgrLog(this.getClass(), "updateSession", "Request/Session is Null");
		}
		mgrLog(this.getClass(), "updateSession", "END");
		return currentUser;
	}

	// Logout from session if logged in

	public boolean letMeLogOut(HttpServletRequest request) {
		mgrLog(this.getClass(), "letMeLogOut", "START");
		boolean state = Constants.FALSE;
		if (isUserLoggedOn(request)) {
			request.getSession().invalidate();
			mgrLog(this.getClass(), "letMeLogOut", "session invalidated successfully");
		}

		mgrLog(this.getClass(), "letMeLogOut", "END->"+state);
		return state;
	}
	
	
	// Mapping UserVO with User
	public UserVO getMapUserVO(User parmUser) {
		mgrLog(this.getClass(), "getMapUserVO", "START");
		UserVO mappedUser = null;
		if(parmUser != null){
			mappedUser = new UserVO();
			mappedUser.setId(parmUser.getUserId());
			mappedUser.setName(parmUser.getUsername() !=null ? parmUser.getUsername():parmUser.getUserMobile());
			mappedUser.setEmail(parmUser.getUserEmail() !=null ? parmUser.getUserEmail():null);
			mappedUser.setMobile(parmUser.getUserMobile() !=null ? parmUser.getUserMobile().length() >= 1 ? parmUser.getUserMobile() : null:null);
			mappedUser.setValid(parmUser.isEnabled());
			mappedUser.setType(
					(
							parmUser.getRolId() == Constants.ADM_ID ? Constants.ROL_TYPE_ADM 
									: parmUser.getRolId() == Constants.CUST_ID ? Constants.ROL_TYPE_CUS 
											: parmUser.getRolId() == Constants.USE_ID ? Constants.ROL_TYPE_USE 
													:Constants.ROL_TYPE_VIS)
					);
		}
		
		mgrLog(this.getClass(), "getMapUserVO", "END->");
		return mappedUser;
	}
	
	
	
	public String getPassCode(String strPram) {
		return  (strPram.substring(0, Math.min(strPram.length(), 3)) +strPram.substring(Math.max(strPram.length() - 3, 0))) ;
	}
	
	
	 public void mailRegistrationAcknowledgment(User user)throws AddressException, MessagingException{
		 mgrLog(this.getClass(), "mailRegistrationAcknowledgment", "START");
		 if(user != null){
	    	IMail mail = new MailImpl();
	    	if(user.getUserEmail() != null && user.getPassword() != null){
	    	mail.registrationAcknowledgmet((user.getUserEmail() != null ? user.getUserEmail() :null), (user.getPassword() != null ? user.getPassword() : null));
	    	mgrLog(this.getClass(), "mailRegistrationAcknowledgment", "Registratin AckCode="+user.getPassword());
	    	}
		 }else{
		 mgrLog(this.getClass(), "mailRegistrationAcknowledgment", "Invalid User Object");
		 
		 mgrLog(this.getClass(), "mailRegistrationAcknowledgment", "END");}
	    }
	
	
	 public void mailOrderAcknowledgment(String custEmail,String custParam, String OrderParam)throws AddressException, MessagingException{
		 mgrLog(this.getClass(), "mailOrderAcknowledgment", "START");
		 if(custEmail != null){
			 String sendto = (custEmail != null ? custEmail:null);
	    	IMail mail = new MailImpl();
	    
	    		mail.orderReceipt(sendto, custParam, OrderParam);
	    		mgrLog(this.getClass(), "mailOrderAcknowledgment", " Order Number  ="+OrderParam);
	    	
		 }else{
		 mgrLog(this.getClass(), "mailOrderAcknowledgment", "Invalid Custoemr emilat");
		 
		 mgrLog(this.getClass(), "mailOrderAcknowledgment", "END");}
	    }
	 
	

	public Integer getRol(String regType) {
		Privileged access;
		Integer rolId = 0;
		if(regType.equalsIgnoreCase(Constants.ROL_TYPE_ADM)){
			access = Privileged.ADMIN;
			rolId = access.getAccessCode();
		}
		if(regType.equalsIgnoreCase("CUSTOMER")){
			access = Privileged.CUSTOMER;
			rolId = access.getAccessCode();
		}
		if(regType.equalsIgnoreCase("USER")){
			access = Privileged.USER;
			rolId = access.getAccessCode();
		}
		if(regType.equalsIgnoreCase("VISITOR")){
			access = Privileged.VISITOR;
			rolId = access.getAccessCode();
		}
		return rolId;
	}

	public Customer getCustomerByUser(CustomerService customerService, HttpServletRequest paramRequest) {
		 mgrLog(this.getClass(), "getCustomerByUser", "START");
		
		// Fetching looged user from the session
		UserVO curentUser = updateSession(null, paramRequest);
    	
    	if(curentUser!=null){
    		 mgrLog(this.getClass(), "getCustomerByUser", "END with Customer");
    		 return customerService.getCustomerByUserID(curentUser.getId());
    	}
    	mgrLog(this.getClass(), "getCustomerByUser", "END with null");
		return null;
	}

	


	

		public void updateUserName(Customer customerParam, UserService userService) {
			mgrLog(this.getClass(), "updateUserName", "START");
			if(customerParam != null ){
				
			User useParam = new User();
			
			useParam.setUsername(customerParam.getCustomerName());
			useParam.setRolId(getRol("CUSTOMER"));
			useParam.setUserId(customerParam.getUserId());
			try{
				userService.saveOrUpdateUserName(useParam);
			}catch(Exception e){mgrLog(this.getClass(), "updateUserName", "Exception :" +e.getMessage());}
			}else{
				mgrLog(this.getClass(), "updateUserName", "Customer is null...Over");
			}
			mgrLog(this.getClass(), "getCustomerByUser", "END ");
		}

	
// Migration
		

				public List<OrderBook> mapOrderBookOnCustomerOrder(CustomerOrder customerNewOrder) {
					mgrLog(this.getClass(), "mapOrderBookOnCustomerOrder", "START ");
					if(customerNewOrder != null){
						List<CartItem> cartItems = customerNewOrder.getCart() != null ? customerNewOrder.getCart().getCartItems() != null ? customerNewOrder.getCart().getCartItems() :null:null;
						if(cartItems != null){
							OrderBook orderBook = null;
							List<OrderBook> orderBooks = new ArrayList<OrderBook>();
							for(CartItem orderItem : cartItems){
								 orderBook = new OrderBook();
								 
								 orderBook.setOrderId(customerNewOrder.getCustomerOrderId());
								 orderBook.setCartId(orderItem.getCart().getCartId());
								 orderBook.setCartItemId(orderItem.getCartItemId());
								 orderBook.setProductId(orderItem.getProduct().getProductId());
								 orderBook.setQuantity(orderItem.getQuantity());
								 orderBook.setTotalPrice(orderItem.getTotalPrice());
								 
								 orderBooks.add(orderBook);
							}
							mgrLog(this.getClass(), "mapOrderBookOnCustomerOrder", "END with List of Orrdered Items");
							return orderBooks;
						}
					}
					mgrLog(this.getClass(), "mapOrderBookOnCustomerOrder", "END ");
					return null;
				}
				
			// Saved Cartitems to OrderBook	
				public void saveOrUpdateOrderedItems(List<OrderBook> orderedItems) {
					mgrLog(this.getClass(), "saveOrUpdateOrderedItems", "START ");
					if(orderedItems != null ){
						for(OrderBook orderBook : orderedItems){
							customerOrderService.saveOrUpdateOrderBook(orderBook);
						}
					}
					mgrLog(this.getClass(), "saveOrUpdateOrderedItems", "END ");
				}
				
			// Removing cart items after successfully placed ordered
				public void deleteOrderedItemsFromCart(CustomerOrder orderedRef) {
					mgrLog(this.getClass(), "deleteOrderedItemsFromCart", "START");
					if(orderedRef != null){
						if(orderedRef.getCart() != null){
							for(CartItem orderItem : orderedRef.getCart().getCartItems()){
							cartItemService.removeCartItemById(orderItem.getCartItemId());
						}
					}
					}
					mgrLog(this.getClass(), "deleteOrderedItemsFromCart", "END ");
				}
				
			//Fetchs Customer Orders by cartId	
				public List<CustomerOrder> getCustomerOrdersByCartId(Integer cartId) {
					List<CustomerOrder> ordered = null;
					if(cartId > 0){
						logger.info("\n\t Fetching Customer Order by cartid="+cartId);
						ordered = customerOrderService.getCustomerOrdersByCartId(cartId);
					}
					return ordered;
				}
				
				
			// Fetch Customer Order by customerOrderId	
				public CustomerOrder getCustomerOrderById(Integer customerOrderId) {
					mgrLog(this.getClass(), "getCustomerOrderById", "START ");
					CustomerOrder customerOrder = null;
					if(customerOrderId > 0)
					{
						 customerOrder = customerOrderService.getCustomerOrderById(customerOrderId);
						List<OrderBook> orderedBooks =  customerOrderService.getOrderedBooksByOrderId(customerOrderId);
						
						if(customerOrder != null){
							if(customerOrder.getCart() !=null){
								double grandTotal=0.0;
								List<CartItem> cartItems = null;
								if(customerOrder.getCart().getCartItems()  != null ){
									System.out.println( "\n\n ************* SIZE of the Customer CartItems = "+ customerOrder.getCart().getCartItems().size());
									 cartItems = new ArrayList<CartItem>();
									for(OrderBook orderBook : orderedBooks ){
										CartItem cartItem = new CartItem();
										cartItem.setCartItemId(orderBook.getCartItemId());
										Product tempProduct = new Product();
										tempProduct.setProductId(orderBook.getProductId());
										cartItem.setProduct(tempProduct);
										cartItem.setQuantity(orderBook.getQuantity());
										cartItem.setTotalPrice(orderBook.getTotalPrice());
										cartItems.add(cartItem);
										grandTotal  = (grandTotal + orderBook.getTotalPrice());
									}
									
								}
								customerOrder.getCart().setCartItems(cartItems);
								
								customerOrder.getCart().setGrandTotal(grandTotal);
							}
						}
					}
					
					mgrLog(this.getClass(), "getCustomerOrderById", "END with Order Details "+customerOrder.getCart().getCartItems().size());
					
					return customerOrder;
				}
				
				
				
				
				
				
				// Generic Logger
				public void mgrLog(Class<? extends AppManager> paramCclass, String paramMethod, String paramMsg) {
					logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
				}

				

				

				

				
}
