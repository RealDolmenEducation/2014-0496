package com.realdolmen;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import com.realdolmen.entity.Book;

public class BookPersistenceTest extends PersistenceTest {
    @Test
    public void bookCanBePersisted() throws Exception {
        Book book = new Book("Animal Farm", "George Orwell", "0000000000001");
        entityManager().persist(book);
        assertNotNull(book.getId());
    }
    
    @Test
    public void bookIsVersioned() {
    	Book book = entityManager().find(Book.class, 1);
    	book.setTitle("new title");
    	entityManager().flush();
    	Assert.assertEquals(2, book.getVersion());
    }
}
