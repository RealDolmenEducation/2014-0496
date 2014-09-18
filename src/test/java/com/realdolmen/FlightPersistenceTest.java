package com.realdolmen;

import org.junit.Assert;
import org.junit.Test;

import com.realdolmen.entity.Flight;

public class FlightPersistenceTest extends PersistenceTest {
	@Test
	public void flightCanBePersisted() {
		Flight flight = new Flight("FL00-14B", "JFK");
		entityManager().persist(flight);
		Assert.assertNotNull(flight.getId());
	}
}
