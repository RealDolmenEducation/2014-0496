package com.realdolmen.service.jndi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.naming.InitialContext;

import org.junit.Test;

import com.realdolmen.entity.Book;
import com.realdolmen.service.BookService;

public class BookServiceJNDITest {
    @Test
    public void testFindAllBooks() throws Exception {
        InitialContext context = new InitialContext();
        BookService bookService = (BookService) context.lookup("managed/BookServiceBean!com.realdolmen.service.BookService");
        List<Book> books = bookService.findAllBooks();
        assertEquals("Nineteen Eighty Four", books.get(0).getTitle());
        assertEquals("Alice's Adventures In Wonderland", books.get(1).getTitle());
    }
}
