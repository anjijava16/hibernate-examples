package com.hib.collections.bagofembedebles;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
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
	@org.hibernate.annotations.CollectionId(columns=@Column(name="IMAGEID"),
	type=@org.hibernate.annotations.Type(type = "long"),
	generator = "increment")
	private Collection<Image> images = new ArrayList<Image>();

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


	public Collection<Image> getImages() {
		return images;
	}


	public void setImages(Collection<Image> images) {
		this.images = images;
	}
	
	
	
	
	
}
