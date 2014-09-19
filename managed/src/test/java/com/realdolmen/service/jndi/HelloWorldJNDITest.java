package com.realdolmen.service.jndi;

import static org.junit.Assert.assertEquals;

import javax.naming.InitialContext;

import org.junit.Test;

import com.realdolmen.service.HelloWorld;

public class HelloWorldJNDITest {
    @Test
    public void testSayHello() throws Exception {
    	
        InitialContext context = new InitialContext();
        HelloWorld helloBean = (HelloWorld) context.lookup("managed/HelloWorldBean!com.realdolmen.service.HelloWorld");
        String result = helloBean.sayHello("Jimi");
        assertEquals("Hello Jimi", result);
        
    }
}
