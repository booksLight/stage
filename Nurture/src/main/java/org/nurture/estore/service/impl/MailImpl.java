package org.nurture.estore.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.nurture.estore.Constants;
import org.nurture.estore.controller.OrderController;
import org.nurture.estore.service.IMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @see Generic Mail Server Configurable 
 * @Step1 : Initialized Mail Server Properties
 * @Step2 : Create a Mail Session
 * @Step3 : Get Session and Send mail 
 *
 */
public class MailImpl implements IMail {
	
	private static final Logger logger = LoggerFactory.getLogger(MailImpl.class);
	static Session mailSession;
	static MimeMessage generateMailMessage;
	String sendto = "bookslight@outlook.com";
	String sendCC = "contact.bookslight@gmail.com";
	
	public void generateAndSendEmail() throws AddressException, MessagingException {
   	
		// Step1
		mailSession = Session.getDefaultInstance(configureMailServerProperties(), null);
		
		// Step 2 & 3
		sendFeedBack(mailSession, composeMessage(mailSession, null, null));
 
	}
	
	
	//customized feedback
    public void generateAndSendFeedbacks(final String sendTo, final String msg) throws AddressException, MessagingException {
   	 
		// Step1
    	mailSession = Session.getDefaultInstance(configureMailServerProperties(), null);
    	
 
		// Step 2 & 3
    	sendFeedBack(mailSession, composeMessage(mailSession,sendTo,msg));
	}
	
    
    
    
    // Configurable Mail Server Properties 
    private Properties configureMailServerProperties() {
    	logger.debug("\n START :: configureMailServerProperties()");
    	Properties mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		logger.debug("\n END :: configureMailServerProperties()");
		return mailServerProperties;
	}
    
    
    // Composing feedback/feed back response message
    private MimeMessage composeMessage(final Session mailSessionParam, final String sendTo, final String msgParam) throws AddressException, MessagingException {
	
		logger.debug("\n START :: composeMessage()");
		
		generateMailMessage = new MimeMessage(mailSessionParam);
		
		if(sendTo != null){
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
		
		
		if(sendCC != null){
			generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(sendCC));
		}
		
		generateMailMessage.setSubject("Book Light Greetings!");
		String fmsg ="Thank you for your passion!";
		
		
		 fmsg += msgParam != null ? " ("+ msgParam +")":""; 
		 
		String emailBody = "Greetings Applicant! <br><br>We’re excited to warm welcome and in continuety plz use our system generated passcode <b>"+msgParam +"</b>(password). <br/> Request to plz keep it secure at your end."
				+ "<br><br>We read all feedback carefully and by this you agree that we may contact you to better understand our responsive eco-system norms, accepted! <br><br> Thanks & Regards, <br>Book Light Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		
		logger.debug("\n END :: composeMessage()");
		}
		return generateMailMessage;
	}
    
    
    //sending feedback by configured mail server
    private void sendFeedBack(final Session mailSession, final MimeMessage generateMailMessageParam) throws MessagingException {
    	logger.debug("\nSTART :: sendFeedBack()");
    	Transport transport = mailSession.getTransport("smtp");
	
		transport.connect("smtp.gmail.com", Constants.myUser, Constants.mypwd);
		
		transport.sendMessage(generateMailMessageParam, generateMailMessageParam.getAllRecipients());
		transport.close();
		logger.debug("\nEND :: sendFeedBack()");
	}

}
