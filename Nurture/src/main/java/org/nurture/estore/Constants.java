package org.nurture.estore;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;


public class Constants {

	//model Info

	public static final String MODEL_TITILE = "Books Light";
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

	// Uploading Static Contents Images / Icons.
	public static final String[] ALLOWED_FILE_TYPES = {"image/png", "image/jpeg", "image/jpg", "image/gif"};
	public static final Long MAX_FILE_SIZE = 1048576L; //1MB
	
	@Value("${nurture.contents.static.img}")
	//public static  String UPLOAD_FILE_PATH ="C:/Program Files/Apache/Tomcat8/webapps/images/";
	public static  String UPLOAD_FILE_PATH ="/opt/apache-tomcat-8.5.12/webapps/images/";
}
