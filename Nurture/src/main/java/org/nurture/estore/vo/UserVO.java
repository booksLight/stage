package org.nurture.estore.vo;

public class UserVO {

	private String name;
	private String type;
	private boolean isValid;
	
	public UserVO(){}

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

	@Override
	public String toString() {
		return "ModuleUserVo [name=" + name + ", type=" + type + ", isValid=" + isValid + "]";
	}
	
}
