package com.hib.associations.onetoone.sharedprimarykey;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Body {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String bodyName;
	
	public String getBodyName() {
		return bodyName;
	}

	public void setBodyName(String bodyName) {
		this.bodyName = bodyName;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Heart heart;

	public Body(Long id, Heart heart) {
		super();
		this.id = id;
		this.heart = heart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Heart getHeart() {
		return heart;
	}

	public void setHeart(Heart heart) {
		this.heart = heart;
	}

	public Body() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bodyName == null) ? 0 : bodyName.hashCode());
		result = prime * result + ((heart == null) ? 0 : heart.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Body other = (Body) obj;
		if (bodyName == null) {
			if (other.bodyName != null)
				return false;
		} else if (!bodyName.equals(other.bodyName))
			return false;
		if (heart == null) {
			if (other.heart != null)
				return false;
		} else if (!heart.equals(other.heart))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}
