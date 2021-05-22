package com.oracle.cc.model;

import java.io.Serializable;

/**
 * @author Chiranjeevi Sutraye
 * This class is the base model class for all the model object 
 * which contains common properties
 * 
 */

public class BaseObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String _id;
	protected String name;
	protected String shortDescription;
	
	public BaseObject() {
		
	}
	
	public BaseObject(String name, String shortDescription) {
		this.name=name;
		this.shortDescription=shortDescription;
	}
	
	public BaseObject(String _id,String name, String shortDescription) {
		this.name=name;
		this.shortDescription=shortDescription;
	}
	
	public BaseObject(String id) {
		this._id=id;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
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
		BaseObject other = (BaseObject) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		return true;
	}
	
	
	
}
