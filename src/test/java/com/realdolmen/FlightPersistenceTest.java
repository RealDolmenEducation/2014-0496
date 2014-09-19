package com.realdolmen;

import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.Test;

import com.realdolmen.entity.Book;
import com.realdolmen.entity.Flight;

public class FlightPersistenceTest extends PersistenceTest {
	@Test
	public void flightCanBePersisted() {
		Flight flight = new Flight("FL00-14B", "JFK");
		entityManager().persist(flight);
		
		
		Book b = entityManager().find(Book.class, 1, LockModeType.PESSIMISTIC_READ);
		

		
		Assert.assertNotNull(flight.getId());
	}
	
	@Test
	public void flightCanBeRetrievedWithCriteriaQuery() {
		CriteriaBuilder builder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Object> q = builder.createQuery();
		Root<Flight> f = q.from(Flight.class);
		q.select(f.get("number"));
		q.where(builder.equal(f.get("number"), "ABC"));
		
		TypedQuery<Object> qq = entityManager().createQuery(q);
	}
}
