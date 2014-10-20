package com.hib.associations.onetomany.unidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany
	@JoinColumn(name="item_id_fk",nullable=false)
	private List<Bid> bids = new ArrayList<Bid>();

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

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	
	
	
}
