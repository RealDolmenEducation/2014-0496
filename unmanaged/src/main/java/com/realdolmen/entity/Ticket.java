package com.realdolmen.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal price;

	@ManyToOne(cascade = {CascadeType.ALL})
	private Passenger passenger;
	
	/**
	 * Used by JPA.
	 */
	@SuppressWarnings("unused")
	private Ticket() {
	}
	
	public Ticket(BigDecimal price) {
		this.price = price;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
		passenger.addTicket(this);
	}
	
	public Long getId() {
		return id;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
}
