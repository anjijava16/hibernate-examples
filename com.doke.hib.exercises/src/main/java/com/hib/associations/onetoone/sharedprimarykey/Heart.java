package com.hib.associations.onetoone.sharedprimarykey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Heart {
	@Id
	@GeneratedValue
	private Long id;
	
	
	private String heartName;
	
	@OneToOne(mappedBy="heart")
	private Body body;

	public String getHeartName() {
		return heartName;
	}

	public void setHeartName(String heartName) {
		this.heartName = heartName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Heart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Heart(Long id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((heartName == null) ? 0 : heartName.hashCode());
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
		Heart other = (Heart) obj;
		if (heartName == null) {
			if (other.heartName != null)
				return false;
		} else if (!heartName.equals(other.heartName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
}
