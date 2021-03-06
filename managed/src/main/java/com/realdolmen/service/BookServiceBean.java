package com.realdolmen.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.realdolmen.entity.Book;

@Stateless
public class BookServiceBean implements BookService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findAllBooks() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }
}
