package com.realdolmen.service;

import java.util.List;

import javax.ejb.Remote;

import com.realdolmen.entity.Book;

@Remote
public interface BookService {
    List<Book> findAllBooks();
}

