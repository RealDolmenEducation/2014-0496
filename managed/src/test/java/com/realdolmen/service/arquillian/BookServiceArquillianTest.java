package com.realdolmen.service.arquillian;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.realdolmen.entity.Book;
import com.realdolmen.service.BookService;

@RunWith(Arquillian.class)
public class BookServiceArquillianTest {
	
	@EJB	
	BookService bookService;
	
	@Deployment
	public static Archive<?> createTestArchive() {
		JavaArchive archive = ShrinkWrap
				.create(JavaArchive.class, "test.jar")
				.addPackages(true, "com.realdolmen")
				.addAsResource("META-INF/persistence.xml",	"META-INF/persistence.xml")
				.addAsResource("import.sql", "import.sql");
		return archive;
	}
	
	 @Test
	    public void testFindAllBooks() throws Exception {
	        List<Book> books = bookService.findAllBooks();
	        assertEquals("Nineteen Eighty Four", books.get(0).getTitle());
	        assertEquals("Alice's Adventures In Wonderland", books.get(1).getTitle());
	    }
}
