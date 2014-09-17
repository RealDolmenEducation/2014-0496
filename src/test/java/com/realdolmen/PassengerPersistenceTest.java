package com.realdolmen;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.realdolmen.entity.Passenger;

public class PassengerPersistenceTest extends PersistenceTest {
	@Test
	public void passengerCanBePersisted() {
		Passenger passenger = new Passenger("Jimi", "Hendrix", "00001");
		entityManager().persist(passenger);

		assertNotNull(passenger.getId());
	}
	
	@Test
	public void passengersCanBeRetrieved() {
		List<Passenger> passengers = entityManager().createNamedQuery(
					Passenger.FIND_ALL, Passenger.class).getResultList();

		assertEquals("Janis", passengers.get(0).getFirstName());
	}
}
