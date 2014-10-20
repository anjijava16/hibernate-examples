package com.hib.associations.manytomany.linkentity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String itemName;
	
	
	@OneToMany(mappedBy="item")
	private Set<CategoryItem> catitemSet = new HashSet<CategoryItem>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Set<CategoryItem> getCatitemSet() {
		return catitemSet;
	}


	public void setCatitemSet(Set<CategoryItem> catitemSet) {
		this.catitemSet = catitemSet;
	}


	public Item(String itemName) {
		super();
		this.itemName = itemName;
	}
	
	
	
	

}
