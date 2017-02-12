package org.nurture.estore.vo;

public class UserVO {

	private Integer id;
	private String name;
	private String type;
	private String email;
	private String mobile;
	private boolean isValid;
	
	public UserVO(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", type=" + type + ", email=" + email + ", mobile=" + mobile
				+ ", isValid=" + isValid + "]";
	}

	
	
}
