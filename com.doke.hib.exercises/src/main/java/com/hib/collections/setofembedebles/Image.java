package com.hib.collections.setofembedebles;

import javax.persistence.Embeddable;

@Embeddable
public class Image {

	private String imagename;
	private String filename;
	
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getFilename() {
		return filename;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((filename == null) ? 0 : filename.hashCode());
		result = prime * result
				+ ((imagename == null) ? 0 : imagename.hashCode());
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
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (imagename == null) {
			if (other.imagename != null)
				return false;
		} else if (!imagename.equals(other.imagename))
			return false;
		return true;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Image(String imagename, String filename) {
		super();
		this.imagename = imagename;
		this.filename = filename;
	}
	public Image() {
		super();
		
	}
	
	
	
}
