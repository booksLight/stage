package org.nurture.estore.manager;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import org.nurture.estore.Constants;
import org.nurture.estore.model.Privileged;
import org.nurture.estore.model.User;
import org.nurture.estore.service.IMail;
import org.nurture.estore.service.impl.MailImpl;
import org.nurture.estore.vo.ModelVo;
import org.nurture.estore.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppManager {

	private static final Logger logger = LoggerFactory.getLogger(AppManager.class);

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
	    	mail.generateAndSendFeedbacks((user.getUserEmail() != null ? user.getUserEmail() :null), (user.getPassword() != null ? user.getPassword() : null));
	    	mgrLog(this.getClass(), "mailRegistrationAcknowledgment", "Registratin AckCode="+user.getPassword());
	    	}
		 }else{
		 mgrLog(this.getClass(), "mailRegistrationAcknowledgment", "Invalid User Object");
		 
		 mgrLog(this.getClass(), "mailRegistrationAcknowledgment", "END");}
	    }
	
	
	
	// Generic Logger
	public void mgrLog(Class<? extends AppManager> paramCclass, String paramMethod, String paramMsg) {
		logger.info(paramCclass.getName() + " : " + paramMethod + "() : " + paramMsg);
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

	



}