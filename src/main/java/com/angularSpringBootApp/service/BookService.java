package com.angularSpringBootApp.service;

import java.util.List;

import com.angularSpringBootApp.model.Book;

public interface BookService {

	Book saveBook(Book book);

	List<Book> getAllBooks();

	List getGenreData();
	
}
