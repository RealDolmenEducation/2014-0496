package com.realdolmen.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Passenger.FIND_ALL, query = "select p from Passenger p")
public class Passenger {
	public static final String FIND_ALL = "Passenger.findAll";

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	
	private String socialSecurityNumber;
	
	@EmbeddedId
	private Name name;
	
	private int frequentFlyerMiles;
	
	/**
	 * Used by JPA.
	 */
	private Passenger() {
	}
	
	public Passenger(String firstName, String lastName, String socialSecurityNumber) {
		this.name = new Name(firstName, lastName);
		this.socialSecurityNumber = socialSecurityNumber;
		this.frequentFlyerMiles = 0;
	}

//	public Long getId() {
//		return id;
//	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public String getLastName() {
		return name.getLastName();
	}

	public String getFirstName() {
		return name.getFirstName();
	}

	public int getFrequentFlyerMiles() {
		return frequentFlyerMiles;
	}
}
