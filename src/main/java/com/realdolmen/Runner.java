package com.realdolmen;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.realdolmen.entity.Book;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("BookPu");
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(new Book("Ninteen Eighty Four", "George Orwell", "0000000000002"));
            transaction.commit();
        } finally {
            if(entityManager != null) {
                entityManager.close();
            }
            if(entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
