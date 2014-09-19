package com.realdolmen.service.arquillian;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.realdolmen.service.HelloWorld;

@RunWith(Arquillian.class)
public class HelloWorldArquillianTest extends ArquillianTest {
	
	@EJB
	HelloWorld helloWorld;
		
	@Test
    public void testSayHello() throws Exception {
        String result = helloWorld.sayHello("Rand");
        assertEquals("Hello Rand", result);
    }
}
