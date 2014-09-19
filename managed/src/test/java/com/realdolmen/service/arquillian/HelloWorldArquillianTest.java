package com.realdolmen.service.arquillian;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.realdolmen.service.HelloWorld;
import com.realdolmen.service.HelloWorldBean;

@RunWith(Arquillian.class)
public class HelloWorldArquillianTest {
	
	@EJB
	HelloWorld helloWorld;
	
	@Deployment
	public static Archive<?> createTestArchive() {
		JavaArchive archive = ShrinkWrap
				.create(JavaArchive.class, "test.jar")
				.addClasses(HelloWorld.class, HelloWorldBean.class);
		return archive;
	}
	
	 @Test
	    public void testSayHello() throws Exception {
	        String result = helloWorld.sayHello("Rand");
	        assertEquals("Hello Rand", result);
	    }
}
