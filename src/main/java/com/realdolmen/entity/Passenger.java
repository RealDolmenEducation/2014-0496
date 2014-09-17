package com.realdolmen.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "passengers")
@SecondaryTable(name = "passenger_details")
@NamedQuery(name = Passenger.FIND_ALL, query = "select p from Passenger p")
public class Passenger {
	public static final String FIND_ALL = "Passenger.findAll";
	
	@EmbeddedId
	private PassengerId id;

	private String firstName;

	@Column(table = "passenger_details")
	private Integer frequentFlyerMiles;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(table = "passenger_details")
	private byte[] picture;

	/**
	 * Used by JPA.
	 */
	private Passenger() {
	}

	public Passenger(String firstName, String lastName, String socialSecurityNumber) {
		this.id = new PassengerId(firstName, socialSecurityNumber);
		this.firstName = firstName;
		this.frequentFlyerMiles = 0;
	}

	public String getSocialSecurityNumber() {
		return id.getSocialSecurityNumber();
	}

	public String getLastName() {
		return id.getLastName();
	}

	public String getFirstName() {
		return firstName;
	}

	public int getFrequentFlyerMiles() {
		return frequentFlyerMiles;
	}
}
