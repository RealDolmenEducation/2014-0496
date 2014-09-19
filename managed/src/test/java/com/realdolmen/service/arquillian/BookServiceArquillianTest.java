package com.realdolmen.service.arquillian;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.realdolmen.entity.Book;
import com.realdolmen.service.BookService;

@RunWith(Arquillian.class)
public class BookServiceArquillianTest extends ArquillianTest {
	
	@EJB	
	BookService bookService;
	
	 @Test
    public void testFindAllBooks() throws Exception {
        List<Book> books = bookService.findAllBooks();
        assertEquals("Nineteen Eighty Four", books.get(0).getTitle());
        assertEquals("Alice's Adventures In Wonderland", books.get(1).getTitle());
    }
}
