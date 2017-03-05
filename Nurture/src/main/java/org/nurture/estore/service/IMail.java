package org.nurture.estore.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface IMail {
	
	public void generateAndSendEmail() throws AddressException, MessagingException;
	public void registrationAcknowledgmet(String sendto, String msg) throws AddressException, MessagingException;
	
	public void orderReceipt(String sendto,  String customerName, String orderNo) throws AddressException, MessagingException;
}
