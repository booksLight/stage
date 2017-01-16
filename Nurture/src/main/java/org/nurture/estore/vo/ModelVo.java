package org.nurture.estore.vo;

public class ModelVo {

	private String title;
	private String home;
	private String product;
	private String contact;
	private String register;
	private ModuleUserVo userVo;
	
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

	public ModuleUserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(ModuleUserVo userVo) {
		this.userVo = userVo;
	}
	
	
}
