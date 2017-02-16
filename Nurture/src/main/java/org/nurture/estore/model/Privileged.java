package org.nurture.estore.model;

import org.nurture.estore.Constants;

public enum Privileged {

	ADMIN (Constants.ADM_ID),   		// sum of order of used alphabets! (1+4+13+9+14)
	CUSTOMER (Constants.CUST_ID),  	// sum of order of used alphabets! (3+21+19+20+15+13+5+18)
	USER (Constants.USE_ID),   		// sum of order of used alphabets! (21+19+5+18)
	VISITOR (Constants.VIS_ID); 		// sum of order of used alphabets! (22+9+19+9+20+15+18)


	private final int accessCode;

	private Privileged(int accessCode) {
		this.accessCode = accessCode;
	}

	public int getAccessCode() {
		return accessCode;
	}
}
