package com.hib.collections.setofembedeblesordreby;

import javax.persistence.Embeddable;

@Embeddable
public class Image {

	public Image(String imagename, String filename, Integer imagesize) {
		super();
		this.imagename = imagename;
		this.filename = filename;
		this.imagesize = imagesize;
	}
	@Override
	public String toString() {
		return "Image [imagename=" + imagename + ", filename=" + filename
				+ ", imagesize=" + imagesize + "]";
	}
	private String imagename;
	private String filename;
	private Integer imagesize;
	
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getFilename() {
		return filename;
	}
	

	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Integer getImagesize() {
		return imagesize;
	}
	public void setImagesize(Integer imagesize) {
		this.imagesize = imagesize;
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((filename == null) ? 0 : filename.hashCode());
		result = prime * result
				+ ((imagename == null) ? 0 : imagename.hashCode());
		result = prime * result
				+ ((imagesize == null) ? 0 : imagesize.hashCode());
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
		if (imagesize == null) {
			if (other.imagesize != null)
				return false;
		} else if (!imagesize.equals(other.imagesize))
			return false;
		return true;
	}

	
	
	
}
