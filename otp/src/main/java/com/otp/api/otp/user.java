package com.otp.api.otp;	

import javax.persistence.Entity;

@Entity
public class user {
	private String username;
	private String toauthphone;

	

	public String getToauthphone() {
		return toauthphone;
	}

	public void setToauthphone(String toauthphone) {
		this.toauthphone = toauthphone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
