package com.realdolmen.service.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

public abstract class ArquillianTest {
	@Deployment
	public static Archive<?> createTestArchive() {
		JavaArchive archive = ShrinkWrap
			.create(JavaArchive.class, "test.jar")
			.addPackages(true, "com.realdolmen")
			.addAsResource("META-INF/persistence.xml",	"META-INF/persistence.xml")
			.addAsResource("import.sql", "import.sql");
		return archive;
	}
}
