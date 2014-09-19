package com.realdolmen.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PassengerId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(length = 150)
	private String lastName;
	
	@Column(length = 20, nullable = false, updatable = false)
	private String socialSecurityNumber;
	
	/**
	 * Used by JPA.
	 */
	@SuppressWarnings("unused")
	private PassengerId() {
	}
	
	public PassengerId(String lastName, String socialSecurityNumber) {
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime
				* result
				+ ((socialSecurityNumber == null) ? 0 : socialSecurityNumber
						.hashCode());
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
		PassengerId other = (PassengerId) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (socialSecurityNumber == null) {
			if (other.socialSecurityNumber != null)
				return false;
		} else if (!socialSecurityNumber.equals(other.socialSecurityNumber))
			return false;
		return true;
	}
}
