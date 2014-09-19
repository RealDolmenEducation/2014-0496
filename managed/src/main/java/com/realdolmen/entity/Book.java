package com.realdolmen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import java.io.Serializable;

@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String author;
    private String isbn;
    
    @Version
    private int version;

    protected Book() {
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
		this.title = title;
	}

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
    
    public int getVersion() {
		return version;
	}
}
