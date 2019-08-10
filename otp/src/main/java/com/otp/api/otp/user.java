package com.otp.api.otp;	

import javax.persistence.Entity;

@Entity
public class user {
	private String phone;

	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}
	


}
