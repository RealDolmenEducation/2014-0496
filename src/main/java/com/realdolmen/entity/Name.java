package com.realdolmen.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Name implements Serializable {
	private String firstName;
	private String lastName;
	
	/**
	 * Used by JPA.
	 */
	private Name() {
	}
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Name)) {
			return false;
		}
		Name other = (Name)o;		
		return this.firstName.equals(other.firstName)
				&& this.lastName.equals(other.lastName);
	}
	
	public int hashCode() {
		return this.firstName.hashCode() * this.lastName.hashCode() * 7;
	}
}
