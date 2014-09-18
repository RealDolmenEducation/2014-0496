package com.realdolmen.entity;

import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "passengers")
@SecondaryTable(name = "passenger_details")
@NamedQuery(name = Passenger.FIND_ALL, query = "select p from Passenger p")
public class Passenger {
	public static final String FIND_ALL = "Passenger.findAll";
	
	@EmbeddedId
	private PassengerId id;

	@Column(length = 50)
	private String firstName;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Transient
	private int age;
	
	@Embedded
	private Address address;

	@Column(table = "passenger_details")
	private Integer frequentFlyerMiles;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(table = "passenger_details")
	private byte[] picture;
	
	@OneToMany(mappedBy = "passenger")
	private Collection<Ticket> tickets;
	
	void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}

	/**
	 * Used by JPA.
	 */
	@SuppressWarnings("unused")
	private Passenger() {
	}

	public Passenger(String firstName, String lastName, String socialSecurityNumber, Date dateOfBirth, byte[] picture, Address address) {
		this.id = new PassengerId(lastName, socialSecurityNumber);
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.age = calculateAge();
		this.address = address;
		this.frequentFlyerMiles = 0;
		this.picture = picture;
	}

	private int calculateAge() {
		Calendar birthDate = Calendar.getInstance();
		birthDate.setTime(dateOfBirth);
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);		
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
	
	public Address getAddress() {
		return address;
	}
	
	public int getAge() {
		return age;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public Collection<Ticket> getTickets() {
		return Collections.unmodifiableCollection(tickets);
	}

	public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
		this.frequentFlyerMiles = frequentFlyerMiles;
	}
}
