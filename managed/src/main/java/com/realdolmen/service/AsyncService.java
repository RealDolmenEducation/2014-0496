package com.realdolmen.service;

import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@Stateless
@Asynchronous
public class AsyncService {
	public Future<Integer> whatIsTheAnswerToLifeTheUniverseAndEverything() {
		System.out.println("Starting");
		for(int i=0; i< 10; i++) {
			System.out.println("Calculating...");
			slooow();
		}
		System.out.println("Done");
		return new AsyncResult<Integer>(42);
	}

	private void slooow() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			throw new RuntimeException("Who dare awaken me?", e);
		}
	}
}
