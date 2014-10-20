package com.hib.associations.onetomany.jointable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinTable(name="itemusermp"
	,joinColumns=@JoinColumn(name="item_id_fk",unique=true,nullable=false)
	,inverseJoinColumns=@JoinColumn(name="user_id_fk"))
	private User owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Item(String name, User owner) {
		super();
		this.name = name;
		this.owner = owner;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
