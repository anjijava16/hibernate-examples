package com.hib.associations.onetomany.bidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bid {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="item_id_fk")
	private Item item;
	
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
		
	}
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
	

}
