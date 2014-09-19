package com.realdolmen;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.junit.Test;

import com.realdolmen.entity.Address;
import com.realdolmen.entity.Passenger;
import com.realdolmen.entity.PassengerId;

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
	
	@Test
	public void passengerCanBeUpdate() {
		Passenger p = entityManager().find(Passenger.class, new PassengerId("Joplin", "00002"));
		
		entityManager().detach(p);
		
		p.setFrequentFlyerMiles(p.getFrequentFlyerMiles() + 5000);
	}
	
	
	@Test
	public void passengerNamesCanBeQueried() {
		CriteriaBuilder builder = entityManager().getCriteriaBuilder();
				
		CriteriaQuery<String> q = builder.createQuery(String.class);		
		
		// ... from Passenger p
		Root<Passenger> p = q.from(Passenger.class);				
		
		// select p.id.lastName ...
		q.select(p.get("id").get("lastName").as(String.class));
		q.where(builder.equal(p.get("firstName"), "Janis"));
				
		TypedQuery<String> query = entityManager().createQuery(q);
		List<String> names = query.getResultList();	
		assertEquals("Joplin", names.get(0));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
