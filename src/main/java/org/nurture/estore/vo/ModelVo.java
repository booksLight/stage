package org.nurture.estore.vo;

public class ModelVo {

	private String title;
	private String home;
	private String product;
	private String contact;
	private String register;
	public boolean isCartEnable;
	
	private UserVO userVo;
	
	public ModelVo(){}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}

	public boolean isCartEnable() {
		return isCartEnable;
	}

	public void setCartEnable(boolean isCartEnable) {
		this.isCartEnable = isCartEnable;
	}
	
	public UserVO getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVO userVo) {
		this.userVo = userVo;
	}

	
	

	@Override
	public String toString() {
		return "ModelVo [title=" + title + ", home=" + home + ", product=" + product + ", contact=" + contact
				+ ", register=" + register + ", userVo=" + userVo + ", isCartEnable=" + isCartEnable + "]";
	}

	
	
	
}
