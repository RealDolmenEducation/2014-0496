package com.realdolmen;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.realdolmen.entity.Address;
import com.realdolmen.entity.Passenger;

public class PassengerPersistenceTest extends PersistenceTest {
	@Test
	public void passengerCanBePersisted() {
		Passenger passenger = newPassenger();
		entityManager().persist(passenger);
	}

	private Passenger newPassenger() {
		Passenger passenger = new Passenger(
			"Jimi",
			"Hendrix",
			"00001",
			newDate("1946-11-27"),
			new byte[] {15, 7, 83},
			new Address("Kattenberg", "37", "1620", "Huizingen")
		);
		return passenger;
	}

	/**
	 * Utility function to help create dates.
	 * @param value The date ISO pattern (2014-12-31) to parse.
	 * @return The newly created date.
	 */
	private Date newDate(String value) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(value);
		} catch(ParseException exception) {
			throw new IllegalArgumentException("Unable to parse date " + value, exception);
		}
	}

	@Test
	public void passengersCanBeRetrieved() {
		List<Passenger> passengers = entityManager().createNamedQuery(
					Passenger.FIND_ALL, Passenger.class).getResultList();

		assertEquals("Janis", passengers.get(0).getFirstName());
	}
	
	@Test
	public void passengerAgeIsCaclulatedCorrectly() {
		assertEquals(68, newPassenger().getAge());
	}
}
