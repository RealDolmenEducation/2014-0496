package com.realdolmen.service;

import javax.ejb.Remote;

import com.realdolmen.entity.Book;

import java.util.List;

@Remote
public interface BookService {
    List<Book> findAllBooks();
}
