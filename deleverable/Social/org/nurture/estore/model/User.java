package org.nurture.estore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity( name="Users")
public class User {

    @Id
    @GeneratedValue
    private Integer userId;
    
    
    private String username;

   
    private String password;
    
    @NotEmpty(message = "The email must not be null")
    @Column(name="email")
    private String userEmail;
    
    @NotEmpty(message = "The Mobile must not be null")
    @Column(name="mobile")
    private String userMobile;
    
    private boolean enabled;
    
    @Transient private Integer customerId;

    private Integer rolId; 
    
    public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    
	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", userEmail="
				+ userEmail + ", userMobile=" + userMobile + ", enabled=" + enabled + ", customerId=" + customerId
				+ ", rolId=" + rolId + "]";
	}

}
