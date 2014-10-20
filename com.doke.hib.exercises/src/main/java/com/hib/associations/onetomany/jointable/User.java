package com.hib.associations.onetomany.jointable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	@OneToMany(mappedBy="owner")
	private List<Item> itemsbought = new ArrayList<Item>();

	public Long getId() {
		return id;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Item> getItemsbought() {
		return itemsbought;
	}

	public void setItemsbought(List<Item> itemsbought) {
		this.itemsbought = itemsbought;
	}

	public User(String username) {
		super();
		this.username = username;
	}
	
	
	
	
	
}
