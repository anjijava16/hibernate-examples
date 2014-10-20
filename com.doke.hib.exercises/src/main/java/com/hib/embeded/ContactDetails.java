package com.hib.embeded;

import javax.persistence.Embeddable;


@Embeddable
public class ContactDetails {

	private String mobileno;
	private String email;
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
