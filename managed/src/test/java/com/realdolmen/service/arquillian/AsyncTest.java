package com.realdolmen.service.arquillian;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ejb.EJB;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.realdolmen.service.AsyncService;

@RunWith(Arquillian.class)
public class AsyncTest extends ArquillianTest {
	@EJB
	AsyncService service; 
	
	@Test
	public void askTheMillionDollarQuestion() throws Exception, ExecutionException {
		Future<Integer> f = service.whatIsTheAnswerToLifeTheUniverseAndEverything();
		
		System.out.println("DOING SOME STUFF WHILE CALCULATING");
		///
		
		Integer result = f.get();
		Assert.assertEquals(42, result.intValue());
	}
}
