package org.nurture.estore.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface IMail {
	
	public void generateAndSendEmail() throws AddressException, MessagingException;
	public void generateAndSendFeedbacks(String sendto, String msg) throws AddressException, MessagingException;
}
