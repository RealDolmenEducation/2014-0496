package com.realdolmen;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;

import com.realdolmen.entity.Passenger;
import com.realdolmen.entity.PassengerId;
import com.realdolmen.entity.Ticket;

public class TicketPersistenceTest extends PersistenceTest {
	@Test
	public void ticketCanBePersisted() {
		Ticket ticket = new Ticket(new BigDecimal("499.95"));
		entityManager().persist(ticket);						
	}
	
	@Test
	public void ticketCanBeAssignedWithAPassenger() {
		Ticket ticket = new Ticket(new BigDecimal("49.95"));
		Passenger janis = entityManager().find(Passenger.class, new PassengerId("Joplin", "00002"));
		ticket.setPassenger(janis);
		persistFlushAndClear(ticket);
		
		Ticket persistedTicket = entityManager().find(Ticket.class, ticket.getId());
		Assert.assertEquals("Janis", persistedTicket.getPassenger().getFirstName());
	}

	private void persistFlushAndClear(Ticket ticket) {
		entityManager().persist(ticket);
		entityManager().flush();
		entityManager().clear();
	}
	
	@Test
	public void ticketsCanBeRetrievedByPassengerName() {
		TypedQuery<Ticket> q = entityManager().createQuery(
			"select t from Ticket t where t.passenger.firstName = :fn and t.passenger.id.lastName = :ln",
			Ticket.class
		);
		q.setParameter("fn", "Janis");
		q.setParameter("ln", "Joplin");
		List<Ticket> tickets = q.getResultList();
		assertFalse(tickets.isEmpty());
	}
}
