package com.hib.associations.manytomany.linkentity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	
	private String categoryname;
	
	@OneToMany(mappedBy="category")
	private Set<CategoryItem> catitemSet = new HashSet<CategoryItem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Set<CategoryItem> getCatitemSet() {
		return catitemSet;
	}

	public void setCatitemSet(Set<CategoryItem> catitemSet) {
		this.catitemSet = catitemSet;
	}

	public Category(String categoryname) {
		super();
		this.categoryname = categoryname;
	}
	
	
	
	
}
