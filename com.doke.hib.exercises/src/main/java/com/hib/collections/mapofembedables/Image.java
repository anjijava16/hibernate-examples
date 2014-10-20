package com.hib.collections.mapofembedables;

import javax.persistence.Embeddable;

@Embeddable
public class Image {

	private String imagename;
	private String size;
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((imagename == null) ? 0 : imagename.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Image other = (Image) obj;
		if (imagename == null) {
			if (other.imagename != null)
				return false;
		} else if (!imagename.equals(other.imagename))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Image(String imagename, String size) {
		super();
		this.imagename = imagename;
		this.size = size;
	}
	
	
	
	
	
}
