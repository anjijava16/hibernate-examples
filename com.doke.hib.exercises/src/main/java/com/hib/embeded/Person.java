package com.hib.embeded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    long id;

	private String firstname;
	
	private String lastname;
	
	private Address address;
	
	
	
	@Embedded
	@AttributeOverrides({@AttributeOverride(name="mobileno",column=@Column(name="personmobile")),
		@AttributeOverride(name="email",column=@Column(name="personemail"))})
	private ContactDetails cdetails;

	public ContactDetails getCdetails() {
		return cdetails;
	}

	public void setCdetails(ContactDetails cdetails) {
		this.cdetails = cdetails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
