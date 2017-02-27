package org.nurture;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.nurture.estore.service.IMail;
import org.nurture.estore.service.impl.MailImpl;

public class RND {

	public static void main(String[] args) throws AddressException, MessagingException {
		
		sendEmailByAPI();
    	
		System.out.println("\n\n ===> Your cloul Logic has just sent an Email successfully. Check your email..");

	}

	 public static void sendEmailByAPI()throws AddressException, MessagingException{
	    	IMail mail = new MailImpl();
	    	
	    	
	    	//mail.generateAndSendEmail();
	    	mail.generateAndSendFeedbacks("rakesh.sharma@mindtree.com", "working on AWS");
	    }


}
