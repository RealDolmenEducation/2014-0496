package com.realdolmen.jms;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Test;

public class HelloWorldMDBJNDITest {
	@Test
	public void testTextMessage() throws Exception {
		Context jndiContext = new InitialContext();
		ConnectionFactory connectionFactory = (ConnectionFactory)
		jndiContext.lookup("jms/RemoteConnectionFactory");
		Queue queue = (Queue) jndiContext.lookup("jms/queue/test");
		Connection connection = connectionFactory.createConnection("admin", "password");
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(queue);
		TextMessage message = session.createTextMessage();
		message.setText("Hello World at " + new Date());
		producer.send(message);
		connection.close();
	}

}
