package com.hib.collections.mapofembedables;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	
	@ElementCollection
	@CollectionTable(name = "IMAGE")
	private Map<Filename,Image> images = new HashMap<Filename,Image>();

    private String itemName;
    
    
	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Map<Filename, Image> getImages() {
		return images;
	}


	public void setImages(Map<Filename, Image> images) {
		this.images = images;
	}



	
	
	
	
}
