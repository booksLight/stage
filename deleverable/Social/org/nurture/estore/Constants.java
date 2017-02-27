package org.nurture.estore;

import javax.servlet.http.HttpSession;

public class Constants {

	//model Info

	public static final String MODEL_TITILE = "Book Light";
	public static final String MODEL_PRODUCTS = "Products";
	public static final String MODEL_CONTACTS = "Contacts";
	public static final String MODEL_HOME = "Home";
	public static final String MODEL_REGISTER = "Register";
	public static final String MODEL_LOGIN = "Login";
	public static final String MODEL_LOGOUT = "Logout";
	public static final String MODEL_USER = "muser";
	
	// Session Attributes
	public static final String SESSION_USER = "suser";
	
	
	// Privileged Attributes :
	public static final String ROL_TYPE_ADM = "ADMIN";
	public static final String ROL_TYPE_CUS = "CUSTOMER";
	public static final String ROL_TYPE_USE = "USER";
	public static final String ROL_TYPE_VIS = "VISITOR";
	
	// Number based on alphabet orders!
	public static final Integer ADM_ID = 41;
	public static final Integer CUST_ID = 114;
	public static final Integer USE_ID = 63;
	public static final Integer VIS_ID = 112;
	
	// General Attributes
	public static final boolean TRUE = true;
	public static final boolean FALSE = false;
	public static final String  STR_NULL = null;
	
	// Mailing Property

	public static final String myUser = "contact.bookslight@gmail.com";
	public static final String mypwd = "nyatorbiciexteyc";


}
