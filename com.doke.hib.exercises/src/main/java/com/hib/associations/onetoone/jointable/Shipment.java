package com.hib.associations.onetoone.jointable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Shipment {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(optional=false)
	@JoinTable(name = "shipitem", joinColumns = @JoinColumn(name = "SHIPMENT_ID_FK"), 
	inverseJoinColumns = @JoinColumn(name = "ITEM_ID_FK",unique=true,nullable=false))
	private Item item;
	
	
	private String shipMentName;
	
	
	public String getShipMentName() {
		return shipMentName;
	}

	public void setShipMentName(String shipMentName) {
		this.shipMentName = shipMentName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
