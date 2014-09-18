package com.realdolmen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String number;
	private String destination;
	
	/**
	 * Used by JPA.
	 */
	@SuppressWarnings("unused")
	private Flight() {		
	}
	
	public Flight(String number, String destination) {
		this.number = number;
		this.destination = destination;
	}

	public Long getId() {
		return id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getDestination() {
		return destination;
	}
}
