package com.realdolmen;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.realdolmen.entity.Book;

public class BookPersistenceTest extends PersistenceTest {
    @Test
    public void bookCanBePersisted() throws Exception {
        Book book = new Book("Animal Farm", "George Orwell", "0000000000001");
        entityManager().persist(book);
        assertNotNull(book.getId());
    }
}
