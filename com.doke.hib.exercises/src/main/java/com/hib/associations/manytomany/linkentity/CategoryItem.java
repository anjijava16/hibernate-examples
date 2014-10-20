package com.hib.associations.manytomany.linkentity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class CategoryItem {
	
	
	@Embeddable
	 public static class Id implements Serializable{
		
		@Column(name = "CATEGORY_ID")
		private Long categoryid;
		
		@Column(name = "ITEM_ID")
		private Long itemid;
		
		public Id() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Id(Long categoryid, Long itemid) {
			super();
			this.categoryid = categoryid;
			this.itemid = itemid;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((categoryid == null) ? 0 : categoryid.hashCode());
			result = prime * result
					+ ((itemid == null) ? 0 : itemid.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (categoryid == null) {
				if (other.categoryid != null)
					return false;
			} else if (!categoryid.equals(other.categoryid))
				return false;
			if (itemid == null) {
				if (other.itemid != null)
					return false;
			} else if (!itemid.equals(other.itemid))
				return false;
			return true;
		}
		
	}
	
	 @EmbeddedId
	 private Id id = new Id();
	 
	 private Date createDate = new Date();
	 
	 private String createdBy;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID",insertable=false,updatable=false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="ITEM_ID",insertable=false,updatable=false)
	private Item item;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public CategoryItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryItem(Date createDate, String createdBy, Category category,
			Item item) {
		super();
		
	    this.id.categoryid = category.getId();
        this.id.itemid = item.getId();
		
		this.createDate = createDate;
		this.createdBy = createdBy;
		
		this.category = category;
	    category.getCatitemSet().add(this);
	    
	    this.item = item;
	    item.getCatitemSet().add(this);
		
		
		
		
	}
	
	
	
	

}
