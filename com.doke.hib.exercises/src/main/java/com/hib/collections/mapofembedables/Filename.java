package com.hib.collections.mapofembedables;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Filename {

    @Column(nullable = false) // Must be NOT NULL, part of PK!
    protected String name;

   
    public Filename() {
    }

    public Filename(String name) {
        this.name = name;
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Filename other = (Filename) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}




    // ...
}
